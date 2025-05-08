package com.leal.desafio_itau.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TransacaoDTO(
        @NotNull(message = "Valor deve ser preenchido")
        @Min(value = 0, message = "Valor deve ser maior ou igual a zero")
        Double valor,

        LocalDateTime dataHora
) {
}
