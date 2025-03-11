package fr.medab.sources;

import fr.medab.models.CreditCard;
import fr.medab.repositories.CreditCardDataSource;
import fr.medab.utils.CSVFileWriter;
import fr.medab.utils.ParserAccount;
import fr.medab.utils.ParserCreditCard;

import java.util.List;

import static fr.medab.utils.CSVFileReader.readCSVLineByField;

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
    public CreditCard getCreditCard(String serialNumber) {
        String[] values = readCSVLineByField(this.fileDelimiter, this.filePath, 9, serialNumber);
        if (values != null) {
            return ParserCreditCard.parse(values);
        }
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
