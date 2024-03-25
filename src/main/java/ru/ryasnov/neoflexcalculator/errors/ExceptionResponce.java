package ru.ryasnov.neoflexcalculator.errors;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ExceptionResponce {
    private String message;
    private LocalDateTime dateTime;
}
