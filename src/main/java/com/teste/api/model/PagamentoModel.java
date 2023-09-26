package com.teste.api.model;

import com.teste.api.dto.PagamentoDTO;
import com.teste.api.model.enums.MetodoPagamento;
import com.teste.api.model.enums.StatusPagamento;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "pagamentos")
public class PagamentoModel {

    public PagamentoModel(PagamentoDTO data) {
        this.codigoDebito = data.codigoDebito();
        this.tipoDocPagador = data.tipoDocPagador();
        this.metodoPagamento = data.metodoPagamento();
        this.valorPagamento = data.valorPagamento();
        this.numeroCartao = data.numeroCartao();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 25, nullable = false, updatable = false)
    private String codigoDebito;

    @Column(length = 14, nullable = false, updatable = false)
    private String tipoDocPagador;

    @Column(nullable = false, updatable = false)
    private MetodoPagamento metodoPagamento;

    @Column(length = 50, nullable = true, updatable = false)
    private String numeroCartao;

    @Column(length = 50, nullable = false, updatable = false)
    private String valorPagamento;

    @Enumerated(EnumType.STRING)
    @Nullable
    @Column(name = "status", nullable = false)
    private StatusPagamento statusPagamento;
}
