package fr.medab.services;

import fr.medab.models.BankAccount;

public interface AuthenticationCard {
    BankAccount checkCredentials(String serialNumber, String pin);
    void activateCard(String serialNumber, String pin);
}
