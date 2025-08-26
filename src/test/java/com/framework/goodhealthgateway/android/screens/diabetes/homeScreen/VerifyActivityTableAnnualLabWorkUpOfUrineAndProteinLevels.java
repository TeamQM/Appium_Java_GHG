package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;


import java.io.IOException;
public class VerifyActivityTableAnnualLabWorkUpOfUrineAndProteinLevels {
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
	public void isActivityTableAnnualLabWorkUpOfUrineAndProteinLevelsScreensDisplayed(String UserName, String Password, String WelcomeBackText, String AnnualLabWorkUpOfUrineProteinLevelsText, String AnnualLabWorkUpOfUrineProteinLevelsDescriptionText)
			throws InterruptedException, IOException, FilloException {
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");

		
		Thread.sleep(5000);
		String StrAct_WelcomeBackText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			Thread.sleep(1000);
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
		}
		String StrExp_WelcomeBackText = WelcomeBackText;
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
		mobileActions.swipeUp(1);
		Thread.sleep(5000);

		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "UrineLevel"), "UrineLevel");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(153, 422);
		}
		Thread.sleep(2000);
		String AnnualLabWorkUpOfUrine= null;
		String ExpectedText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			AnnualLabWorkUpOfUrine=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "UrineLevel"), "content-desc").stripLeading();
			 ExpectedText = "￼\n" +
					 "￼\n" +
					 "Annual Lab Work-up of Urine/Protein Levels";
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			AnnualLabWorkUpOfUrine=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Annaul"), "name").stripLeading();
			 ExpectedText = AnnualLabWorkUpOfUrineProteinLevelsText;}

		mobileActions.verifyText(AnnualLabWorkUpOfUrine, ExpectedText);
		String AnnualabWorkUpOfUrineDescription = null;
		String ExpectedText2 = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			AnnualabWorkUpOfUrineDescription=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "content-desc").stripLeading();
			 ExpectedText2 = "￼\n" +
					 "￼\n" +
					 "You need to have your urine/protein levels checked at least once a year.";
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			AnnualabWorkUpOfUrineDescription=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "name").stripLeading();
			 ExpectedText2 = AnnualLabWorkUpOfUrineProteinLevelsDescriptionText;
		}
		mobileActions.verifyText(AnnualabWorkUpOfUrineDescription, ExpectedText2);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Annual Lab WorkUp Of Urine And Protein Levels Screen Displayed" + "</b>");

		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Annual Lab WorkUp Of Urine And Protein Levels Screen and Home Screen when user taps on Back arrow===============" + "</b>");


	}
}
