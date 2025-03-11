package fr.medab.services;

import fr.medab.models.BankAccount;
import fr.medab.models.CreditCard;
import fr.medab.repositories.BankDataSource;
import fr.medab.repositories.CreditCardDataSource;

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
            return bankDataSource.findByAccountNumber(creditCard.getBankAccount().getAccountNumber());
        }
        return null;
    }

    @Override
    public void activateCard(String serialNumber, String pin) {
        CreditCard creditCard = creditCardDataSource.getCreditCard(serialNumber);
        if (creditCard.getHashPin().equals(pin)) {
            creditCard.setBlocked(false);
        }
    }
}
