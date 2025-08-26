package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.testng.Assert;

import java.io.IOException;

public class VerifyActivityTableAnnualPhoneInterviewWithDiabetesEducator {
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
	public void isActivityTableAnnualPhoneInterviewWithDiabetesEducatorScreenDisplayed(String UserName, String Password, String WelcomeBackText, String AnnualPhoneInterviewWithDiabetesEducatorText, String AnnualPhoneInterviewWithDiabetesEducatorDescriptionText)
			throws InterruptedException, IOException, FilloException {
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
		Thread.sleep(1000);
		String StrAct_WelcomeBackText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
		}
		String StrExp_WelcomeBackText = WelcomeBackText;
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
		mobileActions.swipeUp(2);
		Thread.sleep(5000);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			Thread.sleep(1000);
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DiabetesEducator"),"Diabetes Educator");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(170, 320);
		}
		Thread.sleep(1000);
		String strAct_AnnualPhoneInterviewText= null;
		String strExp_AnnualPhoneInterviewText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			Thread.sleep(500);
			strAct_AnnualPhoneInterviewText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DiabetesEducator"), "content-desc").stripLeading();
			 strExp_AnnualPhoneInterviewText ="￼\n" +
					 "￼\n" +
					 "Annual Phone Interview with Diabetes Educator";
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_AnnualPhoneInterviewText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Annaul"), "name").stripLeading();
			System.out.println("act  ="+ strAct_AnnualPhoneInterviewText);
			 strExp_AnnualPhoneInterviewText = AnnualPhoneInterviewWithDiabetesEducatorText;
			System.out.println("exp  ="+ strExp_AnnualPhoneInterviewText);
		}
		mobileActions.verifyText(strAct_AnnualPhoneInterviewText, strExp_AnnualPhoneInterviewText);
		String strAct_AnnualPhoneInterviewDescriptionText =null;
		String strExp_AnnualPhoneInterviewDescriptionText = null;
		Thread.sleep(500);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_AnnualPhoneInterviewDescriptionText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "YouWill"), "content-desc").stripLeading();
			 strExp_AnnualPhoneInterviewDescriptionText = "￼\n" +
					 "￼\n" +
					 "You will need to have a brief telephone discussion with our Good Health Gateway￼ Diabetes Educator once a year to develop your customized Diabetes Health Action Plan￼ Care Guide.\n" +
					 "®\n" +
					 "®";
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_AnnualPhoneInterviewDescriptionText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "YouWill"), "name").stripLeading();
			strExp_AnnualPhoneInterviewDescriptionText = AnnualPhoneInterviewWithDiabetesEducatorDescriptionText;
		}	mobileActions.verifyText(strAct_AnnualPhoneInterviewDescriptionText, strExp_AnnualPhoneInterviewDescriptionText);
		ReportManager.logScreenshotInfo();
	}

	public void isScheduleNewInterviewDisplayed(String ScheduleNewInterviewText, String SchedulingInterviewWebsiteText) throws InterruptedException, IOException {

		String strAct_ScheduleNewInterviewText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.swipeUp(1);
			Thread.sleep(500);
		 strAct_ScheduleNewInterviewText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "scheduleNextInterview"), "content-desc");

		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {

		strAct_ScheduleNewInterviewText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "scheduleNextInterview"), "name");
		}
		String strExp_ScheduleNewInterviewText = ScheduleNewInterviewText;
		mobileActions.verifyText(strAct_ScheduleNewInterviewText, strExp_ScheduleNewInterviewText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "scheduleNextInterview"),"scheduleNextInterview");
		Thread.sleep(1000);
		if (Constants.platformName.equalsIgnoreCase("ios")) {

			String strAct_SchedulingUrlText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "schedulingWebsiteUrl"),"schedulingWebsiteUrl");
			Assert.assertEquals(strAct_SchedulingUrlText.contains(SchedulingInterviewWebsiteText),true );		}

		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully User Redirected To Schedule Interview Website" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Schedule Interview Website And Schedule Interview Text ===============" + "</b>");

	}
}
