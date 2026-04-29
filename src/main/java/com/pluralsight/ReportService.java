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
    public static List<Transaction> previousMonth() {
        YearMonth prev = YearMonth.from(LocalDate.now()).minusMonths(1);

        return TransactionService.getAll().stream()
                .filter(t -> YearMonth.from(t.getDate()).equals(prev))
                .collect(Collectors.toList());
    }
    public static List<Transaction> yearToDate() {
        int year = LocalDate.now().getYear();

        return TransactionService.getAll().stream()
                .filter(t -> t.getDate().getYear() == year)
                .collect(Collectors.toList());
    }
    public static List<Transaction> previousYear() {
        int prevYear = LocalDate.now().getYear() - 1;

        return TransactionService.getAll().stream()
                .filter(t -> t.getDate().getYear() == prevYear)
                .collect(Collectors.toList());
    }
    public static List<Transaction> searchByVendor(String vendor) {
        return TransactionService.getAll().stream()
                .filter(t -> t.getVendor().equalsIgnoreCase(vendor))
                .collect(Collectors.toList());
    }
}
