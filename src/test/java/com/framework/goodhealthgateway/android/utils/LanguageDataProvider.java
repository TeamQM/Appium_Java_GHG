// Fixed LanguageDataProvider.java - Manual inner class without Lombok
//package com.framework.android.utils;
package com.framework.goodhealthgateway.android.utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

public class LanguageDataProvider {

    private static ThreadLocal<String> languageInThread = new ThreadLocal<>();
    private static ThreadLocal<LanguageDataSet> currentLanguageData = new ThreadLocal<>();

    public static synchronized void setCurrentLanguage(String language) {
        languageInThread.set(language);
    }

    public static synchronized String getCurrentLanguage() {
        return languageInThread.get();
    }

    public static synchronized String getLanguageDataValue(String key) {
        if (currentLanguageData.get() == null) {
            setUpDataSetForCurrentLanguage();
        } else if (getCurrentLanguage() != null && !getCurrentLanguage().equalsIgnoreCase(currentLanguageData.get().getLanguage())) {
            currentLanguageData.set(null);
            setUpDataSetForCurrentLanguage();
        }

        LanguageDataSet dataSet = currentLanguageData.get();
        return dataSet != null ? dataSet.getData().get(key) : null;
    }

    private static void setUpDataSetForCurrentLanguage() {
        try {
            String currentLang = getCurrentLanguage();
            if (currentLang == null || currentLang.trim().isEmpty()) {
                throw new IllegalStateException("Current language is not set or is empty");
            }

            Map<String, String> languageDataMap = getCurrentLanguageData();
            LanguageDataSet languageDataSet = new LanguageDataSet();
            languageDataSet.setLanguage(currentLang);
            languageDataSet.setData(languageDataMap);
            currentLanguageData.set(languageDataSet);
        } catch (FilloException e) {
            throw new RuntimeException("Error setting up language data: " + e.getMessage(), e);
        }
    }

    private static synchronized Map<String, String> getCurrentLanguageData() throws FilloException {
        Map<String, String> languageData = new HashMap<>();
        String currentLang = languageInThread.get();

        if (currentLang == null) {
            throw new IllegalStateException("Language not set in thread local");
        }

        Recordset sheetData = null;
        try {
            sheetData = ExcelDataReader.getSheetData(currentLang);
            while (sheetData.next()) {
                String key = sheetData.getField("Key");
                String value = sheetData.getField("Value");
                if (key != null) {
                    languageData.put(key, value);
                }
            }
        } finally {
            if (sheetData != null) {
                sheetData.close();
            }
        }
        return languageData;
    }

    @DataProvider(name = "Languages", parallel = false)
    public Object[][] languageData() throws FilloException {
        List<Language> lstLanguages = ExcelDataReader.getLanguages();
        Object[][] objLanguages = new Object[lstLanguages.size()][1];

        for (int i = 0; i < lstLanguages.size(); i++) {
            objLanguages[i][0] = lstLanguages.get(i).getLanguage();
        }

        return objLanguages;
    }

    public static void cleanup() {
        languageInThread.remove();
        currentLanguageData.remove();
    }

    // Manual implementation instead of @Data
    public static class LanguageDataSet {
        private String language;
        private Map<String, String> data = new HashMap<>();

        public LanguageDataSet() {
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Map<String, String> getData() {
            return data;
        }

        public void setData(Map<String, String> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "LanguageDataSet{" +
                    "language='" + language + '\'' +
                    ", data=" + data +
                    '}';
        }
    }
}
