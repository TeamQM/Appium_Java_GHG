package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyAnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_026_027_028_HomePage_Verify_ActivityTable_AnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen {
    @Test(description = "[TC_Home_026,TC_Home_027,TC_Home_028]Verify Annual Agreement To Review And Share Your Diabetes Health Action Plan Care Guide With Your Doctor Screen",
            groups = {"regression", "registration_and_login"})
    public void verifyAnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen() throws FilloException, IOException, InterruptedException {
        VerifyAnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen verifyAnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen= new VerifyAnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen();
        verifyAnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen.isAnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualAgreementToReviewAndShareYourDHAPText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("AnnualAgreementToReviewAndShareYourDHAPDescriptionText"),
                ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DownloadDocumentsText"),
                ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DHAPText"));
    }
}
