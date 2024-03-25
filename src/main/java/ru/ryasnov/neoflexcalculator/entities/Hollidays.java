package ru.ryasnov.neoflexcalculator.entities;

import lombok.Getter;

import java.time.LocalDate;
import java.time.Month;

import static java.time.Month.*;
@Getter
public enum Hollidays {
    DEFENDERS_DAY(LocalDate.of(LocalDate.now().getYear(), 2, 23), null),
    WOMEN_DAY(LocalDate.of(LocalDate.now().getYear(), 3, 8), null),
    LABOR_DAY(LocalDate.of(LocalDate.now().getYear(), 5, 1), null),
    VICTORY_DAY(LocalDate.of(LocalDate.now().getYear(), 5, 8), LocalDate.of(LocalDate.now().getYear(), 5, 10)),
    NEW_YEAR(LocalDate.of(LocalDate.now().getYear(), 12, 31), LocalDate.of(LocalDate.now().getYear(), 1, 8)),
    INDEPENDENCE_DAY(LocalDate.of(LocalDate.now().getYear(), 6, 12), null);

    private final LocalDate dateStart;
    private final LocalDate dateEnd;

    Hollidays(LocalDate dateStart, LocalDate dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
}
