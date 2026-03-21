package br.com.senai.s042.autoescolas042.application.core.validation.instrucao.interfaces;

import br.com.senai.s042.autoescolas042.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import org.springframework.stereotype.Component;

@Component
public interface ValidadorAgendamento {
    void validar(DadosAgendamentoInstrucao dadosAgendamentoInstrucao);
}
