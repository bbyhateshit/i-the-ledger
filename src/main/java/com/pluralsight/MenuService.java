package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    private static final Scanner scanner = new Scanner(System.in);

    public static void homeScreen() {
        while (true) {
            System.out.println("\n=== HOME ===");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    addDepositScreen();
                    break;
                case "P":
                    addPaymentScreen();
                    break;
                case "L":
                    ledgerScreen();
                    break;
                case "X":

                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addDepositScreen() {
        System.out.print("Description: ");
        String desc = scanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine());

        TransactionService.addDeposit(desc, vendor, amount);
    }

    private static void addPaymentScreen() {
        System.out.print("Description: ");
        String desc = scanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine());

        TransactionService.addPayment(desc, vendor, amount);
    }

    private static void ledgerScreen() {
        while (true) {
            System.out.println("\n=== LEDGER ===");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    display(TransactionService.getAll());
                    break;
                case "D":
                    display(TransactionService.getDeposits());
                    break;
                case "P":
                    display(TransactionService.getPayments());
                    break;
                case "R":
                    reportScreen();
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void reportScreen() {
        while (true) {
            System.out.println("\n=== REPORTS ===");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    display(ReportService.monthToDate());
                    break;
                case "2":
                    display(ReportService.previousMonth());
                    break;
                case "3":
                    display(ReportService.yearToDate());
                    break;
                case "4":
                    display(ReportService.previousYear());
                    break;
                case "5":
                    System.out.print("Vendor name: ");
                    display(ReportService.searchByVendor(scanner.nextLine()));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void display(List<Transaction> list) {
        System.out.println("\n--- RESULTS ---");
        list.forEach(System.out::println);
    }
}
