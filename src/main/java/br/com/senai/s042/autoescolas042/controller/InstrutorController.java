package br.com.senai.s042.autoescolas042.controller;

import br.com.senai.s042.autoescolas042.domain.instrutor.*;
import jakarta.annotation.PreDestroy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController // avisando o spring boot que e um controller
@RequestMapping("/instrutores")
public class InstrutorController {

    private final InstrutorService service;

    public InstrutorController(InstrutorService service){
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<DadosDetalhamentoInstrutor>cadastrarInstrutor(
            @RequestBody DadosCadastroInstrutor dados,
            UriComponentsBuilder uribuilder) {// pro spring boot saber oq fazer com o metodo, cria-se uma requisicao
        DadosDetalhamentoInstrutor dto = service.cadastrar(dados);

        URI uri = uribuilder.path("/instrutores/{id}")
                .buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri)
                .body(dto);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Page<DadosListagemInstrutor>> listarInstrutores(
            @PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        return ResponseEntity.ok(service.listar(paginacao));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<DadosDetalhamentoInstrutor> detalharInstrutor(
            @PathVariable Long id) {
        DadosDetalhamentoInstrutor dto = service.detalhar(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<DadosDetalhamentoInstrutor> atualizarInstrutor(
            @RequestBody DadosAtualizacaoInstrutor dados){
        DadosDetalhamentoInstrutor dto = service.atualizar(dados);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}") // Padrão de Mercado
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Void> excluirInstrutor(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
