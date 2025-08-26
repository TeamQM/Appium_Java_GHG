package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyActivityTableAnnualLabOfHbA1cLevelsEvery6Months;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_023_HomePage_Verify_ActivityTable_AnnualLabOfHbA1cLevelsEvery6Months {

        @Test(description = "[TC_Home_023]Verify Annual Lab of HbA1c Levels Every 6 months Screen",
                groups = {"regression", "registration_and_login"})
        public void verifyActivityTableAnnualLabOfHbA1cLevelsEvery6Months() throws FilloException, IOException, InterruptedException {
            VerifyActivityTableAnnualLabOfHbA1cLevelsEvery6Months home = new VerifyActivityTableAnnualLabOfHbA1cLevelsEvery6Months();
            home.isActivityTableAnnualLabOfHbA1cLevelsEvery6MonthsScreenDisplayed(

                    ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                    ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                    ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
                    ExcelDataReader.getLanguagesFromHomePage("HomePage").get("LabWorkUpOfHbA1cLevelsEvery6MonthsText"),
                    ExcelDataReader.getLanguagesFromHomePage("HomePage").get("LabWorkUpOfHbA1cLevelsEvery6MonthsDescriptionText"));

        }
}
