package br.com.senai.s042.autoescolas042.domain.instrucao.validacoes;

import br.com.senai.s042.autoescolas042.domain.instrucao.DadosCancelamentoInstrucao;
import br.com.senai.s042.autoescolas042.domain.instrucao.Instrucao;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaCancelamento implements ValidadorCancelamento{
    public void validar(Instrucao instrucao, DadosCancelamentoInstrucao dados) {

        if (Duration.between(LocalDateTime.now(), instrucao.getData()).toHours() < 24) {
            throw new RuntimeException("Cancelamento deve ter 24h de antecedência");
        }
    }
}
