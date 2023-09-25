package com.teste.api.dto;

import com.teste.api.model.enums.MetodoPagamento;
import com.teste.api.model.enums.StatusPagamento;
import com.teste.api.model.enums.TipoDocPagador;

public record PagamentoDTO(
        String codigoDebito,
        String tipoDocPagador,
        MetodoPagamento metodoPagamento,
        String valorPagamento,
        String numeroCartao,
        StatusPagamento statusPagamento) {
}