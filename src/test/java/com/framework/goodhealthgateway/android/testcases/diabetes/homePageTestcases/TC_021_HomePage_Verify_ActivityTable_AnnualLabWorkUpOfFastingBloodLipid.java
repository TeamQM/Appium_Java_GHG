package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyActivityTableAnnualLabWorkUpOfFastingBloodLipid;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_021_HomePage_Verify_ActivityTable_AnnualLabWorkUpOfFastingBloodLipid {
    @Test(description = "[TC_Home_021]Verify Annual Lab Work Up Of Fasting Blood Lipid  Screen",
            groups = {"regression", "registration_and_login"})
    public void verifyActivityTableAnnualLabWorkUpOfFastingBloodLipid() throws FilloException, IOException, InterruptedException {
        VerifyActivityTableAnnualLabWorkUpOfFastingBloodLipid homeGhgApp7 = new VerifyActivityTableAnnualLabWorkUpOfFastingBloodLipid();
        homeGhgApp7.isActivityTableAnnualLabWorkUpOfFastingBloodLipidScreenDisplayed(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualLabWorkUpOfFastingBloodLipidText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualLabWorkUpOfFastingBloodLipidDescriptionText"));}
}
