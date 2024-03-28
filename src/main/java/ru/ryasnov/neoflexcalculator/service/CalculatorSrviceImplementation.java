package ru.ryasnov.neoflexcalculator.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryasnov.neoflexcalculator.entities.Holidays;
import ru.ryasnov.neoflexcalculator.entities.Hollidays;
import ru.ryasnov.neoflexcalculator.errors.CalcException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CalculatorSrviceImplementation implements CalculatorService {
    private final DaysOfRestService daysOfRestService;
    @Override
    public Integer calculating(LocalDate dateOfStart, Integer countOfDays, Integer averageSalary) throws CalcException {
        int tmp = countOfDays.intValue();
        Integer pay = fieldsCheck(dateOfStart, countOfDays, averageSalary);
        if(pay!= null) return pay;

        for(int i = tmp; i>0; i--){
            if(daysOfRestService.checkWeekends(dateOfStart)||daysOfRestService.checkHolidays(dateOfStart)) countOfDays--;
            dateOfStart =dateOfStart.plusDays(1);
        }
        return paymentCalculating(countOfDays, averageSalary);
    }

     Integer fieldsCheck(LocalDate dateOfStart, Integer countOfDays, Integer averageSalary) throws CalcException {
        if(countOfDays<0) throw new CalcException("Sorry, the new ones set the count of days less than zero");
        if(averageSalary<0) throw new CalcException("Sorry, the new ones set the value of salary less than zero");
        if(dateOfStart==null) return paymentCalculating(countOfDays, averageSalary);
        return null;
    }

     Integer paymentCalculating(Integer countOfDays, Integer averageSalary){
        return Integer.valueOf((int)(averageSalary/29.3 * countOfDays));
    }

}
