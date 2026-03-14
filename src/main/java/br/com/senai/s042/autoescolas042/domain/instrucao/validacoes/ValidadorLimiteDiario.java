package br.com.senai.s042.autoescolas042.domain.instrucao.validacoes;

import br.com.senai.s042.autoescolas042.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.s042.autoescolas042.domain.instrucao.InstrucaoRepository;
import br.com.senai.s042.autoescolas042.domain.instrutor.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorLimiteDiario implements ValidadorAgendamento{
    @Autowired
    private InstrucaoRepository repository;

    @Override
    public void validar(DadosAgendamentoInstrucao dadosAgendamentoInstrucao){
        LocalDateTime inicioExpediente = dadosAgendamentoInstrucao.data().withHour(6);

        LocalDateTime fimExpediente = dadosAgendamentoInstrucao.data().withHour(21 -1);

        Boolean reincidenciaDiaria = repository.existsByAlunoIdAndDataBetween(
                dadosAgendamentoInstrucao.idAluno(),
                inicioExpediente,
                fimExpediente);

        if(reincidenciaDiaria){
            throw new ValidacaoException("Permitido o agendamento de apenas uma instrução diária por aluno");

        }
    }
}
