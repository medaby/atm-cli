package fr.medab.services;

import fr.medab.models.BankAccount;

public interface AuthenticationCard {
    BankAccount checkCredentials(java.lang.String serialNumber, java.lang.String pin);
   //  void authenticate(CreditCard creditCard, String pin);
}
