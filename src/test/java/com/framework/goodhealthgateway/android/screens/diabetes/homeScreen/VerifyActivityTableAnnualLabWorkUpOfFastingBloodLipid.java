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
public class VerifyActivityTableAnnualLabWorkUpOfFastingBloodLipid {
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
	public void isActivityTableAnnualLabWorkUpOfFastingBloodLipidScreenDisplayed(String UserName, String Password,String WelcomeBackText, String AnnualLabWorkUpOfFastingBloodLipidText, String AnnualLabWorkUpOfFastingBloodLipidDescriptionText)
			throws InterruptedException, IOException, FilloException {
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
		Thread.sleep(5000);
		String StrAct_WelcomeBackText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
		}
		String StrExp_WelcomeBackText =WelcomeBackText;
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
		mobileActions.swipeUp(1);
		Thread.sleep(5000);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FastingBloodLipid"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			MobileActions.click(110, 305, "//XCUIElementTypeStaticText[contains(@name,\"Fasting\")]");
		}
		Thread.sleep(2000);
		String strAct_AnnualLabWorkUpOfFastingBloodLipid = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_AnnualLabWorkUpOfFastingBloodLipid=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FastingBloodLipid"), "content-desc").stripLeading();
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_AnnualLabWorkUpOfFastingBloodLipid=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Annaul"), "name").stripLeading();
		}
		String strExp_AnnualLabWorkUpOfFastingBloodLipid = AnnualLabWorkUpOfFastingBloodLipidText;
		Assert.assertTrue(strAct_AnnualLabWorkUpOfFastingBloodLipid.contains(strExp_AnnualLabWorkUpOfFastingBloodLipid));
		String strAct_AnnualLabWorkUpOfFastingBloodLipidDescription =null;
		String strExp_AnnualLabWorkUpOfFastingBloodLipidDescription =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_AnnualLabWorkUpOfFastingBloodLipidDescription = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "content-desc").stripLeading();
			 strExp_AnnualLabWorkUpOfFastingBloodLipidDescription ="￼\n" +
					 "￼\n" +
					 "You need to have your cholesterol checked at least once a year. A lipid profile measures total cholesterol, HDL cholesterol, LDL cholesterol, and triglycerides.";
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_AnnualLabWorkUpOfFastingBloodLipidDescription = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnaulEyeTextDescription"), "name").stripLeading();
			 strExp_AnnualLabWorkUpOfFastingBloodLipidDescription =AnnualLabWorkUpOfFastingBloodLipidDescriptionText;
		}
		mobileActions.verifyText(strAct_AnnualLabWorkUpOfFastingBloodLipidDescription, strExp_AnnualLabWorkUpOfFastingBloodLipidDescription);
		ReportManager.logScreenshotInfo();

	}
}
