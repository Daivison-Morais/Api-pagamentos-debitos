package com.teste.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.teste.api.controller.config.response.ResponseHandler;
import com.teste.api.dto.PagamentoDTO;
import com.teste.api.dto.ProcessamentoDTO;
import com.teste.api.model.PagamentoModel;
import com.teste.api.model.enums.StatusPagamento;
import com.teste.api.model.enums.TipoDocPagador;
import com.teste.api.services.PagamentosService;

@RestController
@RequestMapping("api/pagamento")
public class PagamentosController {

    @Autowired
    public PagamentosService services;

    @GetMapping
    public List<PagamentoModel> listarPagamentos() {
        return services.listarPagamentos();
    }

    @GetMapping("filtro-codigoDebito/{codigoDebito}")
    public ResponseEntity<Object> listarPagamentosPorCodigoDebito(@PathVariable String codigoDebito) {

        List<PagamentoModel> pagamentos = services.listarPorCodigoDebito(codigoDebito);

        return ResponseHandler.responseBuilder("Pagamentos por código débito filtrados com sucesso", HttpStatus.OK,
                pagamentos);

    }

    @GetMapping("filtro-cpfCnpj/{cpfCnpj}")
    public ResponseEntity<Object> listarPagamentosPorCpfCnpj(@PathVariable String cpfCnpj) {

        List<PagamentoModel> pagamentos = services.listarPorCpfCnpj(cpfCnpj);

        return ResponseHandler.responseBuilder("Pagamentos por código débito filtrados com sucesso", HttpStatus.OK,
                pagamentos);

    }

    @GetMapping("filtro-status/{statusPagamento}")
    public ResponseEntity<Object> listarPagamentosPorStatus(@PathVariable StatusPagamento statusPagamento) {

        List<PagamentoModel> pagamentos = services.listarPorStatus(statusPagamento);

        return ResponseHandler.responseBuilder("Pagamentos por código débito filtrados com sucesso", HttpStatus.OK,
                pagamentos);

    }

    @PostMapping
    public void criarPagamento(@RequestBody PagamentoDTO req) {
        System.out.println("entrou no POST");
        services.criarPagamento(req);
    }

    @PutMapping("/{id}")
    public void atualizarPagamento(@PathVariable Long id, @RequestBody ProcessamentoDTO req) {
        services.atualizarPagamento(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPagamentoPorId(@PathVariable Long id) {

        try {
            PagamentoModel pagamento = services.deletarPagamento(id);

            return ResponseHandler.responseBuilder("Pagamento deletado com sucesso!", HttpStatus.OK, pagamento);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> error = new HashMap<>();

            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

    }

}
