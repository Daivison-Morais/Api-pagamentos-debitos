package com.teste.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.teste.api.dto.PagamentoDTO;
import com.teste.api.model.PagamentoModel;
import java.util.List;

import com.teste.api.repository.PagamentosRepository;

@Service
public class PagamentosService {

    @Autowired
    private PagamentosRepository repository;

    public List<PagamentoModel> listarPagamentos() {
        return repository.findAll();
    }

    public void criarPagamento(PagamentoDTO req) {

        repository.save(new PagamentoModel(req));
    }

}
