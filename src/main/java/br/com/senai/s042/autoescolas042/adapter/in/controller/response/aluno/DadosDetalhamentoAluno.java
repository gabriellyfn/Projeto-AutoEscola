package br.com.senai.s042.autoescolas042.adapter.in.controller.response.aluno;

import br.com.senai.s042.autoescolas042.application.core.domain.dto.DadosEndereco;
import br.com.senai.s042.autoescolas042.application.core.domain.enums.Especialidade;
import br.com.senai.s042.autoescolas042.application.core.domain.model.Aluno;

public record DadosDetalhamentoAluno(
        Long id,
        String nome,
        String email,
        String cpf,
        Boolean ativo,
        Especialidade especialidade) {

    public DadosDetalhamentoAlunos(Aluno aluno) {
        this(aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getCpf(),
                aluno.getAtivo(),
                aluno.getEspecialidade()
        );
    }
}

