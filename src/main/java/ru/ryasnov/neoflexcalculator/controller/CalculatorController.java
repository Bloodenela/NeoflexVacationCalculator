package ru.ryasnov.neoflexcalculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ryasnov.neoflexcalculator.errors.CalcException;
import ru.ryasnov.neoflexcalculator.service.CalculatorService;

import java.time.LocalDate;
@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;
    @GetMapping("/calculacte")
    public ResponseEntity<Integer> calculating(@RequestParam(required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfStart,
                                               @RequestParam Integer countOfDays, @RequestParam Integer averageSalary) throws CalcException{
        return new ResponseEntity<>(calculatorService.calculating(dateOfStart, countOfDays, averageSalary), HttpStatus.OK);
    }
}
