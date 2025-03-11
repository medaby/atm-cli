package fr.medab.models;

import java.time.LocalDateTime;

public class CreditCard {
    private BankAccount bankAccount;
    private String serialNumber;
    private String hashPin;
    private boolean isBlocked;
    private Client owner;
    private String type;
    private String cvv;
    private LocalDateTime expirationDate;

    public CreditCard(BankAccount bankAccount, String serialNumber, String hashPin, boolean isBlocked, Client owner, String type, String cvv, LocalDateTime expirationDate) {
        this.bankAccount = bankAccount;
        this.serialNumber = serialNumber;
        this.hashPin = hashPin;
        this.isBlocked = isBlocked;
        this.owner = owner;
        this.type = type;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    private CreditCard(Builder builder) {
        bankAccount = builder.bankAccount;
        serialNumber = builder.serialNumber;
        hashPin = builder.hashPin;
        isBlocked = builder.isBlocked;
        owner = builder.owner;
        type = builder.type;
        cvv = builder.cvv;
        expirationDate = builder.expirationDate;
    }


    public static final class Builder {
        private BankAccount bankAccount;
        private String serialNumber;
        private String hashPin;
        private boolean isBlocked;
        private Client owner;
        private String type;
        private String cvv;
        private LocalDateTime expirationDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder bankAccount(BankAccount val) {
            bankAccount = val;
            return this;
        }

        public Builder serialNumber(String val) {
            serialNumber = val;
            return this;
        }

        public Builder hashPin(String val) {
            hashPin = val;
            return this;
        }

        public Builder isBlocked(boolean val) {
            isBlocked = val;
            return this;
        }

        public Builder owner(Client val) {
            owner = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder cvv(String val) {
            cvv = val;
            return this;
        }

        public Builder expirationDate(LocalDateTime val) {
            expirationDate = val;
            return this;
        }

        public CreditCard build() {
            return new CreditCard(this);
        }
    }


    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getHashPin() {
        return hashPin;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public Client getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public String getCvv() {
        return cvv;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
