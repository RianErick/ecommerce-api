package com.curso.vendas.exception.regras;

import org.springframework.http.HttpStatus;

public class RegraNegocioExeption extends RuntimeException {

    public RegraNegocioExeption(HttpStatus status,String messege){
        super(messege);
    }
}
