package br.com.senai.s042.autoescolas042.application.core.usecase;

import br.com.senai.s042.autoescolas042.adapter.in.controller.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.s042.autoescolas042.adapter.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.s042.autoescolas042.adapter.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.s042.autoescolas042.adapter.in.controller.response.instrutor.DadosListagemInstrutor;
import br.com.senai.s042.autoescolas042.application.core.domain.instrutor.Instrutor;
import br.com.senai.s042.autoescolas042.application.core.domain.instrutor.InstrutorRepository;
import br.com.senai.s042.autoescolas042.exception.types.instrutor.InstrutorNaoExisteException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstrutorService {
    private final InstrutorRepository repository;

    public InstrutorService(InstrutorRepository repository){
        this.repository = repository;
    }

    @Transactional
    public DadosDetalhamentoInstrutor cadastrar(DadosCadastroInstrutor dados) {
        Instrutor instrutor = new Instrutor(dados);
        repository.save(instrutor);
        return new DadosDetalhamentoInstrutor(instrutor);
    }

    public Page<DadosListagemInstrutor> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemInstrutor::new);
    }

    public DadosDetalhamentoInstrutor detalhar(Long id) {
        Instrutor instrutor = repository.findById(id)
                .orElseThrow(() -> new InstrutorNaoExisteException("ID do instrutor informado não existe"));
        return new DadosDetalhamentoInstrutor(instrutor);
    }

    @Transactional
    public DadosDetalhamentoInstrutor atualizar(DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
        repository.save(instrutor);
        return new DadosDetalhamentoInstrutor(instrutor);
    }

    @Transactional
    public void excluir(Long id){
        Instrutor instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        repository.save(instrutor);
    }
}
