package fr.medab.models;

public class BankNote {
    private BankNoteValue value;
    private Currency currency;
    private String serialNumber;

    public BankNote(BankNoteValue value, Currency currency) {
        this.value = value;
        this.currency = currency;
        this.serialNumber = "SN" + (int) (Math.random() * 1000000);
    }

    public BankNoteValue getValue() {
        return value;
    }

    public void setValue(BankNoteValue value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "BankNote{" +
                "value=" + value +
                ", currency=" + currency +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
