package com.teste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.api.model.PagamentosModel;

public interface PagamentosRepository extends JpaRepository<PagamentosModel, Long>{
    
}
