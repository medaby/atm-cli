package fr.medab.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static fr.medab.utils.CSVFileReader.readCSV;

public class CSVFileWriter {

    public static void updateCSVField(String filePath, String fileDelimiter, int row, int col, String newValue) {
        List<String[]> records = new ArrayList<>();

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(fileDelimiter);
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the specific field
        if (row < records.size() && col < records.get(row).length) {
            records.get(row)[col] = newValue;
        } else {
            System.out.println("Invalid row or column index.");
            return;
        }

        // Write the updated content back to the CSV file
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (String[] record : records) {
                pw.println(String.join(fileDelimiter, record));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void hashAllPins(String fileDelimiter, String filePath) {
        List<String[]> records = readCSV(fileDelimiter, filePath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header
            bw.write("autoincrement,guid,iban,accountType,balance,Currency,fullname,iban,cvv,pin");
            bw.newLine();
            for (String[] record : records) {
                // Hash the PIN
                record[10] = HashPin.hash(record[10]);
                // Write the updated record
                bw.write(String.join(fileDelimiter, record));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
