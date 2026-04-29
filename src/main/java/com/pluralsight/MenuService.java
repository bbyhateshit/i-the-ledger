package com.pluralsight;

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
}
