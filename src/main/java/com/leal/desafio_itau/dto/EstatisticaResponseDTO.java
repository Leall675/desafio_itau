package com.leal.desafio_itau.dto;

import lombok.AllArgsConstructor;

public record EstatisticaResponseDTO(
        long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {

}
