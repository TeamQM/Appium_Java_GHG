package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import java.io.IOException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;


import com.codoid.products.exception.FilloException;

import org.testng.Assert;

public class VerifyMenuOptions {
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

	public void isMenuOptionsDisplayedAfterClickOnHamburgerMenu(String UserName, String Password, String EditProfileText, String FAQsText, String DiabetesResourcesText, String ContactUsText, String PrivacyPolicyText, String TermsAndConditionsText, String LogOffText, String UserEmailIdText)
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Menu Options Validation ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		CommonHelper.menuPageFlow();

		String StrAct_EditProfileText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_EditProfileText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "editProfile"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_EditProfileText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "editProfile"),"name");
		}
		String StrExp_EditProfileText =EditProfileText;
		mobileActions.verifyText(StrAct_EditProfileText, StrExp_EditProfileText);

		String StrAct_FAQsText =null ;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_FAQsText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FAQs_btn"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_FAQsText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FAQs_btn"),"name");
		}
		String StrExp_FAQsText =FAQsText;
		mobileActions.verifyText(StrAct_FAQsText, StrExp_FAQsText);

		String StrAct_DiabetesResourcesText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_DiabetesResourcesText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DiabetesResources"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_DiabetesResourcesText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DiabetesResources"),"name");
		}
		String StrExp_DiabetesResourcesText = DiabetesResourcesText;
		mobileActions.verifyText(StrAct_DiabetesResourcesText, StrExp_DiabetesResourcesText);

		String StrAct_ContactUsText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_ContactUsText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "contactUs_btn"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_ContactUsText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "contactUs_btn"),"name");
		}
		String StrExp_ContactUsText =ContactUsText;
		mobileActions.verifyText(StrAct_ContactUsText, StrExp_ContactUsText);

		String StrAct_PrivacyPolicyText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_PrivacyPolicyText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "privacyPolicyText"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_PrivacyPolicyText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "privacyPolicy"),"name");
		}
		String StrExp_PrivacyPolicy = PrivacyPolicyText;
		mobileActions.verifyText(StrAct_PrivacyPolicyText, StrExp_PrivacyPolicy);

		String StrAct_TermsAndConditionsText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_TermsAndConditionsText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "TermAndCondition"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_TermsAndConditionsText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "TermAndCondition"),"name");
		}
		String StrExp_TermsAndConditionsText =TermsAndConditionsText;
		mobileActions.verifyText(StrAct_TermsAndConditionsText, StrExp_TermsAndConditionsText);

		String StrAct_LogOffText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_LogOffText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "LogOff"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_LogOffText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "LogOff"),"name");
		}
		String StrExp_LogOffText = LogOffText;
		mobileActions.verifyText(StrAct_LogOffText, StrExp_LogOffText);
		Thread.sleep(2000);
		String StrAct_EmailText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_EmailText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Email"),"content-desc");
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_EmailText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Email"),"name");
		}
		Assert.assertEquals(StrAct_EmailText.contains(UserEmailIdText),true );
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully  Menu Options validated" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated validated menu options 'Edit Profile', 'FAQS', 'Diabetes Resources', 'Contact Us', 'Privacy Policy', 'Terms & Conditions', 'Log off', 'Email' ===============" + "</b>");


	}

}
