package br.com.senai.s042.autoescolas042.domain.aluno;

import br.com.senai.s042.autoescolas042.domain.endereco.Endereco;
import br.com.senai.s042.autoescolas042.domain.instrutor.Especialidade;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Aluno")
@Table(name = "Alunos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
    private Boolean ativo = true;

    public Aluno(DadosCadastroAluno dadosAluno) {
        this.nome = dadosAluno.nome();
        this.email = dadosAluno.email();
        this.telefone = dadosAluno.telefone();
        this.cpf = dadosAluno.cpf();
        this.especialidade = dadosAluno.especialidade();
        this.endereco = new Endereco(dadosAluno.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoAluno dadosAtualizacaoAluno) {
        if (dadosAtualizacaoAluno.nome() != null && !dadosAtualizacaoAluno.nome().isBlank()) {
            this.nome = dadosAtualizacaoAluno.nome();
        } if (dadosAtualizacaoAluno.telefone() != null && !dadosAtualizacaoAluno.telefone().isBlank()) {
            this.telefone = dadosAtualizacaoAluno.telefone();
        } if (dadosAtualizacaoAluno.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizacaoAluno.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
