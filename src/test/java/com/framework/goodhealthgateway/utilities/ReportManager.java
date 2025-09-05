//
//
//package com.framework.utilities;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.model.Media;
//import com.aventstack.extentreports.model.Test;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ReportManager {
////
//   public static String timeStamp;
//   public static String dateStamp;
//    public static ExtentSparkReporter htmlReporter;
//    public static ExtentReports extent;
//    public static Map<Long, ExtentTest> testMap = new HashMap<>();
//    public static Map<String, ExtentTest> extentMap = new HashMap<>();
//   
////    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//
//    public static void startReport() {
//
//        if (htmlReporter == null) {
//             timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
//             dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
//            htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/WebReports/" + dateStamp
//                    + "/" + "GHG-" + timeStamp + ".html");            // Create an object of Extent Reports
//            extent = new ExtentReports();
//            extent.attachReporter(htmlReporter);
//            extent.setSystemInfo("Host Name", "GHG");
//            extent.setSystemInfo("Environment", "Test Env");
//            extent.setSystemInfo("User Name", "Rajesh");
//            htmlReporter.config().setDocumentTitle("GHG Mobile Application");
//            // Name of the report
//            htmlReporter.config().setReportName("GHG Mobile Application");
//            htmlReporter.config().isTimelineEnabled();
//            // Dark Theme
//            htmlReporter.config().setTheme(Theme.DARK);
//
//        }
//
//    }
//
//    public static void startTest(String testName, String description, String categories) {
//
//
//
//        ExtentTest test = extent.createTest(testName, description);
//        testMap.put(Thread.currentThread().getId(), test);
//        extentMap.put(testName, test);
//
//    }
//
//    public static void logPass(String message) {
//        getCurrentTest().log(Status.PASS, message);
//
//    }
//
//    /**
//     * =============================================================================
//     * Method: logScreenShot | Author: Rajesh Buddha | Date:30 Jan 2020 |
//     * Description: This method log take screenshot | Parameters: message | Return:
//     * none
//     * =============================================================================
//     *
//
//     * @throws IOException
//     */
//    public static void logScreenshot() throws IOException {
//        // getCurrentTest().addScreenCaptureFromBase64String(ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getWebDriver()));
//        Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
//                ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getMobileDriver())).build();
//        getCurrentTest().fail("", mediaModel);
//
//    }
//
//    /**
//     * =============================================================================
//     * Method: logScreenShot | Author: Rajesh Buddha | Date:30 Jan 2020 |
//     * Description: This method log take screenshot | Parameters: message | Return:
//     * none
//     * =============================================================================
//     *
//     * @throws IOException
//     */
//    public static void logScreenshotInfo() throws IOException {
//        Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
//                ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getMobileDriver())).build();
//        getCurrentTest().info("", mediaModel);
//
//    }
//
//    /**
//     * =============================================================================
//     * Method: logScreenShot | Author: Rajesh Buddha | Date:30 Jan 2020 |
//     * Description: This method log take screenshot | Parameters: message | Return:
//     * none
//     * =============================================================================
//     *
//     * @throws IOException
//     */
//    public static void logScreenshotInfo1() throws IOException {
//        /*
//         * Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
//         * ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getWindowDriver()))
//         * .build(); getCurrentTest().info("", mediaModel);
//         */
//    }
//
//    public static void logFail(String message) {
//        getCurrentTest().log(Status.FAIL, message);
//
//    }
//
//    public static void logInfo(String message) {
//        getCurrentTest().log(Status.INFO, message);
//
//    }
//
//    public static void endCurrentTest() {
//
//        getCurrentTest().getExtent().flush();
//
//        testMap.remove(Thread.currentThread().getId());
//    }
//
//    public static ExtentTest getCurrentTest() {
//        return testMap.get(Thread.currentThread().getId());
//
//    }
//
//    public static void endReport() {
//
//        extent.flush();
//    }
//
//    public static ExtentSparkReporter htmlReporterMobile;
//    public static ExtentReports extentMobile;
//    public static Map<Long, ExtentTest> testMapMobile = new HashMap<>();
//
//    public static void startReportMobile() {
//        if (htmlReporter == null) {
//             timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
//             dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
//            htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MobileReports/" + dateStamp
//                    + "/" + "GHG-" + timeStamp + ".html");
//            // Create an object of Extent Reports
//            extent = new ExtentReports();
//            extent.attachReporter(htmlReporter);
//            extent.setSystemInfo("Host Name", "GHG");
//            extent.setSystemInfo("Environment", "Test Env");
//            extent.setSystemInfo("User Name", "Rajesh");
//            htmlReporter.config().setDocumentTitle("GHG Mobile Application");
//            // Name of the report
//            htmlReporter.config().setReportName("GHG Mobile Application");
//            htmlReporter.config().isTimelineEnabled();
//            // Dark Theme
//            htmlReporter.config().setTheme(Theme.DARK);
//
//        }
//
//    }
//
//    @SuppressWarnings("deprecation")
//	public static void startTestMobile(String testName, String description, String categories) {
//
//
//        ExtentTest test = extent.createTest(testName, description);
//        testMap.put(Thread.currentThread().getId(), test);
//        extentMap.put(testName, test);
//
//
//
//    }
//
//    public static void logPassMobile(String message) {
//        getCurrentTest().log(Status.PASS, message);
//
//    }
//
//
//    public static void logFailMobile(String message) {
//        getCurrentTest().log(Status.FAIL, message);
//   }
//
//    public static void logInfoMobile(String message) {
//        getCurrentTest().log(Status.INFO, message);
//
//    }
//
//    public static void endCurrentTestMobile() {
//        getCurrentTest().getExtent().flush();
//
//        testMap.remove(Thread.currentThread().getId());
//    }
//
//    public static ExtentTest getCurrentTestMobile() {
//        return testMap.get(Thread.currentThread().getId());
//
//    }
//
//    public static void endReportMobile() {
//
//        extent.flush();
//    }
//
//    public static void main(String[] args) {
//
//
//
//	}
//
//}
//
package com.framework.goodhealthgateway.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReportManager {

    public static String timeStamp;
    public static String dateStamp;
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static Map<Long, ExtentTest> testMap = new HashMap<>();
    public static Map<String, ExtentTest> extentMap = new HashMap<>();
    
    // ThreadLocal for thread-safe ExtentTest management
    private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    public static void startReport() {
        if (htmlReporter == null) {
            timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
            dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/WebReports/" + dateStamp
                    + "/" + "GHG-" + timeStamp + ".html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "GHG");
            extent.setSystemInfo("Environment", "Test Env");
         //   extent.setSystemInfo("Environment", "Test Env");
            extent.setSystemInfo("User Name", "Rajesh");
          
            htmlReporter.config().setDocumentTitle("GHG Mobile Application");
            htmlReporter.config().setReportName("GHG Mobile Application");
            htmlReporter.config().isTimelineEnabled();
            htmlReporter.config().setTheme(Theme.DARK);
        }
    }
    
    
    
    
   
    public static void startTest(String testName, String description, String categories) {
        ExtentTest test = extent.createTest(testName, description);
        long threadId = Thread.currentThread().getId();
        testMap.put(threadId, test);
        testThreadLocal.set(test);
        extentMap.put(testName, test);
    }

    public static void logPass(String message) {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.log(Status.PASS, message);
        } else {
            System.err.println("PASS LOG - ExtentTest is null: " + message);
        }
    }

    public static void logScreenshot() throws IOException {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
                    ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getMobileDriver())).build();
            currentTest.fail("", mediaModel);
        }
    }

    public static void logScreenshotInfo() throws IOException {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
                    ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getMobileDriver())).build();
            currentTest.info("", mediaModel);
        }
    }

    public static void logScreenshotInfo1() throws IOException {
        // Implementation if needed
    }

    public static void logFail(String message) {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.log(Status.FAIL, message);
        } else {
            System.err.println("FAIL LOG - ExtentTest is null: " + message);
        }
    }

    public static void logInfo(String message) {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.log(Status.INFO, message);
        } else {
            System.err.println("INFO LOG - ExtentTest is null: " + message);
        }
    }

    public static void endCurrentTest() {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.getExtent().flush();
        }
        long threadId = Thread.currentThread().getId();
        testMap.remove(threadId);
        testThreadLocal.remove();
    }

    public static ExtentTest getCurrentTest() {
        // First try ThreadLocal
        ExtentTest test = testThreadLocal.get();
        if (test != null) {
            return test;
        }
        
        // Fallback to thread map
        long threadId = Thread.currentThread().getId();
        return testMap.get(threadId);
    }

    public static void endReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static void startReportMobile() {
        if (htmlReporter == null) {
            timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
            dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MobileReports/" + dateStamp
                    + "/" + "GHG-" + timeStamp + ".html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "GHG");
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
            extent.setSystemInfo("APK File", getMobileAppFileName());
           // extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            htmlReporter.config().setDocumentTitle("GHG Mobile Application");
            htmlReporter.config().setReportName("GHG Mobile Application");
            htmlReporter.config().isTimelineEnabled();
            htmlReporter.config().setTheme(Theme.DARK);
        }
    }

    
    public static String getMobileAppFileName() {
        String folderPath = "src/test/resources/MobileApps";
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null && files.length > 0) {
                return files[0].getName();
            } else {
                throw new RuntimeException("No files found in " + folderPath);
            }
        } else {
            throw new RuntimeException("Folder does not exist: " + folderPath);
        }
    }

    
    
    
    @SuppressWarnings("deprecation")
    public static void startTestMobile(String testName, String description, String categories,String[] groups) {
        ExtentTest test = extent.createTest(testName, description);
        
        for (String group : groups) {
            test.assignCategory(group);
        }
        long threadId = Thread.currentThread().getId();
        testMap.put(threadId, test);
        testThreadLocal.set(test);
        extentMap.put(testName, test);
    }

    public static void logPassMobile(String message) {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.log(Status.PASS, message);
        } else {
            System.err.println("PASS MOBILE LOG - ExtentTest is null: " + message);
        }
    }

    public static void logFailMobile(String message) {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.log(Status.FAIL, message);
        } else {
            System.err.println("FAIL MOBILE LOG - ExtentTest is null: " + message);
        }
    }

    public static void logInfoMobile(String message) {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.log(Status.INFO, message);
        } else {
            System.err.println("INFO MOBILE LOG - ExtentTest is null: " + message);
        }
    }

    public static void endCurrentTestMobile() {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.getExtent().flush();
        }
        long threadId = Thread.currentThread().getId();
        testMap.remove(threadId);
        testThreadLocal.remove();
    }

    public static ExtentTest getCurrentTestMobile() {
        return getCurrentTest();
    }

    public static void endReportMobile() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static void main(String[] args) {
        // Main method implementation if needed
    }
}




