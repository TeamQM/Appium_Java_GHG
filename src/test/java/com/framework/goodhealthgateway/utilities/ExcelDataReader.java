package com.framework.goodhealthgateway.utilities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.framework.goodhealthgateway.android.utils.Language;

public class ExcelDataReader {
    private static final Fillo fillo = new Fillo();
    private static final String TESTDATAPATH = "src/test/resources/files/TestData.xlsx";

    public static Recordset getSheetDataWithQuery(String query) throws FilloException {
        Connection connection = null;
        try {
            connection = fillo.getConnection(TESTDATAPATH);
            return connection.executeQuery(query);
        } finally {
            // Note: Don't close connection here as Recordset needs it
            // Connection should be closed after Recordset is used
        }
    }

    public static Recordset getSheetData(String sheetName) throws FilloException {
        if (sheetName == null || sheetName.trim().isEmpty()) {
            throw new IllegalArgumentException("Sheet name cannot be null or empty");
        }
        
        Connection connection = null;
        try {
            connection = fillo.getConnection(TESTDATAPATH);
            return connection.executeQuery(String.format("Select * from %s", sheetName));
        } finally {
            // Note: Don't close connection here as Recordset needs it
            // Connection should be closed after Recordset is used
        }
    }

    public static List<Language> getLanguages() throws FilloException {
        Connection connection = null;
        Recordset recordset = null;
        List<Language> languages = new ArrayList<>();
        
        try {
            connection = fillo.getConnection(TESTDATAPATH);
            recordset = connection.executeQuery("Select * from Languages Where Enable ='Yes'");

            while (recordset.next()) {
                Language language = new Language();
                language.setLanguage(recordset.getField("Name"));
                language.setEnable(recordset.getField("Enable"));
                languages.add(language);
            }
        } finally {
            if (recordset != null) {
                recordset.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return languages;
    }

    /**
     * This method is to get data from specific sheet
     * @param sheetName the name of the sheet to read data from
     * @return LinkedHashMap containing key-value pairs from the sheet
     * @throws FilloException if there's an error reading the Excel file
     */
    public static LinkedHashMap<String, String> getLanguagesFromHomePage(String sheetName) throws FilloException {
        Connection connection = null;
        Recordset recordset = null;
        LinkedHashMap<String, String> availableLanguages = new LinkedHashMap<>();
        
        try {
            connection = fillo.getConnection(TESTDATAPATH);
            recordset = connection.executeQuery(String.format("Select * from %s", sheetName));

            while (recordset.next()) {
                String key = recordset.getField("Key");
                String value = recordset.getField("Value");
                if (key != null) {
                    availableLanguages.put(key, value);
                }
            }
        } finally {
            if (recordset != null) {
                recordset.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return availableLanguages;
    }

    // Utility method to properly close resources
    public static void closeResources(Connection connection, Recordset recordset) {
        if (recordset != null) {
            try {
                recordset.close();
            } catch (Exception e) {
                // Log the exception
                System.err.println("Error closing recordset: " + e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                // Log the exception
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws FilloException {
        List<Language> languages = getLanguages();
        for (Language language : languages) {
            System.out.println("Language: " + language.getLanguage());
            System.out.println("Enable: " + language.getEnable());
        }
    }
}