package com.teste.api.utils;

public class VerificaCpfCnpj {
    public String verificaCpf(String cpfCnpj) {
        String cpf = cpfCnpj;

        if (cpfCnpj.length() == 11) {
            return cpf;
        }
        return null;
    }

    public String verificaCnpj(String cpfCnpj) {
        String cnpj = cpfCnpj;

        if (cpfCnpj.length() == 14) {
            return cnpj;
        }
        return null;
    }
}
