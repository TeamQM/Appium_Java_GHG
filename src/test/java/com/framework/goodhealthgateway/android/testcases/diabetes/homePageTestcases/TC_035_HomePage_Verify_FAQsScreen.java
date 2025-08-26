package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyFAQsScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_035_HomePage_Verify_FAQsScreen {
    @Test(description = "[TC_Home_035] verify FAQs Screen",
            groups = {"regression", "registration_and_login"})
    public void verifyFAQsScreen() throws Exception {
        VerifyFAQsScreen verifyFAQsScreen = new VerifyFAQsScreen();
        verifyFAQsScreen.isFAQsScreenDisplayedAndValidatedScreen(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQConfirmationFormText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQSimplyProvideSeperateCopyText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQHemoglobinA1cTestText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQOverTimeHighBloodSugarEffectsText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQLookForCutsText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQBecauseDiabetesText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQItIsBestToHaveAnEyeDoctorText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQBeingSickByItselfText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQPeopleWithUncontrolleddiabetesText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQkidneyProblemsText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQYourDoctorOrOtherHealthCareText"));
    }
}
