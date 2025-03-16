package ec.com.efsr.usecases.account.general;

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
            throw new RuntimeException("Invalid date range format. Use yyyy/MM/dd-yyyy/MM/dd");
        }

        LocalDate startDate = LocalDate.parse(dates[0], formatter);
        LocalDate endDate = LocalDate.parse(dates[1], formatter);

        this.initialDate = startDate.atStartOfDay();
        this.endDate = endDate.atTime(23, 59, 59);
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}

