package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyActivityTableAnnualFootExamScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_020_HomePage_Verify_ActivityTable_AnnualFootExamScreen {
    @Test(description = "[TC_Home_021]Verify Activity Table Annual Foot Exam Screen",
            groups = {"regression", "registration_and_login"})
    public void verifyActivityTableAnnualFootExamScreen() throws FilloException, IOException, InterruptedException {
        VerifyActivityTableAnnualFootExamScreen verifyActivityTableAnnualFootExamScreen = new VerifyActivityTableAnnualFootExamScreen();
        verifyActivityTableAnnualFootExamScreen.isActivityTableAnnualFootExamScreenDisplayed(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualFootExamText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualFootExamDescriptionText")); }
}
