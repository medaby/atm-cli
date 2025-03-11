package fr.medab.ui.cli;

import fr.medab.models.CreditCard;
import fr.medab.sources.FileCreditCardDatasource;
import fr.medab.utils.HashPin;

import java.io.Console;
import java.util.Scanner;

public class CreditCardCLI {
    private FileCreditCardDatasource datasource;

    public CreditCardCLI(FileCreditCardDatasource datasource) {
        this.datasource = datasource;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card serial number: ");
        String serialNumber = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        CreditCard creditCard = datasource.getCreditCard(serialNumber);
        if (creditCard != null && HashPin.validate(pin, creditCard.getHashPin())) {
            System.out.println("Access granted.");
            // Add further application logic here
        } else {
            System.out.println("Invalid serial number or PIN.");
        }
    }
}
