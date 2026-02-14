package br.com.senai.s042.autoescolas042.instrutor;

public record DadosCadastroInstrutor(
        String nome,
        String email,
        String telefone,
        String cnh,
        Especialidade especialidade,
        DadosEndereco endereco) {
}
