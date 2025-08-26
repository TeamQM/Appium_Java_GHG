package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.verifyContactUsPageCallOrCancel;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_046_047_048_051_056_HomePage_Verify_ContactUsPage_CallOrCancel {


	@Test(description = "[TC_Home_046,TC_Home_047,TC_Home_048,TC_Home_051,TC_Home_056] verify contact page and popup to call or cancel after tap on contact us",
            groups = {"regression", "registration_and_login"})
    public void verifyContactUsPageCallOrCancel() throws Exception {

		verifyContactUsPageCallOrCancel verifyContactUsPageCallOrCancel = new verifyContactUsPageCallOrCancel();

		verifyContactUsPageCallOrCancel.isContactUsPageDisplayedAndVerifyCallOrCancelOptions(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("ContactUsText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("ThousandCharactersRemainingText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("QuestionCommentsFieldRequired"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("QuestionText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("MessageSentSucceessText"),

				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("MenuText"));
	}
	
}
