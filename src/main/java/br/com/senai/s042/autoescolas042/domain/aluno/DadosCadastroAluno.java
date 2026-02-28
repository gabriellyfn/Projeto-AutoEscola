package br.com.senai.s042.autoescolas042.domain.aluno;

import br.com.senai.s042.autoescolas042.domain.instrutor.Especialidade;
import br.com.senai.s042.autoescolas042.domain.endereco.DadosEndereco;

public record DadosCadastroAluno(
        String nome,
        String email,
        String telefone,
        String cpf,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
