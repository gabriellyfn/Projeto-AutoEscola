// esse controller um arquivo que faz a conexao/comunicacao com o front end
package br.com.senai.s042.autoescolas042.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Healthy-check")
public class HealthCheckController {

    @GetMapping
    public String HealthCheck(){
        return "Verificação de Integridade da API da Auto Escola S042, ok! ";
    }
}
