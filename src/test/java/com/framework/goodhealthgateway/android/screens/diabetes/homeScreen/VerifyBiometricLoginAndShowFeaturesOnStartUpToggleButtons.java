package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.utilities.ConfigReader;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

public class VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons {
    MobileActions mobileActions = new MobileActions();
    CommonHelper CommonHelper = new CommonHelper();

    public void verifyToggleSwitchISsetToOffAndHomePageAfterAfterTapOnDontShowMeThisAgain(String UserName,
                                                                                          String Password, String OnBoardingHomeText, String WelcomeBackText, String MenuText) throws InterruptedException, IOException, IOException {
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        String StrAct_OnBoardingHomeText=null;
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
            StrAct_OnBoardingHomeText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Home"),"content-desc");
        } else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            StrAct_OnBoardingHomeText = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Home')]")).getAttribute("name");
        }
        Assert.assertEquals(StrAct_OnBoardingHomeText.contains(OnBoardingHomeText),true );
        ReportManager.logInfo("Successfully Verified onboarding 'Home' page" + "<b style=\"color:green;\"> : "
                + StrAct_OnBoardingHomeText + "</b>");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Next"), "Next");
        Thread.sleep(1000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Next"), "Next");
        Thread.sleep(1000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Next"), "Next");
        Thread.sleep(2000);
        mobileActions.swipeUp(1);
        Thread.sleep(2000);
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DontShowMeThisAgain"), "Dont ShowMe ThisAgain");
        }
        else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            mobileActions.clickUsingCoordinates(178, 555);
        }
        Thread.sleep(500);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Setting"), "Setting_Btn");
        Assert.assertFalse(mobileActions.isSelected(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ShowFeatureOnStartUp_SwitchBtn"),
                "ShowFeatureOnStartUp_SwitchBtn"));
       // mobileActions.clickUsingCoordinates(346,74);
        mobileActions.clickUsingCoordinates(782,533);
        String StrAct_WelcomeBackText = null;
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
            mobileActions.clickUsingCoordinates(648,160);
            StrAct_WelcomeBackText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
        } else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            StrAct_WelcomeBackText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
        }
        String StrExp_WelcomeBackText = WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "hamburgerButton"),
                "hamburgerButton");
        String menuText =null;
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
            menuText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "content-desc");
        } else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            menuText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "name");
        }
        String ExpectedMenuText = MenuText;
        mobileActions.verifyText(menuText, ExpectedMenuText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "LogOff"),
                "LogOff");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        String StrAct_WelcomeBackText1 =null;
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
            StrAct_WelcomeBackText1= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
        } else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            StrAct_WelcomeBackText1= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
        }
        String StrExp_WelcomeBackText1 = WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText1, StrExp_WelcomeBackText1);
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Setting"),
                    "Setting_Btn");
        } else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Setting"),
                    "Setting_Btn");
        }
        Assert.assertFalse(mobileActions.isSelected(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ShowFeatureOnStartUp_SwitchBtn"),
                "ShowFeatureOnStartUp_SwitchBtn"));
        Assert.assertTrue(mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "EnableBiometricLogin_SwitchBtn"),
                "EnableBiometricLogin_SwitchBtn"));
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
           // mobileActions.isSelected(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ShowFeatureOnStartUp_SwitchBtn"),"ShowFeatureOnStartUp_SwitchBtn");
            mobileActions.clickUsingCoordinates(918, 307);

        } else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            mobileActions.clickUsingCoordinates(305, 135);
        }
        Assert.assertTrue(mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ShowFeatureOnStartUp_SwitchBtn"),
                "ShowFeatureOnStartUp_SwitchBtn"));
        mobileActions.clickUsingCoordinates(346,74);
        mobileActions.clickUsingCoordinates(648,160);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "hamburgerButton"),
                "hamburgerButton");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "LogOff"),
                "LogOff");

//===========================================need to close the app===============================================
        mobileActions.closeApp();
        mobileActions.launchApp();
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        String StrAct_OnBoardingHomeText1=null;
        Thread.sleep(1000);
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
            StrAct_OnBoardingHomeText1= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Home"),"content-desc");
        } else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            StrAct_OnBoardingHomeText1= DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Home')]")).getAttribute("name");
        }
        Assert.assertEquals(StrAct_OnBoardingHomeText1.contains(OnBoardingHomeText),true );
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");

    }

    public void enableDisableBiometricLogin(String UserName, String Password, String OnBoardingHomeText) throws IOException, InterruptedException {
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        String StrAct_OnBoardingHomeText1=null;
        Thread.sleep(500);
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
            StrAct_OnBoardingHomeText1=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Home"),"content-desc");
        }
        else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
             StrAct_OnBoardingHomeText1 = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Home')]")).getAttribute("name");
        }
        Assert.assertEquals(StrAct_OnBoardingHomeText1.contains(OnBoardingHomeText),true );
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Setting"), "Setting_Btn");
        }
        else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Setting"), "Setting_Btn");
        }

        Assert.assertTrue(mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ShowFeatureOnStartUp_SwitchBtn"),
                "ShowFeatureOnStartUp_SwitchBtn"));
        Assert.assertFalse(mobileActions.isSelected(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ShowFeatureOnStartUp_SwitchBtn"),
                "EnableBiometricLogin_SwitchBtn"));

        if (ConfigReader.getValue("platFormName").equalsIgnoreCase("android")) {
          if(Boolean.parseBoolean(mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "EnableBiometricLogin_SwitchBtn"), "checked"))==false){
              mobileActions.clickUsingCoordinates(896, 451);
          }
        }
        else if (ConfigReader.getValue("platFormName").equalsIgnoreCase("ios")) {
            int EnableBiometricLogin = Integer.parseInt(mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "EnableBiometricLogin_SwitchBtn"), "value"));

            if (EnableBiometricLogin == 0) {
                mobileActions.clickUsingCoordinates(299, 192);
            }
        }
        Assert.assertTrue(mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "EnableBiometricLogin_SwitchBtn"),
                "EnableBiometricLogin_SwitchBtn"));
       // mobileActions.clickUsingCoordinates(346,74);
        mobileActions.clickUsingCoordinates(782,533);
        mobileActions.clickUsingCoordinates(648,160);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "hamburgerButton"),"hamburgerButton");
       // DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.widget.Button[@index='0']"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "LogOff"),
                "LogOff");
        Assert.assertTrue(mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "FingerPrint")));

    }
}
