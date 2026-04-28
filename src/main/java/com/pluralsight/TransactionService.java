package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {

    public static void addDeposit(String description, String vendor, BigDecimal amount) {
        Transaction t = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                amount
        );
        FileService.appendTransaction(t);
    }
    public static void addPayment(String description, String vendor, BigDecimal amount) {
        Transaction t = new Transaction(
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                amount.negate()
        );
        FileService.appendTransaction(t);
    }
    public static List<Transaction> getAll() {
        return FileService.readTransactions()
                .stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                .collect(Collectors.toList());
    }
    public static List<Transaction> getDeposits() {
        return getAll().stream()
                .filter(t -> t.getAmount().compareTo(BigDecimal.ZERO) > 0)
                .collect(Collectors.toList());
    }
    public static List<Transaction> getPayments() {
        return getAll().stream()
                .filter(t -> t.getAmount().compareTo(BigDecimal.ZERO) < 0)
                .collect(Collectors.toList());
    }
}
