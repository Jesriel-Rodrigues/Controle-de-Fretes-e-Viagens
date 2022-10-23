package com.fretes.lancamentofretes.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fretes.lancamentofretes.models.error.ErrorMessage;
import com.fretes.lancamentofretes.models.exception.BadRequestException;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> notFound( BadRequestException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.name(), status.value(), ex.getMessage());
        return new ResponseEntity<ErrorMessage>(error, status);
    }
}
