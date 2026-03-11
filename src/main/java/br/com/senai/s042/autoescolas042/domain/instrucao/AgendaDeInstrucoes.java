package br.com.senai.s042.autoescolas042.domain.instrucao;

import br.com.senai.s042.autoescolas042.domain.aluno.Aluno;
import br.com.senai.s042.autoescolas042.domain.aluno.AlunoNaoExisteException;
import br.com.senai.s042.autoescolas042.domain.aluno.AlunoRepository;
import br.com.senai.s042.autoescolas042.domain.instrucao.validacoes.ValidadorAgendamento;
import br.com.senai.s042.autoescolas042.domain.instrutor.Instrutor;
import br.com.senai.s042.autoescolas042.domain.instrutor.InstrutorNaoExisteException;
import br.com.senai.s042.autoescolas042.domain.instrutor.InstrutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class AgendaDeInstrucoes {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private List<ValidadorAgendamento> validadorAgendamentos;

    @Transactional
    public DadosDetalhamentoInstrucao agendarInstrucao(DadosAgendamentoInstrucao dadosAgendamentoInstrucao){
       if (!alunoRepository.existsById(dadosAgendamentoInstrucao.idAluno())){
           throw new AlunoNaoExisteException("Id do aluno não encontrado!");
       }
       if (dadosAgendamentoInstrucao.idInstrutor() != null && !instrutorRepository.existsById(dadosAgendamentoInstrucao.idInstrutor())){
           throw new InstrutorNaoExisteException("Id do instrutor não encontrado!");
       }

       //Validacoes das regras de negocio
        validadorAgendamentos.forEach(v -> v.validar(dadosAgendamentoInstrucao));
        Aluno aluno = alunoRepository.getReferenceById(dadosAgendamentoInstrucao.idAluno());

        Instrutor instrutor = escolherInstrutor(dadosAgendamentoInstrucao);

        Instrucao instrucao = new Instrucao(
                null,
                aluno,
                instrutor,
                dadosAgendamentoInstrucao.data()
        );

        instrucaoRepository.save(instrucao);

        return new DadosDetalhamentoInstrucao(instrucao);
    }

    private Instrutor escolherInstrutor(DadosAgendamentoInstrucao dadosAgendamentoInstrucao) {

        if (dadosAgendamentoInstrucao.idInstrutor() != null) {

            return instrutorRepository.getReferenceById(dadosAgendamentoInstrucao.idInstrutor());
        }

        if(dadosAgendamentoInstrucao.especialidade() == null) {

            throw new EspecialidadeNaoInformadaException("Especialidade é obrigatoria quando o Instrutor não for informado!");
        }

        return instrutorRepository.escolherInstrutorAleatorioDisponivel(dadosAgendamentoInstrucao.especialidade(),dadosAgendamentoInstrucao.data());
    }
}