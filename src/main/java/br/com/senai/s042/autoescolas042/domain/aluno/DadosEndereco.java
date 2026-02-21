package br.com.senai.s042.autoescolas042.domain.aluno;

public record DadosEndereco(String Logradouro,
                            String numero,
                            String complemento,
                            String bairro,
                            String cidade,
                            String uf,
                            String cep) {
}
