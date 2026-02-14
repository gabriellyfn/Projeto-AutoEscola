package br.com.senai.s042.autoescolas042.instrutor;

// RECORD é imutável por padrão, classe imutavel

public record DadosEndereco(String logradouro,
                            String numero,
                            String complemento,
                            String bairro,
                            String cidade,
                            String uf,
                            String cep) {
}
