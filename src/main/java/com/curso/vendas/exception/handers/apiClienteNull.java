package com.curso.vendas.exception.handers;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class apiClienteNull {

    @Getter
    private List <String> erros;

    public apiClienteNull(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }
}
