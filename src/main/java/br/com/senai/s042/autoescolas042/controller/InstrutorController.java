package br.com.senai.s042.autoescolas042.controller;

import br.com.senai.s042.autoescolas042.instrutor.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // avisando o spring boot que e um controller
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public String CadastrarInstrutor(@RequestBody DadosCadastroInstrutor dados) {// pro spring boot saber oq fazer com o metodo, cria-se uma requisicao
        Instrutor instrutor = new Instrutor(dados);
        repository.save(instrutor);
        return "Cadastro realizado com sucesso";
    }
    @GetMapping
    public List<DadosListagemInstrutor> listarInstrutores(){
        return repository.findAll().stream().map(DadosListagemInstrutor::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizarInstrutor(@RequestBody DadosAtualizacaoInstrutor dados){
        Instrutor instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
        repository.save(instrutor);
    }

    @DeleteMapping("/{id}")
    public void excluirInstrutor(@PathVariable Long id){
        repository.deleteById(id);
    }
}
