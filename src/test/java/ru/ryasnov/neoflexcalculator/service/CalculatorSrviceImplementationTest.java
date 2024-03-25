package ru.ryasnov.neoflexcalculator.service;

import org.junit.jupiter.api.Test;
import ru.ryasnov.neoflexcalculator.errors.CalcException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorSrviceImplementationTest {
    private final CalculatorSrviceImplementation calculatorService = new CalculatorSrviceImplementation();

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
        assertThrows(CalcException.class, () -> calculatorService.exceptionsCheck(LocalDate.now(), -1, 1000));
        assertThrows(CalcException.class, () -> calculatorService.exceptionsCheck(LocalDate.now(), 10, -1000));
    }

    @Test
    public void testPaymentCalculating() {
        int result = calculatorService.paymentCalculating(10, 1000);
        assertEquals(341, result); // Предполагаемый результат для заданных значений
    }

    @Test
    public void testCheckWeekends() {
        assertFalse(calculatorService.checkWeekends(LocalDate.of(2022, 1, 3))); // Понедельник
        assertTrue(calculatorService.checkWeekends(LocalDate.of(2022, 1, 1))); // Суббота
    }
    @Test
    public void testCheckHolidays() {
        assertFalse(calculatorService.checkHolidays(LocalDate.of(2022, 3, 15))); // Не праздник
        assertTrue(calculatorService.checkHolidays(LocalDate.of(2022, 1, 1))); // Праздник
    }

    @Test
    public void testCheckHolidays2() {
        assertFalse(calculatorService.checkHolidays2(LocalDate.of(2022, 12, 3))); // Не праздник
        assertTrue(calculatorService.checkHolidays2(LocalDate.of(2022, 1, 1))); // Праздник
    }

}