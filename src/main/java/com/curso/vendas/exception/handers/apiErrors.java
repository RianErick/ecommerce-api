package com.curso.vendas.exception.handers;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;

public class apiErrors {

    @Getter
    private List<String> erros;

    public apiErrors(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }
}
