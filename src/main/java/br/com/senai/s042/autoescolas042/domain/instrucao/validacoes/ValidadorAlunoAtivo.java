package br.com.senai.s042.autoescolas042.domain.instrucao.validacoes;

import br.com.senai.s042.autoescolas042.domain.aluno.AlunoRepository;
import br.com.senai.s042.autoescolas042.domain.instrucao.DadosAgendamentoInstrucao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAlunoAtivo implements ValidadorAgendamento{
    @Autowired
    private AlunoRepository repository;

    @Override
    public void validar(DadosAgendamentoInstrucao dadosAgendamentoInstrucao){
        Boolean alunoAtivo = repository.findAtivoById(dadosAgendamentoInstrucao.idAluno());

        if(!alunoAtivo){
        throw new ValidacaoException("Agendamento não pode ser agendada com aluno inativo! ");
        }
    }
}
