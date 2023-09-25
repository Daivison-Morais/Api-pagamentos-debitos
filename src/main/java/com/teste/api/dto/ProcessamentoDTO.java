package com.teste.api.dto;

import com.teste.api.model.enums.StatusPagamento;

public record ProcessamentoDTO(
        Long id,
        StatusPagamento statusPagamento) {
}
