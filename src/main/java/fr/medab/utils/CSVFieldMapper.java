package fr.medab.utils;

import java.util.HashMap;
import java.util.Map;

public class CSVFieldMapper {
    private static final Map<Integer, String> fieldMapping = new HashMap<>();

    static {
        // Example mapping: column index -> classFieldName
        fieldMapping.put(2, "accountNumber");
        fieldMapping.put(3, "accountType");
        fieldMapping.put(4, "balance");
        fieldMapping.put(5, "currencyCode");
        fieldMapping.put(6, "currencyName");
        fieldMapping.put(7, "firstName");
        fieldMapping.put(8, "lastName");
    }

    public static String getFieldName(int col) {
        return fieldMapping.get(col);
    }
}
