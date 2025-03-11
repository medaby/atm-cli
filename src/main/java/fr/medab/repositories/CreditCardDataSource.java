package fr.medab.repositories;

import fr.medab.models.BankAccount;
import fr.medab.models.CreditCard;

import java.util.List;

public interface CreditCardDataSource {
    List<CreditCard> getCreditCards();
    CreditCard getCreditCard(String accountNumber);
    void hashAllPins();
    String getBankName();
}
