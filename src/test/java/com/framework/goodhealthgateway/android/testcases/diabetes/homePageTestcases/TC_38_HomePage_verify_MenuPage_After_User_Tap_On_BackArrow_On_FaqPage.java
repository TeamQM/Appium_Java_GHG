package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyMenuPageAfterUserTapOnBackArrowOnFaqPage;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_38_HomePage_verify_MenuPage_After_User_Tap_On_BackArrow_On_FaqPage {
	

	@Test(description = "[TC_Home_038] verify menuPage after user tap on back  arrow on FAQs page",
            groups = {"regression", "registration_and_login"})
    public void verifyMenuPageAfterUserTapOnBackArrowOnFaqPage() throws Exception {
        
		VerifyMenuPageAfterUserTapOnBackArrowOnFaqPage verifyMenuPageAfterUserTapOnBackArrowOnFaqPage = new VerifyMenuPageAfterUserTapOnBackArrowOnFaqPage();
		
		verifyMenuPageAfterUserTapOnBackArrowOnFaqPage.isMenuPageDisplayedAfterUserTapOnBackArrowOnFaqPage(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("FAQText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("MenuText"));
	}
	
}
