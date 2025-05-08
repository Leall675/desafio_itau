package com.leal.desafio_itau.controller;

import com.leal.desafio_itau.dto.TransacaoDTO;
import com.leal.desafio_itau.model.Transacao;
import com.leal.desafio_itau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> salvar (@Valid @RequestBody TransacaoDTO transacaoDTO) {
        Transacao transacao = transacaoService.save(transacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> listarTransacoes() {
        List<TransacaoDTO> transacao = transacaoService.listarTransacoes();
        if (transacao.isEmpty()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(transacao);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTransacoes() {
        transacaoService.deletarTransacoes();
        return ResponseEntity.ok().build();
    }

}
