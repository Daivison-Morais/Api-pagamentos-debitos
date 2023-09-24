package com.teste.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.dto.PagamentoDTO;
import com.teste.api.model.PagamentoModel;
import com.teste.api.repository.PagamentosRepository;
import com.teste.api.services.PagamentosService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("api/hello")
public class PagamentosController {

    @Autowired
    private PagamentosService service;

    @GetMapping
    public List<PagamentoModel> listarPagamentos() {
        return service.listarPagamentos();
    }

    @PostMapping
    public void criarPagamento(@RequestBody PagamentoDTO req) {
        service.criarPagamento(req);
    }

}
