package br.com.senai.s042.autoescolas042.infra.exception;

import br.com.senai.s042.autoescolas042.domain.aluno.AlunoNaoExisteException;
import br.com.senai.s042.autoescolas042.domain.instrucao.InstrucaoNaoExisteException;
import br.com.senai.s042.autoescolas042.domain.instrucao.validacoes.ValidacaoException;
import br.com.senai.s042.autoescolas042.domain.instrutor.Instrutor;
import br.com.senai.s042.autoescolas042.domain.instrutor.InstrutorNaoExisteException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorGlobalDeExcecoes {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> tratarNotFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosBadRequest>> tratarBadRequest(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors= ex.getFieldErrors();
        return ResponseEntity.badRequest().body(fieldErrors.stream().map(DadosBadRequest::new).toList());
    }
    @ExceptionHandler(InstrutorNaoExisteException.class)
    public ResponseEntity tratarInstrutorNaoExisteException(InstrutorNaoExisteException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(AlunoNaoExisteException.class)
    public ResponseEntity tratarAlunoNaoExisteException(AlunoNaoExisteException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(InstrucaoNaoExisteException.class)
    public ResponseEntity tratarInstrucaoNaoExisteException(InstrutorNaoExisteException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    private record DadosBadRequest(String campo, String mensagem){
        public DadosBadRequest(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }

        @ExceptionHandler(ValidacaoException.class)
        public ResponseEntity<String> tratarValidacao(ValidacaoException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
