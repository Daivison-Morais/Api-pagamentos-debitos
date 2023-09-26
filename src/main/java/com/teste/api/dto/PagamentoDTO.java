package com.teste.api.dto;

import com.teste.api.model.enums.MetodoPagamento;
import com.teste.api.model.enums.StatusPagamento;

public record PagamentoDTO(
        String codigoDebito,
        String tipoDocPagador,
        MetodoPagamento metodoPagamento,
        String valorPagamento,
        String numeroCartao,
        StatusPagamento statusPagamento) {
}