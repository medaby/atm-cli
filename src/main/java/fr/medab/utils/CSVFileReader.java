package fr.medab.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {

    public static List<String[]> readCSV(String fileDelimiter, String filePath) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath != null ? filePath : "./src/main/resources/data/files/sg.csv"))) {
            // Skip the first line which contains column names
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(fileDelimiter);
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
