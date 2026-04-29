package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    public static void appendTransaction(Transaction t) {

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = t.getTime().format(timeFormatter);

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.printf("%s|%s|%s|%s|%s%n",
                    t.getDate(),
                    formattedTime,
                    t.getDescription(),
                    t.getVendor(),
                    t.getAmount()
            );
        } catch (IOException e) {
            System.out.println("Error writing transaction: " + e.getMessage());
        }
    }
}