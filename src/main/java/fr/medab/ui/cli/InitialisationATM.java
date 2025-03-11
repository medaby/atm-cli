package fr.medab.ui.cli;

import fr.medab.models.AutomatonATM;
import fr.medab.models.BankAccount;
import fr.medab.models.BankNoteStock;
import fr.medab.models.BankNoteValue;
import fr.medab.services.AutomatonATMService;
import fr.medab.services.AutomatonATMServiceImpl;
import fr.medab.sources.FileBankDataSource;

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

        // Code ANSI pour le texte vert
        String greenText = "\u001B[32m";
        String resetText = "\u001B[0m";

        System.out.println( greenText + "Toues les comptes sont chargé: " + accounts.size() + " Compte(s)" + resetText);
        // Use the service methods
        System.out.println(greenText + "Montant Total Disponible du GAB: " + atmService.getTotalAmount()+ resetText);
        int amountToWithdraw = 500;
        if (atmService.checkAvailabilityCache(amountToWithdraw)) {
            System.out.println("Le montant de " + amountToWithdraw + " est disponible pour le retrait.");
        } else {
            System.out.println("Le montant de " + amountToWithdraw + " n'est pas disponible pour le retrait.");
        }

        // Créer l'instance AutomatonATMClI
        AutomatonATMClI atmClI = new AutomatonATMClI(atmService, automatonATM);
        // Démarrer l'interface utilisateur
        atmClI.start();
    }

}
