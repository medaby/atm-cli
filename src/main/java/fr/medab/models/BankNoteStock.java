package fr.medab.models;

public class BankNoteStock {
    private BankNote bankNote;
    private int quantity;

    public BankNoteStock(BankNote bankNote, int quantity) {
        this.bankNote = bankNote;
        this.quantity = quantity;
    }

    public BankNote getBankNote() {
        return bankNote;
    }

    public void setBankNote(BankNote bankNote) {
        this.bankNote = bankNote;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BankNoteStock{" +
                "bankNote=" + bankNote +
                ", quantity=" + quantity +
                '}';
    }
}
