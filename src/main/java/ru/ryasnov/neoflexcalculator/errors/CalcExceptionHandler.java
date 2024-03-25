package ru.ryasnov.neoflexcalculator.errors;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@ControllerAdvice
public class CalcExceptionHandler {
    @ExceptionHandler(value = CalcException.class)
    public ResponseEntity<ExceptionResponce> handleException(CalcException e){
        ExceptionResponce r = new ExceptionResponce();
        r.setMessage(e.getMessage());
        r.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(r, BAD_REQUEST);
    }

}
