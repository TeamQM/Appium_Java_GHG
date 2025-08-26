package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyActivityTableAnnualLabWorkUpOfUrineAndProteinLevels;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_022_HomePage_Verify_ActivityTable_AnnualLabWorkUpOfUrineAndProteinLevels {
    @Test(description = "[TC_Home_022]Verify Annual Lab Work Up Of Urine/Protein Levels Screen",
            groups = {"regression", "registration_and_login"})
    public void verifyActivityTableAnnualLabWorkUpOfUrineAndProteinLevels() throws FilloException, IOException, InterruptedException {
        VerifyActivityTableAnnualLabWorkUpOfUrineAndProteinLevels verifyActivityTableAnnualLabWorkUpOfUrineAndProteinLevels = new VerifyActivityTableAnnualLabWorkUpOfUrineAndProteinLevels();
        verifyActivityTableAnnualLabWorkUpOfUrineAndProteinLevels.isActivityTableAnnualLabWorkUpOfUrineAndProteinLevelsScreensDisplayed(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualLabWorkUpOfUrineProteinLevelsText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualLabWorkUpOfUrineProteinLevelsDescriptionText"));   }
}
