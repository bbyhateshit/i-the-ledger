package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private static final String FILE_PATH = "src/main/resources/transactions.csv";

    public static List<Transaction> readTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                Transaction t = new Transaction(
                        LocalDate.parse(parts[0]),
                        LocalTime.parse(parts[1]),
                        parts[2],
                        parts[3],
                        new BigDecimal(parts[4])
                );
                transactions.add(t);
            }
        } catch (IOException e) {
            System.out.println("Error reading transactions: " + e.getMessage());
        }
        return transactions;
    }
}