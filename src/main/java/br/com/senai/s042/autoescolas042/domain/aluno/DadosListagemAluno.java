package br.com.senai.s042.autoescolas042.domain.aluno;

import br.com.senai.s042.autoescolas042.domain.instrutor.Especialidade;

public record DadosListagemAluno(
        Long id,
        String nome,
        String email,
        String cpf,
        Boolean ativo,
        Especialidade especialidade) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getCpf(),
                aluno.getAtivo(),
                aluno.getEspecialidade()
        );
    }
}
