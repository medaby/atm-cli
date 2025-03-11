package fr.medab.utils;

import java.io.IOException;

public class Mask {
    public static String apply() {
        StringBuilder input = new StringBuilder(); // Stocke l'entrée utilisateur
        try {
            // Passer le terminal en mode RAW (désactiver le buffering)
            new ProcessBuilder("sh", "-c", "stty -echo -icanon").inheritIO().start().waitFor();
            while (true) {
                int ch = System.in.read(); // Lire un caractère

                if (ch == '\n' || ch == '\r') {
                    break; // Arrêter la saisie quand l'utilisateur appuie sur Entrée
                } else if (ch == 8 || ch == 127) { // Gérer la touche "Backspace"
                    if (input.length() > 0) {
                        input.deleteCharAt(input.length() - 1);
                        System.out.print("\b \b"); // Efface un caractère affiché
                    }
                } else if (ch == 27) { // Éviter les touches spéciales (ESC, Flèches, etc.)
                    continue;
                } else if (ch >= '0' && ch <= '9'&& input.length()<4) {
                    input.append((char) ch); // Ajouter le chiffre à la variable
                    System.out.print("*"); // Afficher un *
                } else if (ch == 127 || ch == 46) { // Gérer la touche "Delete"
                    if (input.length() > 0) {
                        input.delete(0, 1); // Supprimer le premier chiffre (simulation du Delete)
                        System.out.print("\b \b"); // Effacer un caractère affiché
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            Printer.error("\nUne erreur est survenue lors de la saisie : " + e.getMessage());
        }

        return input.toString();
    }
}
