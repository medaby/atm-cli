package fr.medab.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPin {

    public static String hash(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pin.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validate(String pin, String hash) {
        String hashedPin = hash(pin);
        return hashedPin.equals(hash);
    }

}
