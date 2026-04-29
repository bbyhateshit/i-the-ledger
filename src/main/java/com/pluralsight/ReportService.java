package com.pluralsight;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService {
    public static List<Transaction> monthToDate() {
        LocalDate now = LocalDate.now();
        YearMonth current = YearMonth.from(now);

        return TransactionService.getAll().stream()
                .filter(t -> YearMonth.from(t.getDate()).equals(current))
                .collect(Collectors.toList());
    }
}
