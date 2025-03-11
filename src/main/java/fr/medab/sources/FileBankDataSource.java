package fr.medab.sources;

import fr.medab.models.BankAccount;
import fr.medab.repositories.BankDataSource;
import fr.medab.utils.CSVFileReader;
import fr.medab.utils.Printer;
import fr.medab.utils.ParserAccount;
import fr.medab.utils.Spinner;
import java.util.ArrayList;
import java.util.List;

public class FileBankDataSource implements BankDataSource {
    private String fileDelimiter;
    private String bankName;
    private String filePath;

    public FileBankDataSource(String fileDelimiter, String bankName, String filePath) {
        this.fileDelimiter = fileDelimiter;
        this.bankName = bankName;
        this.filePath = filePath;
    }

    @Override
    public List<BankAccount> getAccounts() {
        List<BankAccount> accounts = new ArrayList<>();

        Spinner.load();

        List<String[]> records = CSVFileReader.readCSV(this.fileDelimiter, this.filePath);

        for (String[] values : records) {
            BankAccount account = ParserAccount.parse(values);
            accounts.add(account);
        }
        Printer.print("\nFile loaded successfully.");
        return accounts;
    }




    @Override
    public String getBankName() {
        return bankName;
    }

    public void updateAccountBalance(String accountNumber, double newBalance) {
        List<BankAccount> accounts = getAccounts();
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.setBalance(newBalance);
                break;
            }
        }
    }

    @Override
    public BankAccount findByAccountNumber(String accountNumber) {
        List<BankAccount> accounts = getAccounts();
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public BankAccount findOneByAccountNumber(String accountNumber) {
        String[] values = CSVFileReader.readCSVLineByField(this.fileDelimiter, this.filePath, 2, accountNumber);
        if (values != null) {
            return ParserAccount.parse(values);
        }
        return null;
    }


}
