package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyOnboardingScreens;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_001_002_003_004_005_006_007_HomePage_Verify_OnboardingScreens {
	
	  @Test(description = " [TC_Home_001, TC_Home_003,TC_Home_005]Verify onboarding screens home, message, documents, close and next when user login for first time",
	            groups = {"regression", "registration_and_login"})
	    public void verifyOnboardingHomeCloseAndNext() throws Exception {
		  VerifyOnboardingScreens verifyOnboardingHomeCloseAndNext= new VerifyOnboardingScreens();
		  verifyOnboardingHomeCloseAndNext.isOnboardingScreensDisplayed(
				  ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				  ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingHomeText"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingCloseBtnText"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingNextBtnText"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingMessageText"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingDocumentText"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"));
	  }
	}
