package com.teste.api.model;

import com.teste.api.dto.PagamentoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PagamentoModel {

    public PagamentoModel(PagamentoDTO data) {
        this.codigoDebito = data.codigoDebito();
        this.cpfCnpj = data.cpfCnpj();
        this.metodoPagamento = data.metodoPagamento();
        this.valorPagamento = data.valorPagamento();
        this.numeroCartao = data.numeroCartao();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 6, nullable = false)
    private String codigoDebito;

    @Column(nullable = false)
    private String cpfCnpj;

    @Column(nullable = false)
    private String metodoPagamento;

    @Column(nullable = false)
    private String numeroCartao;

    @Column(nullable = false)
    private String valorPagamento;
}
