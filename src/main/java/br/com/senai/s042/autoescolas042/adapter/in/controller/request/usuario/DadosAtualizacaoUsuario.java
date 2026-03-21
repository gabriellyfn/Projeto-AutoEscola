package br.com.senai.s042.autoescolas042.adapter.in.controller.request.usuario;

import br.com.senai.s042.autoescolas042.application.core.domain.enums.Role;

public record DadosAtualizacaoUsuario(
        String id,
        String login,
        String senha,
        Role perfil) {
}
