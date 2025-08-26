package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.testng.Assert;

import java.io.IOException;

public class VerifyActivityTableAnnualLabOfHbA1cLevelsEvery6Months {
    MobileActions mobileActions = new MobileActions();
   CommonHelper CommonHelper = new CommonHelper();
    public void isActivityTableAnnualLabOfHbA1cLevelsEvery6MonthsScreenDisplayed(String UserName, String Password, String WelcomeBackText, String LabWorkUpOfHbA1cLevelsEvery6MonthsText, String LabWorkUpOfHbA1cLevelsEvery6MonthsDescriptionText)
            throws InterruptedException, IOException, FilloException {
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        Thread.sleep(5000);
        String StrAct_WelcomeBackText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
        }
        String StrExp_WelcomeBackText = WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
        mobileActions.swipeUp(1);
        Thread.sleep(5000);
        if (Constants.platformName.equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "labWorkText"), "Lab work");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            MobileActions.click(170, 510, "//XCUIElementTypeStaticText[contains(@name,\"Phone\")]");
        }
        Thread.sleep(2000);
        String strAct_LabWorkText= null;
        String strExp_LabWorkText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_LabWorkText=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "labWorkText"), "content-desc").stripLeading();
             strExp_LabWorkText = "￼\n" +
                     "￼\n" +
                     "Lab Work-up of HbA1c Levels Every 6 Months";
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_LabWorkText=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "labWorkText"), "name").stripLeading();
             strExp_LabWorkText = LabWorkUpOfHbA1cLevelsEvery6MonthsText;
        }
        Assert.assertTrue(strAct_LabWorkText.contains(strExp_LabWorkText));
        String strAct_LabWorkDescriptionText = null;
        String strExp_LabWorkDescriptionText =null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_LabWorkDescriptionText=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "content-desc").stripLeading();
             strExp_LabWorkDescriptionText ="￼\n" +
                     "￼\n" +
                     "You need to have your hemoglobin A1c (HbA1c) levels checked at least once every six months to check your blood glucose levels.";
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_LabWorkDescriptionText=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "name").stripLeading();
             strExp_LabWorkDescriptionText =LabWorkUpOfHbA1cLevelsEvery6MonthsDescriptionText;
        }
        mobileActions.verifyText(strAct_LabWorkDescriptionText, strExp_LabWorkDescriptionText);
        ReportManager.logScreenshotInfo();
    }
}
