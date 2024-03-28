package ru.ryasnov.neoflexcalculator.service;

import org.springframework.stereotype.Service;
import ru.ryasnov.neoflexcalculator.entities.Holidays;
import ru.ryasnov.neoflexcalculator.entities.Hollidays;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

@Service
public class DaysOfRestServiceImplementation implements DaysOfRestService {
    @Override
    public boolean checkHolidays(LocalDate date){
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        Holidays holidays = new Holidays();
        for(Map.Entry<Integer,Month> holiday: holidays.getHOLIDAYS().entrySet()){
            Integer holidayDay = holiday.getKey();
            Month holidayMonth = holiday.getValue();
            if(holidayMonth.equals(month)&&holidayDay.equals(day)) return true;
        }
        return false;
    }
    //Второй способ расчета
    @Override
    public boolean checkHolidays2(LocalDate date){
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        for(Hollidays holiday: Hollidays.values()){
            if(holiday.getDateStart().getMonth().equals(month)){
                if(holiday.getDateEnd()!=null && day>=holiday.getDateStart().getDayOfMonth()) return true;
                else if(day==holiday.getDateStart().getDayOfMonth()) return true;
            }
            else if(holiday.getDateEnd() != null){
                if(holiday.getDateEnd().getMonth().equals(month) && day<=holiday.getDateEnd().getDayOfMonth()) return true;
            }
        }
        return false;
    }
    @Override
    public boolean checkWeekends(LocalDate date){
        DayOfWeek day = date.getDayOfWeek();
        return day.ordinal()>4;
    }
}
