package com.framework.goodhealthgateway.android.testcases.diabetes.loginScreen;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.loginScreen.VeifyLoginScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_012_013_014_015_016_017_018_038_039_040_041_043_044_loginPage
{
	@Test(dataProviderClass = ExcelDataReader.class,priority=1,enabled=false,description = " [TC_Login_013,TC_Login_018]Verify user is able to login  with valid credentials in GHS application and land on Home page successfully", groups = {
			"regression", "registration_and_login" })
	public void verifyUserLoginWithValidUnAndPwd() throws Exception {
		VeifyLoginScreen veifyloginScreen = new VeifyLoginScreen();
		veifyloginScreen.loginWithValidUserNameAndPwd(	ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"));

	}
	
	
	
//	@Test
//	public void verifyUserWithValidCredentials() throws Exception {
//VeifyLoginScreen verifyLoginScreen=		new VeifyLoginScreen();
//verifyLoginScreen.loginInHW();
//	}
	
	
//	
//	@Test(description = "To test the features of inbox page")
//	public void testingInbox() throws Exception {
//		
//	VeifyLoginScreen verifyLoginScreen=	new VeifyLoginScreen();
//	verifyLoginScreen.checkingInbox();
//	
//	}
	
	
	

//	@Test(priority=2, dataProviderClass = ExcelDataReader.class,description = "[TC_LoginPage_014]Verify error message while user enters no username and password", groups = { "regression",
//			"registration_and_login" })
//	public void verifyUserUnableToLoginWithNoUnAndPwd() throws Exception {
//		VeifyLoginScreen veifyLoginScreen = new VeifyLoginScreen();
//		veifyLoginScreen.loginWithNoUserNameAndPwd(
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("PleaseEnterUsernameText"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("PleaseEnterPasswordText"));
//
//
//	}
//
//	@Test(priority=3,description = " [TC_LoginPage_015]Verify error message while user enters correct username and incorrect password or incorrect username and correct password", groups = {
//			"regression", "registration_and_login" })
//	public void verifyUserLoginWithValidUnInvalidPwdAndInvalidUnVaildPwd() throws Exception {
//		VeifyLoginScreen veifyloginScreen = new VeifyLoginScreen();
//
//		veifyloginScreen.loginWithValidUserNameInvalidPasswordAndInvalidUsernameValidPassword(
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("InvalidPassword"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("InvalidUserName"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("LoginFailedPleaseTryAgainText"));
//
//	}
//
//	@Test(priority=4, dataProviderClass = ExcelDataReader.class,description = "[TC_Login_016]Verify error message while user enters userName only", groups = { "regression",
//			"registration_and_login" })
//	public void loginWithUserNameOnly() throws Exception {
//		VeifyLoginScreen veifyloginScreen = new VeifyLoginScreen();
//		veifyloginScreen.loginWithUserNameOnly(
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("PleaseEnterPasswordText"));
//
//	}
//
//	@Test(priority=5, dataProviderClass = ExcelDataReader.class,description = "[TC_Login_017]Verify error message while user enters password only", groups = { "regression",
//			"registration_and_login" })
//	public void loginWithPwdOnly() throws Exception {
//		VeifyLoginScreen veifyloginScreen = new VeifyLoginScreen();
//		veifyloginScreen.loginWithPwdOnly(
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("PleaseEnterUsernameText"));
//	}
//
//	@Test(priority=6,dataProviderClass = ExcelDataReader.class,description = " [TC_LoginPage_019]Verify password displayed when user tap on eye icon", groups = { "regression",
//			"registration_and_login" })
//	public void verifyPwdByTapOnEyeIcon() throws Exception {
//		VeifyLoginScreen veifyloginScreen = new VeifyLoginScreen();
//		veifyloginScreen.userTapOnEyeIcon(ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"));
//
//	}
//	@Test(priority=7,dataProviderClass = ExcelDataReader.class,description = "[TC_Login_041]Verify authentication required popup, identitiy, no face detected  and rety/cancel",
//            groups = {"regression", "registration_and_login"})
//    public void verifyAuthenticationRequiredPopup() throws Exception {
//
//		VeifyLoginScreen veifyloginScreen = new VeifyLoginScreen();
//
//		veifyloginScreen.userWithoutPointingPhoneTowardsFace(
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
//				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingHomeText"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("FaceNotRecognisedText_Android"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("FaceNotRecognisedText"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("TryAgainText_Android"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("TryAgainText"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("TryFaceIDAgainText_Android"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("TryFaceIDAgainText"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("BiometricLoginCancelledNotSupportedText"));
//	}
//
//	@Test(priority=8,dataProviderClass = ExcelDataReader.class,description = "[TC_Login_042]Verify login page after user tap cancel on authentication popup",
//            groups = {"regression", "registration_and_login"})
//    public void verifyLoginPageAfterUserTapCancelOnAuthenticationPopup() throws Exception {
//
//		VeifyLoginScreen veifyloginScreen = new VeifyLoginScreen();
//		veifyloginScreen.verifyLoginPageAfterClickCancelOnAuthenticationPage(
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
//				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingHomeText"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("FaceNotRecognisedText_Android"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("FaceNotRecognisedText"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("TryAgainText_Android"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("TryAgainText"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("TryFaceIDAgainText_Android"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("TryFaceIDAgainText"),
//				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("BiometricLoginCancelledNotSupportedText"));
//
//	}

	
}
