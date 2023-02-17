package com.curso.vendas.exception.handers;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;

public class apiRegraNegocio {

    @Getter
    private List<String> erros;

    public apiRegraNegocio(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }
}
