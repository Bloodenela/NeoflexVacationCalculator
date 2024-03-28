package ru.ryasnov.neoflexcalculator.service;

import org.junit.jupiter.api.Test;
import ru.ryasnov.neoflexcalculator.errors.CalcException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorSrviceImplementationTest {
    private final DaysOfRestServiceImplementation daysOfRestService = new DaysOfRestServiceImplementation();
    private final CalculatorSrviceImplementation calculatorService = new CalculatorSrviceImplementation(daysOfRestService);

    @Test
    public void testCalculating() throws CalcException {
        LocalDate dateOfStart = LocalDate.of(2022, 1, 1);
        int countOfDays = 10;
        int averageSalary = 1000;

        int result = calculatorService.calculating(dateOfStart, countOfDays, averageSalary);

        assertEquals(34, result); // Предполагаемый результат для заданных значений
    }

    @Test
    public void testExceptionsCheck() {
        assertThrows(CalcException.class, () -> calculatorService.fieldsCheck(LocalDate.now(), -1, 1000));
        assertThrows(CalcException.class, () -> calculatorService.fieldsCheck(LocalDate.now(), 10, -1000));
    }

    @Test
    public void testPaymentCalculating() {
        int result = calculatorService.paymentCalculating(10, 1000);
        assertEquals(341, result); // Предполагаемый результат для заданных значений
    }

}