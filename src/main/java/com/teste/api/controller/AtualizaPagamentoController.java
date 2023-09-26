package com.teste.api.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.controller.config.response.ResponseHandler;
import com.teste.api.dto.ProcessamentoDTO;
import com.teste.api.model.PagamentoModel;
import com.teste.api.services.AtualizaPagamentoService;

@RestController
@RequestMapping("/api/processamento")
@CrossOrigin(origins = "*")
public class AtualizaPagamentoController {

    @Autowired
    public AtualizaPagamentoService service;

    @PutMapping
    public ResponseEntity<Object> atualizarProcessamentoDePagamento(
            @RequestBody ProcessamentoDTO processamento) {
        try {

            PagamentoModel pagamento = service.atualizaPagamento(processamento.id(),
                    processamento.statusPagamento());

            Map<String, String> response = new HashMap<>();

            if (pagamento == null) {
                response.put("error", "Id não existente!");

                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            return ResponseHandler.responseBuilder("Pagamento atualizado com sucesso!", HttpStatus.OK, pagamento);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

    }
}
