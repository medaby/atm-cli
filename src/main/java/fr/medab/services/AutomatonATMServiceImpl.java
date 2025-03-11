package fr.medab.services;

import fr.medab.models.*;

import java.util.HashMap;
import java.util.Map;

public class AutomatonATMServiceImpl implements AutomatonATMService {

    private AutomatonATM automatonATM;

    public AutomatonATMServiceImpl(AutomatonATM automatonATM) {
        this.automatonATM = automatonATM;
    }

    @Override
    public boolean checkAvailabilityCache(int amount) {
        return automatonATM.getTotalAmount() >= amount;
    }

    @Override
    public boolean verifyJamCach() {
        return true;
    }

    @Override
    public void loadBankNotes(BankNoteValue value, int quantity) {
        BankNoteStock stock = automatonATM.getBankNoteStocks().get(value);
        stock.setQuantity(stock.getQuantity() + quantity);
    }

    @Override
    public int getTotalAmount() {
        int totalAmount = 0;
        for (BankNoteStock stock : automatonATM.getBankNoteStocks().values()) {
            totalAmount += stock.getBankNote().getValue().getValue() * stock.getQuantity();
        }
        return totalAmount;
    }

    @Override
    public int getTotalQuantity(BankNoteValue value) {
        return automatonATM.getBankNoteStocks().get(value).getQuantity();
    }

    @Override
    public int getTotalAmountForBankNoteValue(BankNoteValue value) {
        BankNoteStock stock = automatonATM.getBankNoteStocks().get(value);
        return stock.getBankNote().getValue().getValue() * stock.getQuantity();
    }


    public static Map<BankNoteValue, BankNoteStock> feedCashATM() {
        Map<BankNoteValue, BankNoteStock> bankNoteStocks = new HashMap<>();
        bankNoteStocks.put(BankNoteValue.TEN, bundleOfEuroBankNote(BankNoteValue.TEN, 100000));
        bankNoteStocks.put(BankNoteValue.TWENTY, bundleOfEuroBankNote(BankNoteValue.TWENTY,10000));
        bankNoteStocks.put(BankNoteValue.FIFTY, bundleOfEuroBankNote(BankNoteValue.FIFTY, 10000));
        bankNoteStocks.put(BankNoteValue.ONE_HUNDRED, bundleOfEuroBankNote(BankNoteValue.ONE_HUNDRED, 10000));
        bankNoteStocks.put(BankNoteValue.TWO_HUNDRED, bundleOfEuroBankNote(BankNoteValue.TWO_HUNDRED, 5000));
        bankNoteStocks.put(BankNoteValue.FIVE_HUNDRED, bundleOfEuroBankNote(BankNoteValue.FIVE_HUNDRED, 5000));
        return bankNoteStocks;
    }

    // liasse de billet en euro
    private static BankNoteStock bundleOfEuroBankNote(BankNoteValue value, int quantity) {
        Currency euro = new Currency("EURO", "€");
        return new BankNoteStock(new BankNote(value, euro), quantity);
    }
}
