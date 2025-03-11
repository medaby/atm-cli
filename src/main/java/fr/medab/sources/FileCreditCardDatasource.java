package fr.medab.sources;

import fr.medab.models.CreditCard;
import fr.medab.repositories.CreditCardDataSource;

import java.util.List;

public class FileCreditCardDatasource implements CreditCardDataSource {



    @Override
    public List<CreditCard> getCreditCards() {
        return null;
    }

    @Override
    public CreditCard getCreditCard(String accountNumber) {
        return null;
    }
}
