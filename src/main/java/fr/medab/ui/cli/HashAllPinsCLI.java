package fr.medab.ui.cli;

import fr.medab.sources.FileCreditCardDatasource;

import java.util.Scanner;

public class HashAllPinsCLI {
    private FileCreditCardDatasource datasource;

    public HashAllPinsCLI(FileCreditCardDatasource datasource) {
        this.datasource = datasource;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Hash All PINs");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    datasource.hashAllPins();
                    System.out.println("All PINs have been hashed successfully.");
                    break;
                case 2:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
