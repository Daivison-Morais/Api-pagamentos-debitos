package com.teste.api.dto;

public record PagamentoDTO(
    String codigoDebito,
    String cpfCnpj,
    String metodoPagamento,
    String numeroCartao,
    String valorPagamento) {
}
