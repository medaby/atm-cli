package fr.medab.repositories;

import fr.medab.models.BankAccount;

import java.util.List;

public interface BankDataSource {
    List<BankAccount> getAccounts();
    String getBankName();
    BankAccount getAccount(String accountNumber);
}
