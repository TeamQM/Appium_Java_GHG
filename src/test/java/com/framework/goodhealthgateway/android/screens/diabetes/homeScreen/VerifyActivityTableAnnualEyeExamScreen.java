package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import java.io.IOException;
public class VerifyActivityTableAnnualEyeExamScreen {
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
	public void isActivityTableAnnualEyeExamScreenDisplayed(String UserName, String Password, String WelcomeBackText, String AnnualEyeExamText, String AnnualEyeExamDescriptionText)

	throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Annual Eye Exam Screen Validation ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
		welcomeBackValidation(WelcomeBackText);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","AnnaulEyeExam"),"AnnaulEyeExam");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(162, 444);
		}
		String strAct_AnnualEyeExam = null;
		String strExp_AnnualEyeExam=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_AnnualEyeExam=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeExam"), "content-desc").stripLeading().substring(1,19);
			System.out.println("act == "+strAct_AnnualEyeExam.stripLeading());
			strExp_AnnualEyeExam = "\n" +
					"￼\n" +
					"Annual Eye Exam";

		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_AnnualEyeExam=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeExam"), "name").stripLeading();
			strExp_AnnualEyeExam = AnnualEyeExamText;
		}
		mobileActions.verifyText(strAct_AnnualEyeExam, strExp_AnnualEyeExam);
		String strAct_AnnaulEyeTextDescription =null;
		String strExp_AnnaulEyeTextDescription=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			Thread.sleep(1000);
			strAct_AnnaulEyeTextDescription=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "content-desc").stripLeading();
			 strExp_AnnaulEyeTextDescription = "￼\n" +
					 "￼\n" +
					 "You need to have an eye examination at least once a year. This can be completed by any of your physicians, but may need to be done by an eye care specialist, depending upon your physician’s recommendations.";
			;
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_AnnaulEyeTextDescription=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "name").stripLeading();
			 strExp_AnnaulEyeTextDescription = AnnualEyeExamDescriptionText;
		}
		mobileActions.verifyText(strAct_AnnaulEyeTextDescription, strExp_AnnaulEyeTextDescription);
		ReportManager.logScreenshotInfo();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"), "BackArrowButton");
		welcomeBackValidation(WelcomeBackText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully Annual Eye Exam Screen Displayed" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Annual Eye Exam Screen and Home Screen when user taps on Back arrow===============" + "</b>");

	}

	public void welcomeBackValidation(String WelcomeBackText)
	{
		String StrAct_WelcomeBackText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
		}
		String StrExp_WelcomeBackText = WelcomeBackText;
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
	}
}
