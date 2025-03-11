package fr.medab.utils;

public class Printer {
    public static void print(String message) {
        // Code ANSI pour le texte vert
        String greenText = "\u001B[32m";
        String resetText = "\u001B[0m";
        System.out.println(greenText + message + resetText);
    }
}
