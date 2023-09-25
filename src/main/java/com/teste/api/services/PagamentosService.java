package com.teste.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teste.api.controller.config.exception.ApiExceptionMessage;
import com.teste.api.dto.PagamentoDTO;
import com.teste.api.dto.ProcessamentoDTO;
import com.teste.api.model.PagamentoModel;
import com.teste.api.model.enums.StatusPagamento;
import com.teste.api.model.enums.TipoDocPagador;

import java.util.List;
import com.teste.api.repository.PagamentosRepository;

@Service
public class PagamentosService {

    @Autowired
    private PagamentosRepository repository;

    public List<PagamentoModel> listarPagamentos() {
        return repository.findAll();
    }

    public List<PagamentoModel> listarPorCodigoDebito(String codigoDebito) {
        return repository.findByCodigoDebito(codigoDebito);
    }

    public List<PagamentoModel> listarPorCpfCnpj(String cpfcnpj) {
        return repository.findByTipoDocPagador(cpfcnpj);
    }

    public List<PagamentoModel> listarPorStatus(StatusPagamento statusPagamento) {
        return repository.findByStatusPagamento(statusPagamento);
    }

    public void criarPagamento(PagamentoDTO req) {

        repository.save(new PagamentoModel(req));
    }

    public PagamentoModel deletarPagamento(Long id) throws ApiExceptionMessage {
        PagamentoModel pagamento = repository.findById(id).orElse(null);

        if (pagamento == null) {
            throw new ApiExceptionMessage(HttpStatus.BAD_REQUEST, "ID não encontrado");
        }

        System.out.println(pagamento.getStatusPagamento());
        if (!"PENDENTE".equals(pagamento.getStatusPagamento().toString())) {
            throw new ApiExceptionMessage(HttpStatus.BAD_REQUEST,
                    "Somente pagamentos pendentes podem ser deletados.");
        }

        System.out.println(pagamento.getStatusPagamento());

        repository.deleteById(id);

        return pagamento;
    }

    public void atualizarPagamento(Long id, ProcessamentoDTO req) {

        /*
         * System.out.println(repository.findById(id).map((dado) -> {
         * dado.setCodigoDebito(dado.getCodigoDebito());
         * dado.setCpfCnpj(dado.getCpfCnpj());
         * dado.setMetodoPagamento(dado.getMetodoPagamento());
         * dado.setNumeroCartao(dado.getNumeroCartao());
         * dado.setStatusPagamento("processado com sucesso");
         * 
         * }));
         */

    }

}
