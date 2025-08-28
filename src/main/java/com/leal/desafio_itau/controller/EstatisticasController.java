package com.leal.desafio_itau.controller;

import com.leal.desafio_itau.dto.EstatisticaResponseDTO;
import com.leal.desafio_itau.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<EstatisticaResponseDTO> estatisticas() {
        return ResponseEntity.ok().body(transacaoService.calcularEstatisticas());
    }
}
