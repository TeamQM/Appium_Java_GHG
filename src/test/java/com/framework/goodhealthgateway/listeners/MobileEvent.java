//package com.framework.listeners;
//
//import com.aventstack.extentreports.model.Test;
//import com.framework.android.utils.LanguageDataProvider;
//import com.framework.android.utils.MobileActions;
//import com.framework.utilities.*;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class MobileEvent implements ITestListener {
//
//	public static ArrayList<String> passedTests = new ArrayList<String>();
//	public static ArrayList<String> failedTests = new ArrayList<String>();
//	public static ArrayList<String> totalTestCases = new ArrayList<String>();
//	InitDriver initDriver = new InitDriver();
//	private static final String KEY = "platform";
//	private static final String KEY1 = "udid";
//	private static final String KEY2 = "systemPort";
//	private static final String KEY3 = "deviceName";
//
//	private static final String KEY4 = "deviceVersion";
//	private static final String KEY5 = "runId";
//
//
//	public String Platform;
//	public String Udid;
//	public String SystemPort;
//	public String DeviceName = "";
//
//	public String DeviceVersion = "";
//	public String RunID;
//	@Override
//	public void onTestStart(ITestResult arg0) {
//
//		totalTestCases.add(arg0.getMethod().getMethodName());
//		String language = "English";
//		ReportManager.startTestMobile(arg0.getMethod().getMethodName(), arg0.getMethod().getDescription(),
//				ConfigReader.getValue("Execution_Mobile"));
//
//		try {
//
//			// If Test is directly running by dev team then it will value from appium config
//			// file
//			if (Platform == null) {
//				System.out.println("appium values taken from appium.properties file");
//				Platform = ConfigReader.getAppiumProp("platform");
//				Udid = ConfigReader.getAppiumProp("udid");
//				SystemPort = ConfigReader.getAppiumProp("port");
//				DeviceName = "";
//				DeviceVersion = "";
//				RunID =ConfigReader.getAppiumProp("runId");
//			}
//
//			System.out.println("key: " + Platform);
//			System.out.println("key1: " + Udid);
//			System.out.println("key2: " + SystemPort);
//			System.out.println("key5: " + RunID);
//
//
//			initDriver.startMobileDriver(RunID,Platform, Udid, SystemPort, DeviceName, DeviceVersion);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		String description = arg0.getMethod().getDescription();
//		String temp = description.split("]")[0];
//		String[] split = temp.replace("[", "").split(", ");
//		for (String s : split) {
//			if (LanguageDataProvider.getCurrentLanguage() != null) {
//				language = LanguageDataProvider.getCurrentLanguage();
//			}
//		}
//		if (ConfigReader.getValue("lambdatest").equalsIgnoreCase("true")) {
//
//			JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getMobileDriver();
//			jse.executeScript("lambda-name="+arg0.getMethod().getMethodName()+"");
//		}
//		MobileActions mobileActions = new MobileActions();
//		mobileActions.sleep(2000);
//
////		By allow = By.id("com.android.permissioncontroller:id/permission_allow_button");
////		if (mobileActions.isElmPresent(allow)) {
////			mobileActions.click(allow, "Click on allow");
////		}
//
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult iTestResult) {
//
//		passedTests.add(iTestResult.getMethod().getMethodName());
//		System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());
//		String language = "English";
//
//		try {
//
//			ReportManager.logScreenshotInfo();
//			String description = iTestResult.getMethod().getDescription();
//			String temp = description.split("]")[0];
//			String[] split = temp.replace("[", "").split(", ");
//			for (String s : split) {
//				String testId = s;
//				if (LanguageDataProvider.getCurrentLanguage() != null) {
//					language = LanguageDataProvider.getCurrentLanguage();
//				}
//				//TestCaseResult.addResults(testId, language, Platform, "PASS");
//			}
//		} catch (Exception e) {
//// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (ConfigReader.getValue("lambdatest").equalsIgnoreCase("true")) {
//			JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getMobileDriver();
//
//			jse.executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"\"}} ");
//
//		}
//		ReportManager.logPassMobile("Test case passed");
//
//		Test model = ReportManager.getCurrentTest().getModel();
//		String oldName = model.getName();
//		model.setName(oldName + "_" + language);
//
//		ReportManager.endCurrentTestMobile();
//		DriverFactory.getInstance().getMobileDriver().resetApp();
//		initDriver.tearDownMobileDriver();
//	}
//
//	@Override
//	public void onTestFailure(ITestResult iTestResult) {
//
//
//		failedTests.add(iTestResult.getMethod().getMethodName());
//		String language = "English";
//		try {
//			String description = iTestResult.getMethod().getDescription();
//			String temp = description.split("]")[0];
//			String[] split = temp.replace("[", "").split(", ");
//			for (String s : split) {
//				String testId = s;
//				if (LanguageDataProvider.getCurrentLanguage() != null) {
//					language = LanguageDataProvider.getCurrentLanguage();
//				}
//				//TestCaseResult.addResults(testId, language, Platform, "FAIL");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		if (ConfigReader.getValue("lambdatest").equalsIgnoreCase("true")) {
//			JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getMobileDriver();
//			String errorMessage = iTestResult.getThrowable().getMessage().substring(0, 150);
//			jse.executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\""+errorMessage+"\"}} ");
//		}
//		System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
//		ReportManager.logFailMobile("Test case Fail");
//		ReportManager.logFailMobile(iTestResult.getThrowable().getMessage());
//		try {
//			ReportManager.logScreenshotInfo();
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		Test model = ReportManager.getCurrentTest().getModel();
//		String oldName = model.getName();
//		model.setName(oldName + "_" + language);
//
//		ReportManager.endCurrentTestMobile();
//		DriverFactory.getInstance().getMobileDriver().resetApp();
//		initDriver.tearDownMobileDriver();
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult arg0) {
//// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void onFinish(ITestContext arg0) {
//	//	try {
////			//TestCaseResult.saveToExcel();
////		} catch (IOException e) {
////			throw new RuntimeException(e);
////		} catch (InvalidFormatException e) {
////			throw new RuntimeException(e);
//	//	}
//		ReportManager.endReportMobile();
//
//	}
//
//	@Override
//	public void onStart(ITestContext arg0) {
//		Platform = arg0.getCurrentXmlTest().getParameter(KEY);
//		Udid = arg0.getCurrentXmlTest().getParameter(KEY1);
//		SystemPort = arg0.getCurrentXmlTest().getParameter(KEY2);
//		DeviceName = arg0.getCurrentXmlTest().getParameter(KEY3);
//		DeviceVersion = arg0.getCurrentXmlTest().getParameter(KEY4);
//		RunID = arg0.getCurrentXmlTest().getParameter(KEY5);
//
//
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
//// TODO Auto-generated method stub
//
//	}
//
//}
package com.framework.goodhealthgateway.listeners;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.model.Test;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.android.utils.LanguageDataProvider;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;
import com.framework.goodhealthgateway.drivermanager.InitDriver;
import com.framework.goodhealthgateway.utilities.ConfigReader;
import com.framework.goodhealthgateway.utilities.ReportManager;

public class MobileEvent implements ITestListener {

    public static ArrayList<String> passedTests = new ArrayList<String>();
    public static ArrayList<String> failedTests = new ArrayList<String>();
    public static ArrayList<String> totalTestCases = new ArrayList<String>();
    InitDriver initDriver = new InitDriver();
    private static final String KEY = "platform";
    private static final String KEY1 = "udid";
    private static final String KEY2 = "systemPort";
    private static final String KEY3 = "deviceName";
    private static final String KEY4 = "deviceVersion";
    private static final String KEY5 = "runId";

    public String Platform;
    public String Udid;
    public String SystemPort;
    public String DeviceName = "";
    public String DeviceVersion = "";
    public String RunID;

    @Override
    public void onTestStart(ITestResult arg0) {
        totalTestCases.add(arg0.getMethod().getMethodName());
        String language = "English";
        ReportManager.startTestMobile(arg0.getMethod().getMethodName(), arg0.getMethod().getDescription(),
                ConfigReader.getValue("Execution_Mobile"));

        try {
            if (Platform == null) {
                System.out.println("appium values taken from appium.properties file");
                Platform = ConfigReader.getAppiumProp("platform");
                Udid = ConfigReader.getAppiumProp("udid");
                SystemPort = ConfigReader.getAppiumProp("port");
                DeviceName = "";
                DeviceVersion = "";
                RunID = ConfigReader.getAppiumProp("runId");
            }

            System.out.println("key: " + Platform);
            System.out.println("key1: " + Udid);
            System.out.println("key2: " + SystemPort);
            System.out.println("key5: " + RunID);

            initDriver.startMobileDriver(RunID, Platform, Udid, SystemPort, DeviceName, DeviceVersion);

        } catch (Exception e) {
            System.err.println("Error starting mobile driver: " + e.getMessage());
            e.printStackTrace();
        }

        String description = arg0.getMethod().getDescription();
        try {
            String temp = description.split("]")[0];
            String[] split = temp.replace("[", "").split(", ");
            for (String s : split) {
                if (LanguageDataProvider.getCurrentLanguage() != null) {
                    language = LanguageDataProvider.getCurrentLanguage();
                }
            }
        } catch (Exception e) {
            System.err.println("Error parsing description: " + e.getMessage());
        }

        if (ConfigReader.getValue("lambdatest").equalsIgnoreCase("true")) {
            try {
                JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getMobileDriver();
                jse.executeScript("lambda-name=" + arg0.getMethod().getMethodName() + "");
            } catch (Exception e) {
                System.err.println("Lambda name setting failed: " + e.getMessage());
            }
        }

        MobileActions mobileActions = new MobileActions();
        mobileActions.sleep(2000);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        passedTests.add(iTestResult.getMethod().getMethodName());
        System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());
        String language = "English";

        try {
            ReportManager.logScreenshotInfo();
            String description = iTestResult.getMethod().getDescription();
            String temp = description.split("]")[0];
            String[] split = temp.replace("[", "").split(", ");
            for (String s : split) {
                if (LanguageDataProvider.getCurrentLanguage() != null) {
                    language = LanguageDataProvider.getCurrentLanguage();
                }
            }
        } catch (Exception e) {
            System.err.println("Error in test success processing: " + e.getMessage());
            e.printStackTrace();
        }

        if (ConfigReader.getValue("lambdatest").equalsIgnoreCase("true")) {
            try {
                JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getMobileDriver();
                jse.executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"passed\", \"remark\":\"\"}} ");
            } catch (Exception e) {
                System.err.println("Lambda test hook failed: " + e.getMessage());
            }
        }

        ReportManager.logPassMobile("Test case passed");

        // SAFE ACCESS to ExtentTest
        com.aventstack.extentreports.ExtentTest currentTest = ReportManager.getCurrentTest();
        if (currentTest != null) {
            try {
                Test model = currentTest.getModel();
                String oldName = model.getName();
                model.setName(oldName + "_" + language);
            } catch (Exception e) {
                System.err.println("Error modifying test name: " + e.getMessage());
            }
        }

        try {
            ReportManager.endCurrentTestMobile();
        } catch (Exception e) {
            System.err.println("Error ending test in report: " + e.getMessage());
        }

        try {
            DriverFactory.getInstance().getMobileDriver().resetApp();
        } catch (Exception e) {
            System.err.println("Error resetting app: " + e.getMessage());
        }

        try {
            initDriver.tearDownMobileDriver();
        } catch (Exception e) {
            System.err.println("Error in driver teardown: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        failedTests.add(iTestResult.getMethod().getMethodName());
        String language = "English";
        
        try {
            String description = iTestResult.getMethod().getDescription();
            String temp = description.split("]")[0];
            String[] split = temp.replace("[", "").split(", ");
            for (String s : split) {
                if (LanguageDataProvider.getCurrentLanguage() != null) {
                    language = LanguageDataProvider.getCurrentLanguage();
                }
            }
        } catch (Exception e) {
            System.err.println("Error parsing test description: " + e.getMessage());
        }

        if (ConfigReader.getValue("lambdatest").equalsIgnoreCase("true")) {
            try {
                JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getMobileDriver();
                String errorMessage = iTestResult.getThrowable() != null ? iTestResult.getThrowable().getMessage() : "Unknown error";
                if (errorMessage != null && errorMessage.length() > 150) {
                    errorMessage = errorMessage.substring(0, 150);
                }
                jse.executeScript("lambda-hook: {\"action\": \"setTestStatus\",\"arguments\": {\"status\":\"failed\", \"remark\":\"" + errorMessage + "\"}} ");
            } catch (Exception e) {
                System.err.println("Lambda test hook failed: " + e.getMessage());
            }
        }

        System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
        
        // SAFE LOGGING - Null checks implemented in ReportManager
        ReportManager.logFailMobile("Test case Fail");
        if (iTestResult.getThrowable() != null) {
            ReportManager.logFailMobile(iTestResult.getThrowable().getMessage());
        }

        try {
            ReportManager.logScreenshotInfo();
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error in screenshot capture: " + e.getMessage());
        }

        // SAFE ACCESS to ExtentTest
        com.aventstack.extentreports.ExtentTest currentTest = ReportManager.getCurrentTest();
        if (currentTest != null) {
            try {
                Test model = currentTest.getModel();
                String oldName = model.getName();
                model.setName(oldName + "_" + language);
            } catch (Exception e) {
                System.err.println("Error modifying test name: " + e.getMessage());
            }
        }

        try {
            ReportManager.endCurrentTestMobile();
        } catch (Exception e) {
            System.err.println("Error ending test in report: " + e.getMessage());
        }

        try {
            DriverFactory.getInstance().getMobileDriver().resetApp();
        } catch (Exception e) {
            System.err.println("Error resetting app: " + e.getMessage());
        }

        try {
            initDriver.tearDownMobileDriver();
        } catch (Exception e) {
            System.err.println("Error in driver teardown: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // Implementation if needed
    }

    @Override
    public void onFinish(ITestContext arg0) {
        ReportManager.endReportMobile();
    }

    @Override
    public void onStart(ITestContext arg0) {
        Platform = arg0.getCurrentXmlTest().getParameter(KEY);
        Udid = arg0.getCurrentXmlTest().getParameter(KEY1);
        SystemPort = arg0.getCurrentXmlTest().getParameter(KEY2);
        DeviceName = arg0.getCurrentXmlTest().getParameter(KEY3);
        DeviceVersion = arg0.getCurrentXmlTest().getParameter(KEY4);
        RunID = arg0.getCurrentXmlTest().getParameter(KEY5);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // Implementation if needed
    }
}
