package br.com.senai.s042.autoescolas042.adapter.in.controller.request.aluno;

import br.com.senai.s042.autoescolas042.application.core.domain.enums.Especialidade;
import br.com.senai.s042.autoescolas042.application.core.domain.dto.DadosEndereco;

public record DadosCadastroAluno(
        String nome,
        String email,
        String telefone,
        String cpf,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
