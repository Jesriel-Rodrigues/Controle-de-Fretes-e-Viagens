package com.fretes.lancamentofretes.models.exception;

public class BadRequestException extends RuntimeException{
    
    public BadRequestException(String msg) {
        super(msg);
    }
}
