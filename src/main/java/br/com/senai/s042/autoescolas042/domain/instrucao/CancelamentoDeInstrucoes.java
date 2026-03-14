package br.com.senai.s042.autoescolas042.domain.instrucao;

import org.springframework.beans.factory.annotation.Autowired;

public class CancelamentoDeInstrucoes {
    @Autowired
    private InstrucaoRepository instrucaoRepository;

    public void cancelar(Long instrucaoID, String motivo) {


    }
}
