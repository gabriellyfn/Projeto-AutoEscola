package br.com.senai.s042.autoescolas042.domain.instrucao.validacoes;

import br.com.senai.s042.autoescolas042.domain.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.s042.autoescolas042.domain.instrucao.Instrucao;

public interface ValidadorCancelamento {
    void validar(Instrucao instrucao, DadosCancelamentoInstrucao dados);
}
