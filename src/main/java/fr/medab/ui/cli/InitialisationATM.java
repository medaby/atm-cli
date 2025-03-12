package fr.medab.ui.cli;

import fr.medab.models.AutomatonATM;
import fr.medab.models.BankAccount;
import fr.medab.models.BankNoteStock;
import fr.medab.models.BankNoteValue;
import fr.medab.services.AutomatonATMService;
import fr.medab.services.AutomatonATMServiceImpl;
import fr.medab.sources.FileBankDataSource;
import fr.medab.sources.FileCreditCardDatasource;
import fr.medab.utils.Printer;

import java.util.List;
import java.util.Map;

import static fr.medab.services.AutomatonATMServiceImpl.feedCashATM;

public class InitialisationATM {
    public static void chargementATM(String[] args) {
        // Default CSV file path
        String csvFilePath = "sg.csv";

        // Vérifie si un chemin de fichier CSV est passé en argument
        if (args.length > 0) {
            csvFilePath = args[0];
        }
        // Charge les billets de banque dans le GAB
        Map<BankNoteValue, BankNoteStock> bankNoteStocks = feedCashATM();
        // créer instance ATM
        AutomatonATM automatonATM = new AutomatonATM(bankNoteStocks);
        // Créer le service ATM
        AutomatonATMService atmService = new AutomatonATMServiceImpl(automatonATM);

        // Create FileBankDataSource instance
        FileBankDataSource dataSource =
                new FileBankDataSource(
                        ",",
                        "BankName","./src/main/resources/data/files/" + csvFilePath);

        // lit les comptes bancaires du fichier CSV
        List<BankAccount> accounts = dataSource.getAccounts();

        Printer.print("Toues les comptes sont chargé: " + accounts.size() + " Compte(s)" );
        // Use the service methods
        Printer.print("Montant Total Disponible du GAB: " + atmService.getTotalAmount());
        int amountToWithdraw = 500;
        if (atmService.checkAvailabilityCache(amountToWithdraw)) {
            Printer.print("Le montant de " + amountToWithdraw + " est disponible pour le retrait.");
        } else {
            Printer.print("Le montant de " + amountToWithdraw + " n'est pas disponible pour le retrait.");
        }

        // credit card gestion
        FileCreditCardDatasource creditCardDatasource = new FileCreditCardDatasource(
                ",",
                "BankName","./src/main/resources/data/files/" + csvFilePath);

        FileBankDataSource bankDataSource = new FileBankDataSource(
                ",",
                "BankName","./src/main/resources/data/files/" + csvFilePath);



//        HashAllPinsCLI cliHashAllPins = new HashAllPinsCLI(datasource);
//        cliHashAllPins.displayMenu();

        CreditCardCLI cli = new CreditCardCLI(creditCardDatasource, bankDataSource);
        cli.displayMenu();

        // Créer l'instance AutomatonATMClI
        AutomatonATMClI atmClI = new AutomatonATMClI(atmService, automatonATM);
        // Démarrer l'interface utilisateur
        atmClI.start();
    }

}
