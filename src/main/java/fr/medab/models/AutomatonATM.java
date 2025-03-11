package fr.medab.models;

import java.util.HashMap;
import java.util.Map;

public class AutomatonATM {

    // stock de billet de banque
    private final Map<BankNoteValue, BankNoteStock> bankNoteStocks;

    public AutomatonATM(Map<BankNoteValue, BankNoteStock> bankNoteStocks) {
        this.bankNoteStocks = bankNoteStocks;
    }

    public Map<BankNoteValue, BankNoteStock> getBankNoteStocks() {
        return bankNoteStocks;
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (BankNoteStock stock : bankNoteStocks.values()) {
            totalAmount += stock.getBankNote().getValue().getValue() * stock.getQuantity();
        }
        return totalAmount;
    }
}
