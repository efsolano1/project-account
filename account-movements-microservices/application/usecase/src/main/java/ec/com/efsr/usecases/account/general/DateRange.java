package ec.com.efsr.usecases.account.general;

import ec.com.efsr.exceptions.DateFormatException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateRange {
    private final LocalDateTime initialDate;
    private final LocalDateTime endDate;

    public DateRange(String dateRangeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String[] dates = dateRangeString.split("-");

        if (dates.length != 2) {
            throw new DateFormatException("Rango de fechas invalido.");
        }

        LocalDate initialDate = LocalDate.parse(dates[0], formatter);
        LocalDate endDate = LocalDate.parse(dates[1], formatter);

        this.initialDate = initialDate.atStartOfDay();
        this.endDate = endDate.atTime(23, 59, 59);
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}

