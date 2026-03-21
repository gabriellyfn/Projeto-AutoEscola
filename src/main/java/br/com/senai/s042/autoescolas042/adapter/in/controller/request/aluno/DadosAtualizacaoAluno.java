package br.com.senai.s042.autoescolas042.adapter.in.controller.request.aluno;

import br.com.senai.s042.autoescolas042.application.core.domain.dto.DadosEndereco;

public record DadosAtualizacaoAluno(
        String id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
