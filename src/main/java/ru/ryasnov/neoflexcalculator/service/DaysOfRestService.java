package ru.ryasnov.neoflexcalculator.service;

import java.time.LocalDate;

public interface DaysOfRestService {
    boolean checkHolidays(LocalDate date);
    boolean checkHolidays2(LocalDate date);
    boolean checkWeekends(LocalDate date);
}
