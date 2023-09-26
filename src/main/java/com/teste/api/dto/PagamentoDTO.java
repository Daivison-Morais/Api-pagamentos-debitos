package com.teste.api.dto;

import com.teste.api.model.enums.MetodoPagamento;

public record PagamentoDTO(
                String codigoDebito,
                String tipoDocPagador,
                MetodoPagamento metodoPagamento,
                String valorPagamento,
                String numeroCartao) {
}