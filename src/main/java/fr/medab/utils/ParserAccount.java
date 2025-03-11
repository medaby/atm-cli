package fr.medab.utils;

import fr.medab.models.BankAccount;
import fr.medab.models.Client;
import fr.medab.models.Currency;

public class ParserAccount {

    public static BankAccount parse(String[] values) {
        // Example parsing logic, adjust according to your CSV structure
        String accountNumber = values[2];
        String accountType = values[3];
        String balanceRaw = values[4].replace(" ", "");
        double balance = Double.parseDouble(balanceRaw);
        String currencyRaw = values[5];
        String accountHolder = values[6];

        String[] currencyParts = currencyRaw.split(" ", 2);
        String currencyCode = currencyParts[0];
        String currencyName = currencyParts.length > 1 ? currencyParts[1] : "";

        String[] accountHolderParts = accountHolder.split(" ", 2);
        String firstName = accountHolderParts[0];
        String lastName = accountHolderParts.length > 1 ? accountHolderParts[1] : "";


        return new BankAccount.Builder()
                .accountNumber(accountNumber)
                .accountType(accountType)
                .owner(Client.Builder.builder().firstname(firstName).lastname(lastName).build())
                .balance(balance)
                .Currency(Currency.Builder.builder().code(currencyCode).symbol(currencyName).build())
                .build();
    }
}
