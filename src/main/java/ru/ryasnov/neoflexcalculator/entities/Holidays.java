package ru.ryasnov.neoflexcalculator.entities;

import lombok.Getter;

import java.time.Month;
import java.util.HashMap;

@Getter
public class Holidays {
    HashMap<Integer, Month> HOLIDAYS = new HashMap<>();

    public Holidays() {
        this.HOLIDAYS.put(23, Month.FEBRUARY);
        this.HOLIDAYS.put(8, Month.MARCH);
        this.HOLIDAYS.put(1, Month.MAY);
        this.HOLIDAYS.put(8, Month.MAY);
        this.HOLIDAYS.put(9, Month.MAY);
        this.HOLIDAYS.put(10, Month.MAY);
        this.HOLIDAYS.put(12, Month.JUNE);
        this.HOLIDAYS.put(31, Month.DECEMBER);
        this.HOLIDAYS.put(1, Month.JANUARY);
        this.HOLIDAYS.put(2, Month.JANUARY);
        this.HOLIDAYS.put(3, Month.JANUARY);
        this.HOLIDAYS.put(4, Month.JANUARY);
        this.HOLIDAYS.put(5, Month.JANUARY);
        this.HOLIDAYS.put(6, Month.JANUARY);
        this.HOLIDAYS.put(7, Month.JANUARY);
        this.HOLIDAYS.put(8, Month.JANUARY);
    }
}
