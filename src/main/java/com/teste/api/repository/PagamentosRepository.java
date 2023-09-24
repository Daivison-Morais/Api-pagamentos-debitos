package com.teste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.api.model.PagamentoModel;

public interface PagamentosRepository extends JpaRepository<PagamentoModel, Long>{
    
}
