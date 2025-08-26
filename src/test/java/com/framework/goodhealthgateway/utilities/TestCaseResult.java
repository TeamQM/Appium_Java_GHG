
// Fixed TestCaseResult.java - Manual getters/setters
package com.framework.goodhealthgateway.utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCaseResult {
    private String testId;
    private String language;
    private String deviceDetail;
    private String result;
    
    private static boolean isExcelReady = false;
    private static Connection connection;
    private static Fillo fillo = new Fillo();
    private static File excelFile;
    private static final String EXCEL_TEMPLATE_PATH = "src/test/resources/Files/KooReportTemplate.xlsx";
    private static List<TestCaseResult> testCaseResults = new ArrayList<>();

    static {
        initExcelReport();
    }

    // Manual getters and setters
    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDeviceDetail() {
        return deviceDetail;
    }

    public void setDeviceDetail(String deviceDetail) {
        this.deviceDetail = deviceDetail;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public synchronized static int totalTests() {
        return testCaseResults.size();
    }

    public synchronized static void addResults(String testId, String language, String deviceDetail, String result) {
        TestCaseResult testCaseResult = new TestCaseResult();

        testCaseResult.setTestId(testId);

        if (language == null || language.isEmpty()) {
            testCaseResult.setLanguage("English");
        } else {
            testCaseResult.setLanguage(language);
        }

        testCaseResult.setDeviceDetail(deviceDetail);
        testCaseResult.setResult(result);

        testCaseResults.add(testCaseResult);
    }

    public synchronized static void initExcelReport() {
        if (!isExcelReady) {
            copyTemplate();
            isExcelReady = excelFile != null && excelFile.exists();
        }
    }

    public static synchronized void saveToExcel() throws IOException, InvalidFormatException {
        if (!isExcelReady) {
            throw new RuntimeException("Please initialize excel report before saving results.");
        }
        try {
            TestCaseResult.printToScreen();
            for (TestCaseResult testCaseResult : testCaseResults) {
                saveToExcel(testCaseResult);
            }
        } catch (FilloException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printToScreen() {
        System.out.println("\nTotal Results: " + TestCaseResult.totalTests());
        System.out.println("----------------------------------------------------------------------------------");
        for (TestCaseResult testCaseResult : testCaseResults) {
            System.out.println("\t" + testCaseResult.toString());
        }
        System.out.println("===================================================================================");
    }

    public synchronized static void saveToExcel(TestCaseResult testResult) throws FilloException {
        String strQuery = String.format("Update TestScenariosExecution Set %s='%s' Where TestCaseId='%s'", 
                testResult.getLanguage(), 
                testResult.getResult() + "-" + testResult.getDeviceDetail(), 
                testResult.getTestId());
        int update = getConnection().executeUpdate(strQuery);
        if (update > 0) {
            System.out.println("Record update success...");
        } else {
            System.out.println("Record update failed...");
        }
    }

    private synchronized static Connection getConnection() throws FilloException {
        if (connection == null) {
            connection = fillo.getConnection(excelFile.getAbsolutePath());
        }
        return connection;
    }

    private static void copyTemplate() {
        try {
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HHmmss").format(new Date());
            String dateStamp = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            String reportPath = String.format(System.getProperty("user.dir") + "/Reports/ExcelReports/" + dateStamp
                    + "/" + "Abacus-" + timeStamp + ".xlsx");
            
            File targetFile = new File(reportPath);
            
            // Create directories if they don't exist
            File parentDir = targetFile.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            
            // Copy template to target location
            File templateFile = new File(EXCEL_TEMPLATE_PATH);
            if (templateFile.exists()) {
                FileUtils.copyFile(templateFile, targetFile);
                excelFile = targetFile;
            } else {
                throw new RuntimeException("Template file not found: " + EXCEL_TEMPLATE_PATH);
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Error copying template: " + e.getMessage(), e);
        }
    }

    @Override
    public String toString() {
        return "TestCaseResult{" +
                "testId='" + testId + '\'' +
                ", language='" + language + '\'' +
                ", deviceDetail='" + deviceDetail + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}