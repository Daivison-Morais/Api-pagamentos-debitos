package com.teste.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.teste.api.controller.config.exception.ApiExceptionMessage;
import com.teste.api.model.PagamentoModel;
import com.teste.api.model.enums.StatusPagamento;
import com.teste.api.repository.PagamentosRepository;

@Service
public class AtualizaPagamentoService {

    @Autowired
    PagamentosRepository repository;

    public PagamentoModel atualizaPagamento(Long pagamentoId, StatusPagamento novoStatus) throws ApiExceptionMessage {
        PagamentoModel pagamento = repository.findById(pagamentoId).orElse(null);
        StatusPagamento statusPreAtualizacao = pagamento.getStatusPagamento();

        if (statusPreAtualizacao == StatusPagamento.SUCESSO) {
            throw new ApiExceptionMessage(HttpStatus.BAD_REQUEST, "Atualização não permitida!");

        } else if (statusPreAtualizacao == StatusPagamento.FALHA) {

            if (novoStatus != StatusPagamento.PENDENTE) {
                throw new ApiExceptionMessage(HttpStatus.BAD_REQUEST,
                        "Só pode ser alterado para pendente!");

            }
            pagamento.setStatusPagamento(novoStatus);
            repository.save(pagamento);
        } else if (statusPreAtualizacao == StatusPagamento.PENDENTE) {

            if (novoStatus == StatusPagamento.PENDENTE) {
                throw new ApiExceptionMessage(HttpStatus.BAD_REQUEST,
                        "Pagamento ja está cadastrado como pendente!");
            }

            pagamento.setStatusPagamento(novoStatus);

            return repository.save(pagamento);

        }

        return pagamento;

    }
}
