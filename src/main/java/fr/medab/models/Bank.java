package fr.medab.models;

import java.util.List;

public class Bank {

    private String name;
    private List<BankAccount> accounts;

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
