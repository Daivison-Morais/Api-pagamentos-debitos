package com.teste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.teste.api.model.PagamentoModel;
import com.teste.api.model.enums.StatusPagamento;

@Repository
public interface PagamentosRepository extends JpaRepository<PagamentoModel, Long> {
    List<PagamentoModel> findByCodigoDebito(String codigoDebito);

    List<PagamentoModel> findByTipoDocPagador(String cpfCnpj);

    List<PagamentoModel> findByStatusPagamento(StatusPagamento statusPagamento);

}
