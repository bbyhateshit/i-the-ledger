package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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
}
