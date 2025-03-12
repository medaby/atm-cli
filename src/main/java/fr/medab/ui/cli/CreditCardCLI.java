package fr.medab.ui.cli;

import fr.medab.models.BankAccount;
import fr.medab.models.CreditCard;
import fr.medab.services.AuthenticationCard;
import fr.medab.services.AuthenticationCardImpl;
import fr.medab.sources.FileBankDataSource;
import fr.medab.sources.FileCreditCardDatasource;
import fr.medab.utils.Mask;

public class CreditCardCLI {
    private FileCreditCardDatasource creditCardDatasource;
    private FileBankDataSource bankDataSource;

    public CreditCardCLI(FileCreditCardDatasource creditCardDatasource, FileBankDataSource bankDataSource) {
        this.creditCardDatasource = creditCardDatasource;
        this.bankDataSource = bankDataSource;
    }

    public void displayMenu() {
        System.out.print("Enter credit card serial number: ");
        String serialNumber = readSerialNumber();

        System.out.print("\nEnter PIN: ");
        String pin = readPin();

        System.out.println("\nSerial number: " + serialNumber);
        System.out.println("PIN: " + pin);

        AuthenticationCard authenticationCard = new AuthenticationCardImpl(creditCardDatasource, bankDataSource);
        CreditCard creditCard = creditCardDatasource.getCreditCard(serialNumber);
        BankAccount bankAccount = authenticationCard.authenticate(creditCard, pin);
        if (bankAccount == null) {
            System.out.println(" 👋🏼 Aurevoir !!!!");
           System.exit(0);
        }
    }



    private String readPin() {
       return Mask.apply();
    }

    private String readSerialNumber() {
        return Mask.upperCaseEntry();
    }

}
