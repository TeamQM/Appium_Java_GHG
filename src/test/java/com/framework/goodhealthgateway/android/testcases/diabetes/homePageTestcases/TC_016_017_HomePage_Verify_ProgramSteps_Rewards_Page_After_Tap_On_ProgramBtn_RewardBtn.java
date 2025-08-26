package com.framework.goodhealthgateway.android.testcases.diabetes.homePageTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyProgramStepsAndRewardsScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;


@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_016_017_HomePage_Verify_ProgramSteps_Rewards_Page_After_Tap_On_ProgramBtn_RewardBtn {
	
	@Test(description = "[TC_Home_016,TC_Home_017] verify programsteps page, rewards page after tap on program button",
            groups = {"regression", "registration_and_login"})
    public void verifyProgramStepsRewardsPageAfterTapOnProgramBtnAndRewardBtn() throws Exception {
		VerifyProgramStepsAndRewardsScreen HomeGhgApp18 = new VerifyProgramStepsAndRewardsScreen();
		HomeGhgApp18.isUserRedirectToProgramStepsRewardsScreen(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("ProgramStepsText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("RewardsText"));
	}
	
}
