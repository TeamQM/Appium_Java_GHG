package com.framework.goodhealthgateway.drivermanager;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.WiniumDriver;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.ConfigReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static DriverFactory instance = null;
    ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    ThreadLocal<AppiumDriver<WebElement>> appiumDriver = new ThreadLocal<>();

    String userName = "krishna_kishore"; //Add username here
    String accessKey = "bZYWWMNCmgN3IGOHmZ86NC9c5EpLw10oxhkSIuIJqTG1Yj8Hi6"; //Add accessKey here

    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";


    private DriverFactory() {

    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            instance = new DriverFactory();
        }
        return instance;
    }

    public final void setWebDriver(String browser) throws Exception {

        DesiredCapabilities caps = null;

        switch (browser) {

            case "Chrome":
                caps = DesiredCapabilities.chrome();
                ChromeOptions chOptions = new ChromeOptions();
                Map<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("credentials_enable_service", false);
                chOptions.setExperimentalOption("prefs", chromePrefs);
                chOptions.addArguments("--disable-plugins", "--disable-extensions", "--disable-popup-blocking");
                caps.setCapability(ChromeOptions.CAPABILITY, chOptions);
                caps.setCapability("applicationCacheEnabled", false);
                WebDriverManager.chromedriver().setup();
                webDriver.set(new ChromeDriver());
                getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                getWebDriver().manage().window().maximize();

                break;

            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver.set(new FirefoxDriver());
                getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                getWebDriver().manage().window().maximize();
                break;

            case "Edge":
                WebDriverManager.edgedriver().setup();
                webDriver.set(new EdgeDriver());
                getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                getWebDriver().manage().window().maximize();
                break;

            case "IE":
                WebDriverManager.iedriver().setup();
                webDriver.set(new InternetExplorerDriver());
                getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                getWebDriver().manage().window().maximize();
                break;

        }

    }

    public final void setMobileDriver(String platform, String udid, String systemPort, String deviceName, String deviceVersion) throws Exception {
        String executionType = System.getProperty("CloudExecution",ConfigReader.getValue("CloudExecution"));
        String lambdaTest = System.getProperty("lambdatest", ConfigReader.getValue("lambdatest"));
        String BS = System.getProperty("browserstack", ConfigReader.getValue("browserstack"));
        System.out.println(Constants.platformName);
        if (executionType.equalsIgnoreCase("false")) {
            if (Constants.platformName.equalsIgnoreCase("android")) {
                String[] platformInfo = platform.split(" ");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
               // capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
                //adb-RZCR404KRKY-fWiX24._adb-tls-connect._tcp
              //  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RZCR404KRKY");
                capabilities.setCapability("autoGrantPermissions", true);
                capabilities.setCapability("autoAcceptAlerts", true);
                
                capabilities.setCapability("autoDismissAlerts", true);

                capabilities.setCapability(MobileCapabilityType.UDID, "RZCR404KRKY");
                
               ///
              //  capabilities.setCapability("appPackage", "com.abacushealth.goodhealthgateway");
               // capabilities.setCapability("appActivity", "com.abacushealth.goodhealthgateway.MainActivity");
              //  capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

                // Install app from framework
                capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/MobileApps/GHG-HW_132(103).apk");

                capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");

                appiumDriver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));

                getMobileDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            } else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
                String[] platformInfo = platform.split(" ");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.3.1");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
                capabilities.setCapability(MobileCapabilityType.UDID, udid);
                capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.abacushealth.goodhealthgateway");
                capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
                capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

                try {
                    appiumDriver.set(new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723"), capabilities));
                } catch (MalformedURLException e) {
                    System.out.println("Appium server not started.. Trying again");
                    appiumDriver.set(new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
                }

                getMobileDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            }

        } else{
            if (BS.equalsIgnoreCase("true")){
                String strRunid = System.getProperty("runId");
                System.out.println(strRunid);

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("build", strRunid);
                capabilities.setCapability("name", platform + " " + deviceName + " " + deviceVersion);
                capabilities.setCapability("deviceName", "Samsung Galaxy S23 Ultra"); // Commented out
                capabilities.setCapability("platformVersion", "13.0"); // Commented out
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("isRealMobile", true);
                //AppURL (Create from Wikipedia.apk sample in project)

                capabilities.setCapability("deviceOrientation", "PORTRAIT");
                capabilities.setCapability("console", false);
                capabilities.setCapability("network", false);
                capabilities.setCapability("app", "bs://4e450fd7fa014fe995172efb13e95e8fef113ec9"); // Commented out

                capabilities.setCapability("visual", false);
                capabilities.setCapability("devicelog", true);
                String hub = "https://" + "sanjoosha_fEsd8l" + ":" + "XTexwzjjYSzpoMwt8ptd" + "@hub-cloud.browserstack.com/wd/hub";
                appiumDriver.set(new AndroidDriver(new URL(hub), capabilities));
                getMobileDriver().setLocation(new Location(12.9716, 77.5946, 920));
            }
            else if(lambdaTest.equalsIgnoreCase("true"))
            {
                String strRunid = System.getProperty("runId");
                System.out.println(strRunid);

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("build", strRunid);
                capabilities.setCapability("name", platform + " " + deviceName + " " + deviceVersion);
                capabilities.setCapability("deviceName", "Galaxy S23");
                capabilities.setCapability("platformVersion", "13");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("isRealMobile", true);
                //AppURL (Create from Wikipedia.apk sample in project)

                capabilities.setCapability("deviceOrientation", "PORTRAIT");
                capabilities.setCapability("console", false);
                capabilities.setCapability("network", false);
                capabilities.setCapability("app", "lt://APP10160611311740043326274953");

                capabilities.setCapability("visual", false);
                capabilities.setCapability("devicelog", true);
                String hub = "https://" + userName + ":" + accessKey + gridURL;
                appiumDriver.set(new AndroidDriver(new URL(hub), capabilities));
                getMobileDriver().setLocation(new Location(12.9716, 77.5946, 920));
            }
            else{
                System.out.println("Invalid Execution Configutations");
            }

        }
    }

    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    public AppiumDriver getMobileDriver() {
        return appiumDriver.get();
    }

    public void removeDriver() {
        appiumDriver.remove();
    }

}
