package br.com.senai.s042.autoescolas042.adapter.in.controller.request.instrucao;

import br.com.senai.s042.autoescolas042.application.core.domain.enums.instrucao.MotivoCancelamento;

public record DadosCancelamentoInstrucao(
        Long idInstrucao,
        MotivoCancelamento motivo
) { }
