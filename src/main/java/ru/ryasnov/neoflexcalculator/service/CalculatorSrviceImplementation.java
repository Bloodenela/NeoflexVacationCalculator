package ru.ryasnov.neoflexcalculator.service;

import org.springframework.stereotype.Service;
import ru.ryasnov.neoflexcalculator.entities.Holidays;
import ru.ryasnov.neoflexcalculator.entities.Hollidays;
import ru.ryasnov.neoflexcalculator.errors.CalcException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

@Service
public class CalculatorSrviceImplementation implements CalculatorService {
    @Override
    public Integer calculating(LocalDate dateOfStart, Integer countOfDays, Integer averageSalary) throws CalcException {
        int tmp = countOfDays.intValue();
        Integer pay = exceptionsCheck(dateOfStart, countOfDays, averageSalary);
        if(pay!= null) return pay;

        for(int i = tmp; i>0; i--){
            if(checkWeekends(dateOfStart)||checkHolidays(dateOfStart)) countOfDays--;
            dateOfStart =dateOfStart.plusDays(1);
        }
        return paymentCalculating(countOfDays, averageSalary);
    }

     Integer exceptionsCheck(LocalDate dateOfStart, Integer countOfDays, Integer averageSalary) throws CalcException {
        if(countOfDays<0) throw new CalcException("Sorry, the new ones set the count of days less than zero");
        if(averageSalary<0) throw new CalcException("Sorry, the new ones set the value of salary less than zero");
        if(dateOfStart==null) return paymentCalculating(countOfDays, averageSalary);
        return null;
    }

     Integer paymentCalculating(Integer countOfDays, Integer averageSalary){
        return Integer.valueOf((int)(averageSalary/29.3 * countOfDays));
    }

     boolean checkWeekends(LocalDate date){
        DayOfWeek day = date.getDayOfWeek();
        return day.equals(DayOfWeek.SUNDAY) || day.equals(DayOfWeek.SATURDAY);
    }

     boolean checkHolidays(LocalDate date){
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
     boolean checkHolidays2(LocalDate date){
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        boolean res = true;
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
}
