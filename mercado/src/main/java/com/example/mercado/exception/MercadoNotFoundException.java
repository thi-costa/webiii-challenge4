package com.example.mercado.exception;

public class MercadoNotFoundException extends RuntimeException{

    public MercadoNotFoundException(String message) {
        super(message);
    }
}
