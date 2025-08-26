package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyMenuOptions;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_031_HomePage_Verify_MenuOptions_AfterClick_On_HamburgerMenu {

	@Test(description = "[TC_Home_031] Verify menu options after click on hamburger menu",
            groups = {"regression", "registration_and_login"})
    public void verifyMenuOptionsAfterClickOnHamburgerMenu() throws Exception {
		VerifyMenuOptions HomeGhgApp15 = new VerifyMenuOptions();
		HomeGhgApp15.isMenuOptionsDisplayedAfterClickOnHamburgerMenu(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("EditProfileText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQsText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("DiabetesResourcesText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("ContactUsText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("PrivacyPolicyText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("TermsAndConditionsText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("LogOffText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("UserEmailIdText"));}
	
}
