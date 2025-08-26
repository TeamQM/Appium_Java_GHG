package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import java.io.IOException;
public class VerifyActivityTableAnnualFootExamScreen {
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
	public void isActivityTableAnnualFootExamScreenDisplayed(String UserName, String Password, String WelcomeBackText, String AnnualFootExamText, String AnnualFootExamDescriptionText)
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Annual Foot Exam Screen Validation ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
		String StrAct_WelcomeBackText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			Thread.sleep(1000);
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
		}
		String StrExp_WelcomeBackText = WelcomeBackText;
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);

		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnualFootExam"), "Close");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.click(107, 603, "//XCUIElementTypeStaticText[contains(@name,'Annual Foot ')]");
		}

		String strAct_AnnualFootExamText = null;
		String ExpectedMenuText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_AnnualFootExamText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnualFootExam"), "content-desc").stripLeading().substring(1,20);
			 ExpectedMenuText ="\n" +
					 "￼\n" +
					 "Annual Foot Exam";
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_AnnualFootExamText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Annaul"), "name").stripLeading();
			 ExpectedMenuText =AnnualFootExamText;
		}
		mobileActions.verifyText(strAct_AnnualFootExamText, ExpectedMenuText);
		String strAct_AnnaulFootTextDescription = null;
		String strExp_AnnaulFootTextDescription = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_AnnaulFootTextDescription = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "content-desc").stripLeading();
			 strExp_AnnaulFootTextDescription = "￼\n" +
					 "￼\n" +
					 "You need to have a foot examination at least once a year. This can be completed by any of your physicians, but may need to be done by a podiatrist, depending upon your physician’s recommendations.";;
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_AnnaulFootTextDescription = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "name").stripLeading();
			 strExp_AnnaulFootTextDescription = AnnualFootExamDescriptionText;
		}
		mobileActions.verifyText(strAct_AnnaulFootTextDescription, strExp_AnnaulFootTextDescription);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully Annual Eye Exam Screen Displayed" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Annual Eye Exam Screen and Home Screen when user taps on Back arrow===============" + "</b>");


	}
}
