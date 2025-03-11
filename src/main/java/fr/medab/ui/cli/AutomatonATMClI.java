package fr.medab.ui.cli;

import fr.medab.models.AutomatonATM;
import fr.medab.models.BankNoteValue;
import fr.medab.services.AutomatonATMService;
import fr.medab.services.AutomatonATMServiceImpl;
import fr.medab.utils.Printer;

import java.util.Scanner;

public class AutomatonATMClI {
    private final AutomatonATMService atmService;
    private final Scanner scanner;
    private final AutomatonATM automatonATM;

    public AutomatonATMClI(AutomatonATMService atmService,AutomatonATM automatonATM) {
        this.atmService = atmService;
        this.automatonATM = automatonATM;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Bienvenu dans votre automatique de billets");
            System.out.println("1. Vérifier le montant total");
            System.out.println("2. Vérifier la disponibilité");
            System.out.println("3. Charger les billets de banque");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkTotalAmount();
                    break;
                case 2:
                    checkAvailability();
                    break;
                case 3:
                    loadBankNotes();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void checkTotalAmount() {
        int totalAmount = atmService.getTotalAmount();
        Printer.print( "Montant total disponible : " + totalAmount);
    }

    private void checkAvailability() {
        Printer.print("Entrez le montant à retirer :");
        int amount = scanner.nextInt();
        boolean available = atmService.checkAvailabilityCache(amount);
        if (available) {
            Printer.print("Le montant est disponible pour le retrait.");
        } else {
            Printer.print("Le montant n'est pas disponible pour le retrait.");
        }
    }

    private void loadBankNotes() {
        System.out.print("Entrez les billets (10, 20, 50, 100, 200, 500): ");
        int value = scanner.nextInt();
        System.out.print("Entrez la quantité: ");
        int quantity = scanner.nextInt();
        BankNoteValue bankNoteValue = BankNoteValue.valueOf("TEN");
        switch (value) {
            case 10:
                bankNoteValue = BankNoteValue.TEN;
                break;
            case 20:
                bankNoteValue = BankNoteValue.TWENTY;
                break;
            case 50:
                bankNoteValue = BankNoteValue.FIFTY;
                break;
            case 100:
                bankNoteValue = BankNoteValue.ONE_HUNDRED;
                break;
            case 200:
                bankNoteValue = BankNoteValue.TWO_HUNDRED;
                break;
            case 500:
                bankNoteValue = BankNoteValue.FIVE_HUNDRED;
                break;
            default:
                Printer.print("Invalid banknote value.");
                return;
        }
        atmService.loadBankNotes(bankNoteValue, quantity);
        Printer.print("Banknotes loaded successfully.");
    }
}
