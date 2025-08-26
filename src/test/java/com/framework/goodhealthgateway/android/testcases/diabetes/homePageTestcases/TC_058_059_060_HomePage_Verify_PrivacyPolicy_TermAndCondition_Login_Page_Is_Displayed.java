package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyPrivacyPolicyTermAndConditionLoginPageIsDisplayed;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_058_059_060_HomePage_Verify_PrivacyPolicy_TermAndCondition_Login_Page_Is_Displayed {

	@Test(description = "[TC_Home_058,TC_Home_059,TC_Home_060]Verify privacy policy page, term and conditions and login page is displayed",
            groups = {"regression", "registration_and_login"})
    public void verifyPrivacyPolicyTermAndConditionLoginPageIsDisplayed() throws Exception {
        
		VerifyPrivacyPolicyTermAndConditionLoginPageIsDisplayed HomeGhgApp17 = new VerifyPrivacyPolicyTermAndConditionLoginPageIsDisplayed();
		
		HomeGhgApp17.isPrivacyPolicyTermAndConditionLoginPageIsDisplayed(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("PrivacyPolicyText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("MenuText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("TermsAndConditionsText"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("LoginText"));
	}
	
}
