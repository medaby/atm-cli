package fr.medab.ui.cli;

import fr.medab.models.CreditCard;
import fr.medab.sources.FileCreditCardDatasource;
import fr.medab.utils.HashPin;
import fr.medab.utils.Mask;
import fr.medab.utils.Printer;

import java.io.Console;
import java.io.IOException;
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

        System.out.print("Enter PIN: ");;
        String pin = readPin();

        System.out.println("\nSerial number: " + serialNumber);
        System.out.println("PIN: " + pin);
        CreditCard creditCard = datasource.getCreditCard(serialNumber);
        if (creditCard != null && HashPin.validate(pin, creditCard.getHashPin())) {
            Printer.print("✅ Access granted...");
            // Add further application logic here
        } else {
            Printer.error(" ⛔️ Invalid serial number or PIN.");
        }
    }

    private String readPin() {
       return Mask.apply();
    }

}
