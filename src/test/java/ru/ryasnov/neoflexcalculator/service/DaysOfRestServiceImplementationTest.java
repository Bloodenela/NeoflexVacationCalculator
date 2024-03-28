package ru.ryasnov.neoflexcalculator.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class DaysOfRestServiceImplementationTest {
    private final DaysOfRestServiceImplementation daysOfRestService = new DaysOfRestServiceImplementation();

    @Test
    public void testCheckWeekends() {
        assertFalse(daysOfRestService.checkWeekends(LocalDate.of(2022, 1, 3))); // Понедельник
        assertTrue(daysOfRestService.checkWeekends(LocalDate.of(2022, 1, 1))); // Суббота
    }
    @Test
    public void testCheckHolidays() {
        assertFalse(daysOfRestService.checkHolidays(LocalDate.of(2022, 3, 15))); // Не праздник
        assertTrue(daysOfRestService.checkHolidays(LocalDate.of(2022, 1, 1))); // Праздник
    }

    @Test
    public void testCheckHolidays2() {
        assertFalse(daysOfRestService.checkHolidays2(LocalDate.of(2022, 12, 3))); // Не праздник
        assertTrue(daysOfRestService.checkHolidays2(LocalDate.of(2022, 1, 1))); // Праздник
    }

}