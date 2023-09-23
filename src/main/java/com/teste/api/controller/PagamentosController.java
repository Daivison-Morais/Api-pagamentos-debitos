package com.teste.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.dto.PagamentoDTO;
import com.teste.api.model.PagamentosModel;
import com.teste.api.repository.PagamentosRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
@RequestMapping("api/hello")
public class PagamentosController {

       @Autowired
    private PagamentosRepository repository;

    @GetMapping
    public List<PagamentosModel> listarPagamentos() {
        return repository.findAll();
    }

    @PostMapping
    public void salvarPagamento(@RequestBody PagamentoDTO req) {

        repository.save(new PagamentosModel(req));
        System.out.println("entrou no post");
    }

}
