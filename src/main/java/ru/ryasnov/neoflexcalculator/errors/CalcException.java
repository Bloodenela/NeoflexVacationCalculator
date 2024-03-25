package ru.ryasnov.neoflexcalculator.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CalcException extends java.lang.Exception {
    public CalcException(String message){
        super(message);
    }
}
