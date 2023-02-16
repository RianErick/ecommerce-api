package com.curso.vendas.exception;

import org.springframework.http.HttpStatus;

public class ClienteNullException extends RuntimeException{

 public ClienteNullException (HttpStatus status, String messege){
     super(messege);
 }

}
