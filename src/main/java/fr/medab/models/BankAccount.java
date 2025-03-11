package fr.medab.models;

public class BankAccount {
    private String accountNumber;
    private String accountType;
    private double balance;
    private Currency Currency;
    private Client owner;

    private BankAccount(Builder builder) {
        accountNumber = builder.accountNumber;
        accountType = builder.accountType;
        balance = builder.balance;
        Currency = builder.Currency;
        owner = builder.owner;
    }

    public static final class Builder {
        private String accountNumber;
        private String accountType;
        private double balance;
        private Currency Currency;
        private Client owner;

        public Builder() {
            // TODO document why this constructor is empty
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder accountNumber(String val) {
            accountNumber = val;
            return this;
        }

        public Builder accountType(String val) {
            accountType = val;
            return this;
        }

        public Builder balance(double val) {
            balance = val;
            return this;
        }

        public Builder Currency(Currency val) {
            Currency = val;
            return this;
        }

        public Builder owner(Client val) {
            owner = val;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return Currency;
    }

    public Client getOwner() {
        return owner;
    }

}
