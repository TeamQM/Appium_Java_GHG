package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyActivityTableAnnualEyeExamScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;
@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_018_019_HomePage_Verify_ActivityTable_AnnualEyeExamScreen {
    @Test(description = "[TC_Home_018,TC_Home_019]Verify Activity Table Annual Eye Exam Screen and When user taps on back arrow it should redirect to Home Screen",
            groups = {"regression", "registration_and_login"})
    public void verifyActivityTableAnnualEyeExamScreen() throws FilloException, IOException, InterruptedException {
        VerifyActivityTableAnnualEyeExamScreen verifyActivityTableAnnualEyeExamScreen = new VerifyActivityTableAnnualEyeExamScreen();
        verifyActivityTableAnnualEyeExamScreen.isActivityTableAnnualEyeExamScreenDisplayed(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualEyeExamText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualEyeExamDescriptionText"));
    }
}
