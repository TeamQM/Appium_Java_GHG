package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import java.io.IOException;


import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

public class VerifyProgramStepsAndRewardsScreen {

	MobileActions mobileActions = new MobileActions();
	CommonHelper CommonHelper = new CommonHelper();
	/**
	 * This method is to login on GHG application
	 * 
	 * @param UserName
	 * @param Password
	 * @throws InterruptedException
	 * @throws IOException
	 */


	public void isUserRedirectToProgramStepsRewardsScreen(String UserName, String Password, String ProgramStepsText, String WelcomeBackText, String RewardsText)
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Program Steps and Rewards Screen Validation ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ProgramStepsBtn"),
				"ProgramStepsBtn");
		String StrAct_programStepsText =null;

		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_programStepsText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ProgramSteps"),"content-desc").stripLeading();
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_programStepsText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ProgramSteps"),"name").stripLeading();
		}

		String StrExp_programStepsText =ProgramStepsText;
		mobileActions.verifyText(StrAct_programStepsText,StrExp_programStepsText);
		ReportManager.logScreenshotInfo();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackButton"), "BackButton");
		String StrAct_WelcomeBackText =null;

		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"),"name");
		}

		String StrExp_WelcomeBackText =WelcomeBackText;
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "RewardBtn"), "RewardBtn");
		String rewardBtnText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			rewardBtnText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Rewards"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			rewardBtnText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Rewards"),"name");
		}
		String ExpectedrewardBtnText = RewardsText;
		mobileActions.verifyText(rewardBtnText, ExpectedrewardBtnText);
		ReportManager.logScreenshotInfo();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackButton"), "BackButton");
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully Redirected To Program Steps and Rewards Screen " + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Program Steps and Rewards Screen Headers===============" + "</b>");

	}
}
