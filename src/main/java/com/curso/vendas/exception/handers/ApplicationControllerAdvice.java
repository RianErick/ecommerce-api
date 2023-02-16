package com.curso.vendas.exception.handers;

import com.curso.vendas.exception.ClienteNullException;
import com.curso.vendas.exception.RegraNegocioExeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(RegraNegocioExeption.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public apiErrors handleRegraNegocioException(RegraNegocioExeption ex){
        String mensagemErro = ex.getMessage();
        return new apiErrors(mensagemErro);
    }
     @ExceptionHandler(ClienteNullException.class)
     @ResponseStatus(HttpStatus.NOT_FOUND)
     public apiClienteNull handleClienteNullException(ClienteNullException ex){
        String mensagemErro = ex.getMessage();
        return new apiClienteNull(mensagemErro);
    }


}
