package fr.medab.services;

import fr.medab.models.BankAccount;
import fr.medab.models.CreditCard;
import fr.medab.repositories.BankDataSource;
import fr.medab.repositories.CreditCardDataSource;
import fr.medab.utils.HashPin;
import fr.medab.utils.Printer;

public class AuthenticationCardImpl implements AuthenticationCard {
    private CreditCardDataSource creditCardDataSource;
    private BankDataSource bankDataSource;

    public AuthenticationCardImpl(CreditCardDataSource creditCardDataSource, BankDataSource bankDataSource) {
        this.creditCardDataSource = creditCardDataSource;
        this.bankDataSource = bankDataSource;
    }

    @Override
    public BankAccount checkCredentials(String serialNumber, String pin) {
        CreditCard creditCard = creditCardDataSource.getCreditCard(serialNumber);
        if (creditCard.getHashPin().equals(pin)) {
            return bankDataSource.findByAccountNumber(creditCard.getAccountNumber());
        }
        return null;
    }

    @Override
    public BankAccount authenticate(CreditCard creditCard, String pin) {
        if (creditCard != null && HashPin.validate(pin, creditCard.getHashPin())) {
            Printer.print(" ✅ Access granted...");
            System.out.println(creditCard.getAccountNumber());
            return bankDataSource.findByAccountNumber(creditCard.getAccountNumber());
        } else {
            Printer.error(" ⛔️ Invalid serial number or PIN.");
            return null;
        }
    }
}
