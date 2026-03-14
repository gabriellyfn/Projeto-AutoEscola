package br.com.senai.s042.autoescolas042.domain.instrucao.validacoes;

import br.com.senai.s042.autoescolas042.domain.instrucao.DadosAgendamentoInstrucao;
import org.springframework.stereotype.Component;

@Component
public interface ValidadorAgendamento {
    void validar(DadosAgendamentoInstrucao dadosAgendamentoInstrucao);
}
