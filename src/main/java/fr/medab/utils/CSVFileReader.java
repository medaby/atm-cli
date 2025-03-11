package fr.medab.utils;

import java.io.*;
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

    public static String[] readCSVLineByField(String fileDelimiter, String filePath, int fieldIndex, String fieldValue) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath != null ? filePath : "./src/main/resources/data/files/sg.csv"))) {
            // Skip the first line which contains column names
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(fileDelimiter);
                if (values[fieldIndex].equals(fieldValue)) {
                    return values;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


//    public BankAccount findByField(String fieldName, String value) {
//        List<String[]> records = CSVFileReader.readCSV(this.fileDelimiter, this.filePath);
//        for (String[] record : records) {
//            switch (fieldName) {
//                case "accountNumber":
//                    if (record[2].equals(value)) {
//                        return parseAccount(record);
//                    }
//                    break;
//                case "accountType":
//                    if (record[3].equals(value)) {
//                        return parseAccount(record);
//                    }
//                    break;
//                case "balance":
//                    if (record[4].replace(" ", "").equals(value)) {
//                        return parseAccount(record);
//                    }
//                    break;
//                case "currency":
//                    if (record[5].equals(value)) {
//                        return parseAccount(record);
//                    }
//                    break;
//                case "owner":
//                    if (record[6].equals(value)) {
//                        return parseAccount(record);
//                    }
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unknown field: " + fieldName);
//            }
//        }
//        return null;
//    }

}
