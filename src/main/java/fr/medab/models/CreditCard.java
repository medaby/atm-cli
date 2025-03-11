package fr.medab.models;

import java.time.LocalDateTime;

public class CreditCard {
    private String accountNumber;
    private String serialNumber;
    private String hashPin;
    private boolean isBlocked;
    private Client owner;
    private String type;
    private String cvv;
    private LocalDateTime expirationDate;

    public CreditCard(String accountNumber, String serialNumber, String hashPin, boolean isBlocked, Client owner, String type, String cvv, LocalDateTime expirationDate) {
        this.accountNumber = accountNumber;
        this.serialNumber = serialNumber;
        this.hashPin = hashPin;
        this.isBlocked = isBlocked;
        this.owner = owner;
        this.type = type;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    private CreditCard(Builder builder) {
        accountNumber = builder.accountNumber;
        serialNumber = builder.serialNumber;
        hashPin = builder.hashPin;
        isBlocked = builder.isBlocked;
        owner = builder.owner;
        type = builder.type;
        cvv = builder.cvv;
        expirationDate = builder.expirationDate;
    }


    public static final class Builder {
        private String accountNumber;
        private String serialNumber;
        private String hashPin;
        private boolean isBlocked;
        private Client owner;
        private String type;
        private String cvv;
        private LocalDateTime expirationDate;

        public Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder accountNumber(String val) {
            accountNumber = val;
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


    public String getAccountNumber() {
        return accountNumber;
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
