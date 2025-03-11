package fr.medab.utils;
import fr.medab.models.Client;
import fr.medab.models.CreditCard;

public class ParserCreditCard {
    public static CreditCard parse(String[] values) {
        // Example parsing logic, adjust according to your CSV structure
        String accountNumber = values[2];
        String serialNumber = values[9];
        String accountHolder = values[6];
        String hashPin = values[10];
        String csv = values[8];

        String[] accountHolderParts = accountHolder.split(" ", 2);
        String firstName = accountHolderParts[0];
        String lastName = accountHolderParts.length > 1 ? accountHolderParts[1] : "";


        return new CreditCard.Builder()
                .accountNumber(accountNumber)
                .serialNumber(serialNumber)
                .hashPin(hashPin)
                .isBlocked(false)
                .owner(Client.Builder.builder().firstname(firstName).lastname(lastName).build())
                .type("VISA")
                .cvv(csv)
                .build();
    }
}
