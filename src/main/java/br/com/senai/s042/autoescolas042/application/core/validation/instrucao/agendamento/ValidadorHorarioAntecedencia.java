package br.com.senai.s042.autoescolas042.application.core.validation.instrucao.agendamento;

import br.com.senai.s042.autoescolas042.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.s042.autoescolas042.application.core.validation.instrucao.interfaces.ValidadorAgendamento;
import br.com.senai.s042.autoescolas042.exception.types.instrucao.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamento {
    @Override
    public void validar(DadosAgendamentoInstrucao dadosAgendamentoInstrucao) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime horaAgendamento = dadosAgendamentoInstrucao.data();

        Long antecedencia = Duration.between(agora, horaAgendamento).toMinutes();

        if(antecedencia < 30){
            throw new ValidacaoException("Instrução deve ser agendada com antecedência mínima de 30min");
        }

    }
}
