package fr.medab.sources;

import fr.medab.models.BankAccount;
import fr.medab.models.Client;
import fr.medab.models.Currency;
import fr.medab.repositories.BankDataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileBankDataSource implements BankDataSource {
    private String fileDelimiter;
    private String bankName;
    private String filePath;

    public FileBankDataSource( String fileDelimiter, String bankName, String filePath) {
        this.fileDelimiter = fileDelimiter;
        this.bankName = bankName;
        this.filePath = filePath;
    }

    @Override
    public List<BankAccount> getAccounts() {
        List<BankAccount> accounts = new ArrayList<>();

        loaderSpider();

        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath != null ? this.filePath : "./src/main/resources/data/files/sg.csv"))) {
            // saute la 1er ligne qui contient les noms des colonnes
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(fileDelimiter);
                BankAccount account = parseAccount(values);
                accounts.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nFile loaded successfully.");
        return accounts;
    }

    private void loaderSpider() {
        System.out.print("\n Loading file, please wait");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 2000) {
                System.out.print(".");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        try {
            future.get(); // Wait for the loader to complete
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }

    private BankAccount parseAccount(String[] values) {
        // Example parsing logic, adjust according to your CSV structure
        String accountNumber = values[2];
        String accountType = values[3];
        String balanceRaw = values[4].replace(" ", "");
        double balance = Double.parseDouble(balanceRaw);
        String currencyRaw = values[5];
        String accountHolder = values[6];

        String[] currencyParts = currencyRaw.split(" ", 2);
        String currencyCode = currencyParts[0];
        String currencyName = currencyParts.length > 1 ? currencyParts[1] : "";

        String[] accountHolderParts = accountHolder.split(" ", 2);
        String firstName = accountHolderParts[0];
        String lastName = accountHolderParts.length > 1 ? accountHolderParts[1] : "";


        return new BankAccount.Builder()
                .accountNumber(accountNumber)
                .accountType(accountType)
                .owner(Client.Builder.builder().firstname(firstName).lastname(lastName).build())
                .balance(balance)
                .Currency(Currency.Builder.builder().code(currencyCode).symbol(currencyName).build())
                .build();
    }

    @Override
    public String getBankName() {
        return bankName;
    }

    @Override
    public BankAccount getAccount(String accountNumber) {
        return null;
    }
}
