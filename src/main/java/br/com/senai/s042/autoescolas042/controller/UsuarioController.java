package br.com.senai.s042.autoescolas042.controller;

import br.com.senai.s042.autoescolas042.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

   // @PostMapping
    // @Transactional
   // public String cadastrarUsuario(@RequestBody DadosCadastroUsuario dadosUsuario) {

    //}
}
