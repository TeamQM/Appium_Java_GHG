package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyDiabetesResourcesScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({SuiteEvent.class, MobileEvent.class})


public class TC_039_040_041_042_043_044_045_HomePage_Verify_DiabetesResources_Screen {


    @Test(description = " [TC_Home_039,TC_Home_040, TC_Home_041,TC_Home_042,C_Home_043,TC_Home_044,TC_Home_045]Verify Diabetes screens , Phone, TTy, Email, Visit Website",
            groups = {"regression", "registration_and_login"})
    public void verifyDiabetesResourcesScreen() throws Exception {

        VerifyDiabetesResourcesScreen verifyDiabetesResourcesScreen = new VerifyDiabetesResourcesScreen();
        verifyDiabetesResourcesScreen.isDiabetesResourcesScreenDisplayedAndValidatedScreen(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("DiabetesResourcesText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("TheCentersForDiseaseControlPublicHealthResourceCenterText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("PhoneText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("TTYText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("EmailText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("VisitWebsiteText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("CDCWebsiteUrl"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("MenuText")
        );
    }

}
