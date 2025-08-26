package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import java.io.IOException;

//import com.framework.android.screens.CommonHelper;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;
public class VerifyPrivacyPolicyTermAndConditionLoginPageIsDisplayed {

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

	public void isPrivacyPolicyTermAndConditionLoginPageIsDisplayed(String UserName, String Password, String PrivacyPolicyText, String MenuText, String TermsAndConditionsText, String LoginText)
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Privacy Policy , Terms & Conditions Screen validation and  Logout button Validation ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		CommonHelper.menuPageFlow();


		String strAct_privacyPolicyText=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "privacyPolicyText"),
					"privacypolicy");
			strAct_privacyPolicyText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "privacyPolicyText"),"content-desc");
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "privacyPolicy"),
					"privacypolicy");
			 strAct_privacyPolicyText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "privacyPolicyText"),"name");

		}
		String strExp_PrivacyPolicyText =PrivacyPolicyText;
		mobileActions.verifyText(strAct_privacyPolicyText, strExp_PrivacyPolicyText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
				"BackArrowButton");
		String strAct_menuText=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_menuText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			 strAct_menuText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "name");
		}
		String strExp_MenuText = MenuText;
		mobileActions.verifyText(strAct_menuText, strExp_MenuText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "TermAndCondition"),
				"TermAndCondition");
		String strAct_termAndConditionText=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_termAndConditionText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "TermAndCondition"),"content-desc");
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_termAndConditionText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "TermAndCondition_text"), "name");
		}
		String strExp_TermAndConditionText = TermsAndConditionsText;
		mobileActions.verifyText(strAct_termAndConditionText, strExp_TermAndConditionText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
				"BackArrowButton");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "LogOff"), "LogOff");
		String strAct_LoginText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_LoginText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "login_text"),"content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_LoginText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "login_text"), "name");
		}
		String strExp_LoginText = LoginText;
		mobileActions.verifyText(strAct_LoginText, strExp_LoginText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully Redirected To Privacy Policy , Terms & Conditions Login Screen Validation" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Privacy Policy , Terms & Conditions Login Screen Headers ===============" + "</b>");
	}
}
