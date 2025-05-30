package com.leal.desafio_itau.service;

import com.leal.desafio_itau.dto.TransacaoDTO;
import com.leal.desafio_itau.model.Transacao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

@Service
public class TransacaoService {
    ConcurrentLinkedQueue<Transacao> queue = new ConcurrentLinkedQueue<>();

    public Transacao save(TransacaoDTO transacaoDTO) {
        validarTransacao(transacaoDTO);
        Transacao transacao = new Transacao(transacaoDTO.valor(), transacaoDTO.dataHora());
        queue.add(transacao);
        return transacao;

    }

    private void validarTransacao(TransacaoDTO transacaoDTO) {
        if (transacaoDTO.dataHora().isAfter(LocalDateTime.now())){
            throw new RuntimeException("Transação não pode ser feita em uma hora futura.");
        }
    }

    public List<TransacaoDTO> listarTransacoes() {
        return queue.stream()
                .map(t -> new TransacaoDTO(t.getValor(), t.getDataHora()))
                .collect(Collectors.toList());
    }

    public void deletarTransacoes() {
        queue.clear();
    }

}
