package br.com.senai.s042.autoescolas042.domain.instrucao;

import br.com.senai.s042.autoescolas042.domain.aluno.AlunoRepository;
import br.com.senai.s042.autoescolas042.domain.instrucao.validacoes.ValidadorCancelamento;
import br.com.senai.s042.autoescolas042.domain.instrutor.InstrutorNaoExisteException;
import br.com.senai.s042.autoescolas042.domain.instrutor.InstrutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CancelamentoDeInstrucoes {

    private final InstrucaoRepository repository;
    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;
    private final List<ValidadorCancelamento> validadores;

    public CancelamentoDeInstrucoes(
            InstrucaoRepository repository,
            AlunoRepository alunoRepository,
            InstrutorRepository instrutorRepository,
            List<ValidadorCancelamento> validadores
    ) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
        this.instrutorRepository = instrutorRepository;
        this.validadores = validadores;
    }

    @Transactional
    public DadosDetalhamentoInstrucao cancelarInstrucao(DadosCancelamentoInstrucao dadosCancelamentoInstrucao) {
        Instrucao instrucao = repository.findById(dadosCancelamentoInstrucao.idInstrucao())
                .orElseThrow(() -> new InstrucaoNaoExisteException("Instrução não encontrada"));

        if (dadosCancelamentoInstrucao.motivo() == null) {
            throw new RuntimeException("Motivo deve ser preenchido!");
        }

        validadores.forEach(v -> v.validar(instrucao, dadosCancelamentoInstrucao));

        if (instrucao.getStatus() == StatusInstrucao.CANCELADA) {
            throw new RuntimeException("Instrução já está cancelada");
        }

        instrucao.setStatus(StatusInstrucao.CANCELADA);
        instrucao.setMotivoCancelamento(dadosCancelamentoInstrucao.motivo());
        repository.save(instrucao);

        return new DadosDetalhamentoInstrucao(instrucao);
    }
}
