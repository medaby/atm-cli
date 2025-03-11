package fr.medab.ui.cli;

import fr.medab.models.CreditCard;
import fr.medab.services.AuthenticationCardImpl;
import fr.medab.sources.FileCreditCardDatasource;
import fr.medab.utils.Mask;

public class CreditCardCLI {
    private FileCreditCardDatasource datasource;

    public CreditCardCLI(FileCreditCardDatasource datasource) {
        this.datasource = datasource;
    }

    public void displayMenu() {
        System.out.print("Enter credit card serial number: ");
        String serialNumber = readSerialNumber();

        System.out.print("\nEnter PIN: ");
        String pin = readPin();

        System.out.println("\nSerial number: " + serialNumber);
        System.out.println("PIN: " + pin);


        CreditCard creditCard = datasource.getCreditCard(serialNumber);
        System.out.println(creditCard.getAccountNumber());
        AuthenticationCardImpl.authenticate(creditCard, pin);
    }



    private String readPin() {
       return Mask.apply();
    }

    private String readSerialNumber() {
        return Mask.upperCaseEntry();
    }

}
