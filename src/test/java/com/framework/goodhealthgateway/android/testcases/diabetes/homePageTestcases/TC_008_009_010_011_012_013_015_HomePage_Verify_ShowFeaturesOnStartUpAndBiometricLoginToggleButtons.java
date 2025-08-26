package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;
@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_008_009_010_011_012_013_015_HomePage_Verify_ShowFeaturesOnStartUpAndBiometricLoginToggleButtons {
    @Test(description ="[TC_Home_008,TC_Home_009,TC_Home_010,TC_Home_011,TC_Home_012], Verify Show features on Startup Toggle Button",groups = {"regression", "registration_and_login"})
    public void verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons() throws IOException, InterruptedException, FilloException {
        VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons = new VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons();
        verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons.verifyToggleSwitchISsetToOffAndHomePageAfterAfterTapOnDontShowMeThisAgain(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingHomeText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("MenuText"));
    }

    @Test(description ="[TC_Home_013,TC_Home_015], Verify Enable Biometric Toggle Button",groups = {"regression", "registration_and_login"})
    public void verifyEnableDisableBiomeNAtricLogin() throws IOException, InterruptedException, FilloException {
        VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons = new VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons();
        verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons.enableDisableBiometricLogin(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingHomeText"));
    }

}
