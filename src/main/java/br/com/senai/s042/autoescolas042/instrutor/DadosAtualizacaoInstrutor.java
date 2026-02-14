package br.com.senai.s042.autoescolas042.instrutor;

public record DadosAtualizacaoInstrutor(
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
