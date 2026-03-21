package br.com.senai.s042.autoescolas042.adapter.in.controller.response.instrutor;

import br.com.senai.s042.autoescolas042.application.core.domain.vo.Endereco;
import br.com.senai.s042.autoescolas042.application.core.domain.enums.Especialidade;
import br.com.senai.s042.autoescolas042.application.core.domain.instrutor.Instrutor;

public record DadosDetalhamentoInstrutor(
        Long id,
        String nome,
        String email,
        String telefone,
        String cnh,
        Especialidade especialidade,
        Endereco endereco) {
    public DadosDetalhamentoInstrutor(Instrutor instrutor) {
        this (
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getTelefone(),
                instrutor.getCnh(),
                instrutor.getEspecialidade(),
                instrutor.getEndereco()
        );
    }
}
