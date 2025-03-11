package fr.medab.services;

import fr.medab.models.BankNoteStock;
import fr.medab.models.BankNoteValue;

import java.util.Map;

public interface AutomatonATMService {
    boolean checkAvailabilityCache(int amount);
    boolean verifyJamCach();
    void loadBankNotes(BankNoteValue value, int quantity);
    int getTotalAmount();
    int getTotalQuantity(BankNoteValue value);
    int getTotalAmountForBankNoteValue(BankNoteValue value);
}
