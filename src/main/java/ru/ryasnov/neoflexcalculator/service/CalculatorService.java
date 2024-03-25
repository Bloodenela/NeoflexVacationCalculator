package ru.ryasnov.neoflexcalculator.service;

import ru.ryasnov.neoflexcalculator.errors.CalcException;

import java.time.LocalDate;

public interface CalculatorService {
    Integer calculating(LocalDate dateOfStart, Integer countOfDays, Integer averageSalary) throws CalcException;
}
