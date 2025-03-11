package fr.medab.repositories;
import fr.medab.models.CreditCard;

import java.util.List;

public interface CreditCardDataSource {
    List<CreditCard> getCreditCards();
    CreditCard getCreditCard(String serialNumber);
    void hashAllPins();
    String getBankName();
}
