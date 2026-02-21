package br.com.senai.s042.autoescolas042.controller;

import br.com.senai.s042.autoescolas042.domain.instrutor.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController // avisando o spring boot que e um controller
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutor>cadastrarInstrutor(
            @RequestBody DadosCadastroInstrutor dados,
            UriComponentsBuilder uribuilder) {// pro spring boot saber oq fazer com o metodo, cria-se uma requisicao
        Instrutor instrutor = new Instrutor(dados);
        repository.save(instrutor);
        URI uri = uribuilder.path("/instrutores/{id}")
                .buildAndExpand(instrutor.getId()).toUri();
        return ResponseEntity.created(uri)
                .body(new DadosDetalhamentoInstrutor(instrutor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listarInstrutores(
            @PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        Page<DadosListagemInstrutor> page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoInstrutor> detalharInstrutor(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoInstrutor(instrutor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutor> atualizarInstrutor(@RequestBody DadosAtualizacaoInstrutor dados){
        Instrutor instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
        repository.save(instrutor);
        return ResponseEntity.ok(new DadosDetalhamentoInstrutor(instrutor));
    }

    @DeleteMapping("/{id}") // Padrão de Mercado
    @Transactional
    public ResponseEntity<Void> excluirInstrutor(@PathVariable Long id){
        Instrutor instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        repository.save(instrutor);
        return ResponseEntity.noContent().build();
    }
}
