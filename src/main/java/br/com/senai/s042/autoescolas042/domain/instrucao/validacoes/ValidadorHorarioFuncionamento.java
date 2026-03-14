package br.com.senai.s042.autoescolas042.domain.instrucao.validacoes;

import br.com.senai.s042.autoescolas042.domain.instrucao.DadosAgendamentoInstrucao;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamento {

    int horarioAbertura = 6;
    int horarioFechamento = 21;

    @Override
    public void validar (DadosAgendamentoInstrucao dadosAgendamentoInstrucao){
        LocalDateTime dataAgendamento = dadosAgendamentoInstrucao.data();

        Boolean domingo = dataAgendamento.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        Boolean preAbertura = dataAgendamento.getHour() < horarioAbertura;
        Boolean posFechamento = dataAgendamento.getHour() > horarioFechamento;

        if (domingo || preAbertura || posFechamento){
            throw new ValidacaoException("Tentativa de agendamento inválida! Fora do horário de funcionamento");
        }
    }
}
