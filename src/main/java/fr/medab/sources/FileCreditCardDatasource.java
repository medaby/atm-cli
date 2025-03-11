package fr.medab.sources;

import fr.medab.models.CreditCard;
import fr.medab.repositories.CreditCardDataSource;
import fr.medab.utils.CSVFileWriter;
import java.util.List;

public class FileCreditCardDatasource implements CreditCardDataSource {
    private String fileDelimiter;
    private String bankName;
    private String filePath;

    public FileCreditCardDatasource(String fileDelimiter, String bankName, String filePath) {
        this.fileDelimiter = fileDelimiter;
        this.bankName = bankName;
        this.filePath = filePath;
    }

    @Override
    public List<CreditCard> getCreditCards() {
        return null;
    }

    @Override
    public CreditCard getCreditCard(String accountNumber) {
     return null;
    }

    @Override
    public String getBankName() {
        return bankName;
    }

    @Override
    public void hashAllPins() {
        CSVFileWriter.hashAllPins(this.fileDelimiter, this.filePath);
    }
}
