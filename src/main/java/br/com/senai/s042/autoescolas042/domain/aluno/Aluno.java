package br.com.senai.s042.autoescolas042.domain.aluno;

public class Aluno {
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String endereco;

    public Aluno(DadosCadastroAluno dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = dados.endereco();
    }

    public String getNome() {
        return "";
    }

    public String getEmail() {
        return "";
    }

    public String getCpf() {
        return "";
    }
}
