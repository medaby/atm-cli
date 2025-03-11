package fr.medab.models;

import java.time.LocalDateTime;

public class CreditCard {
    private BankAccount bankAccount;
    private String serialNumber;
    private String hashPin;
    private boolean isBlocked;
    private Client owner;
    private String type;
    private String cvv;
    private LocalDateTime expirationDate;
}
