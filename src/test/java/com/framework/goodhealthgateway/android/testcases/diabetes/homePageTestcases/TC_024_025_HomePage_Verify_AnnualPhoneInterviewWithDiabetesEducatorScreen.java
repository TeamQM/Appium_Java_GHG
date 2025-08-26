package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyActivityTableAnnualPhoneInterviewWithDiabetesEducator;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_024_025_HomePage_Verify_AnnualPhoneInterviewWithDiabetesEducatorScreen {
    @Test(description = "[TC_Home_024]Verify Annual Phone Interview With Diabetes Educator Screen",
            groups = {"regression", "registration_and_login"})
    public void verifyActivityTableAnnualPhoneInterviewWithDiabetesEducator() throws FilloException, IOException, InterruptedException {
        VerifyActivityTableAnnualPhoneInterviewWithDiabetesEducator verifyActivityTableAnnualPhoneInterviewWithDiabetesEducator = new VerifyActivityTableAnnualPhoneInterviewWithDiabetesEducator();
        verifyActivityTableAnnualPhoneInterviewWithDiabetesEducator.isActivityTableAnnualPhoneInterviewWithDiabetesEducatorScreenDisplayed(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualPhoneInterviewWithDiabetesEducatorText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualPhoneInterviewWithDiabetesEducatorDescriptionText"));
    }
    @Test(description = "[TC_Home_025]Verify user taps 'Schedule New Interview' button  redirected to the GHG Acuity scheduling website.",
            groups = {"regression", "registration_and_login"})
    public void verifySchedulingInterviewScreen() throws FilloException, IOException, InterruptedException {
        VerifyActivityTableAnnualPhoneInterviewWithDiabetesEducator verifyActivityTableAnnualPhoneInterviewWithDiabetesEducator = new VerifyActivityTableAnnualPhoneInterviewWithDiabetesEducator();
        verifyActivityTableAnnualPhoneInterviewWithDiabetesEducator.isActivityTableAnnualPhoneInterviewWithDiabetesEducatorScreenDisplayed(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName1"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualPhoneInterviewWithDiabetesEducatorText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualPhoneInterviewWithDiabetesEducatorDescriptionText"));
                verifyActivityTableAnnualPhoneInterviewWithDiabetesEducator.isScheduleNewInterviewDisplayed(
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("ScheduleNewInterviewText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("SchedulingInterviewWebsiteText"));
    }
    }
