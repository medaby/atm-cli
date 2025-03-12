package fr.medab.services;

import fr.medab.models.BankAccount;
import fr.medab.models.CreditCard;

public interface AuthenticationCard {
    BankAccount checkCredentials(java.lang.String serialNumber, java.lang.String pin);
    BankAccount authenticate(CreditCard creditCard, String pin);

}
