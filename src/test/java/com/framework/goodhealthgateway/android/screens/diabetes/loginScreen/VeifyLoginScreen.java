package com.framework.goodhealthgateway.android.screens.diabetes.loginScreen;

import java.io.IOException;



import org.openqa.selenium.By;
import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.screens.diabetes.homeScreen.VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.testng.Assert;

public class VeifyLoginScreen {
	MobileActions mobileActions = new MobileActions();
	CommonHelper CommonHelper = new CommonHelper();
	/**
	 * This method is to login on GHG application Ø
	 * @throws Exception 
	 *
	 * @throws FilloException
	 */
	
//	
//	public void loginInHW() throws Exception {
//		
//		
//		CommonHelper.loginWithValidUserNameAndPwdForHw(ExcelReader.excel("UserName", "LoginPage"),ExcelReader.excel("Password", "LoginPage"));
//		
//	}
//	
	
	
//	
//	public void checkingInbox() throws Exception {
//		
//		CommonHelper.checkingInboxTabAndItsFeatures(ExcelReader.excel("UserName", "LoginPage"),ExcelReader.excel("Password", "LoginPage"));
//	}
//	
	
	

	public void loginWithValidUserNameAndPwd(String UserName, String Password, String WelcomeBackText )
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Username and Password Validation ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
		String StrAct_WelcomeBackText = null;
		if (mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "OopsText"), "content-desc")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Okbutton"), "content-desc");

			ReportManager.logScreenshotInfo();
			ReportManager.logPass("<b style=\"color:green;\">" + "Successfully entered username and password" + "</b>");
			ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated Welcome back Text on  home page screen===============" + "</b>");

		} else {
			if (Constants.platformName.equalsIgnoreCase("android")) {
				StrAct_WelcomeBackText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
			} else if (Constants.platformName.equalsIgnoreCase("ios")) {
				StrAct_WelcomeBackText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
			}
			System.out.println("result  :" + StrAct_WelcomeBackText);
			String StrExp_WelcomeBackText = WelcomeBackText;
			mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
			ReportManager.logScreenshotInfo();
			ReportManager.logPass("<b style=\"color:green;\">" + "Successfully entered username and password" + "</b>");
			ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated Welcome back Text on  home page screen===============" + "</b>");
		}
	}

	public void loginWithNoUserNameAndPwd(String PleaseEnterUsernameText, String PleaseEnterPasswordText) throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Verify error message while user do not enters username and password ===============" + "</b>");
		Thread.sleep(5000);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Submit"), "Submit");
		Thread.sleep(5000);
		String strAct_PleaseEnterUsername =null ;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_PleaseEnterUsername=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "enterUsername"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_PleaseEnterUsername=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "enterUsername"), "enterUsername");
		}
		String strExp_PleaseEnterUsername = PleaseEnterUsernameText;
		mobileActions.verifyText(strAct_PleaseEnterUsername, strExp_PleaseEnterUsername);
		String strAct_PleaseEnterPassword = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_PleaseEnterPassword=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "EnterPwd"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_PleaseEnterPassword=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "EnterPwd"), "EnterPwd");
		}
		String strExp_PleaseEnterPassword = PleaseEnterPasswordText;
		mobileActions.verifyText(strAct_PleaseEnterPassword, strExp_PleaseEnterPassword);
		Thread.sleep(5000);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully verified error message while user do not enters username and password" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated 'Please enter username', 'Please enter password' Text===============" + "</b>");
	}

	public void loginWithValidUserNameInvalidPasswordAndInvalidUsernameValidPassword(String ValidUserName, String InValidPassword,
																					 String InValidUserName, String ValidPassword, String LoginFailedPleaseTryAgainText) throws InterruptedException, IOException, FilloException {
		// ==================================Login With correct UserName And InCorrect
		// Password========================= //
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Login with valid username invalid password and invalid username valid password ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(ValidUserName, InValidPassword);
		String strAct_loginInFailedText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_loginInFailedText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "loginFailedText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_loginInFailedText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "loginFailedText"), "name");
		}
		String strExp_loginInFailedText =LoginFailedPleaseTryAgainText;
		mobileActions.verifyText(strAct_loginInFailedText, strExp_loginInFailedText);
		// ==================================Login With Incorrect UserName And Correct
		// Password========================= //
		CommonHelper.loginWithValidUserNameAndPwd(InValidUserName, ValidPassword);
		mobileActions.verifyText(strAct_loginInFailedText, strExp_loginInFailedText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully verified error message while user do not enters username and password" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated 'Please enter username', 'Please enter password' Text===============" + "</b>");

	}

	public void loginWithUserNameOnly(String UserName , String PleaseEnterPasswordText) throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Enter Only Username and submit ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, "");
		String strAct_PleaseEnterPassword =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_PleaseEnterPassword=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "EnterPwd"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_PleaseEnterPassword=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "EnterPwd"), "EnterPwd");
		}
		String strExp_PleaseEnterPassword = PleaseEnterPasswordText;
		mobileActions.verifyText(strAct_PleaseEnterPassword, strExp_PleaseEnterPassword);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully entered username and submitted" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated error message 'Please enter password' Text===============" + "</b>");

	}

	public void loginWithPwdOnly(String Password, String PleaseEnterUsernameText ) throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Login with valid username invalid password and invalid username valid password ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd("", Password);
		String strAct_PleaseEnterUsername = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_PleaseEnterUsername=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "enterUsername"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_PleaseEnterUsername=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "enterUsername"), "enterUsername");
		}
		String strExp_PleaseEnterUsername =PleaseEnterUsernameText;
		mobileActions.verifyText(strAct_PleaseEnterUsername, strExp_PleaseEnterUsername);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully verified error message while user do not enters username and password" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated 'Please enter username', 'Please enter password' Text===============" + "</b>");

	}

	public void userTapOnEyeIcon(String Password) throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Verify Password===============" + "</b>");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "EyeIcon"), "EyeIcon");

		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Password"), Password);
		}
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Password"), Password);
		mobileActions.hideKeyboard();

		Thread.sleep(5000);
		String strAct_passwordText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_passwordText=DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.widget.EditText[@index='2']")).getText();
			System.out.println("strAct_passwordText ...:"+strAct_passwordText);
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_passwordText=DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeTextField[@name='Password']")).getAttribute("value");
		}
		System.out.println(Password);
		Assert.assertTrue(strAct_passwordText.contains(Password));

		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully verified error message while user do not enters username and password" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated 'Please enter username', 'Please enter password' Text===============" + "</b>");


	}


	public void userWithoutPointingPhoneTowardsFace(String UserName, String Password, String OnBoardingHomeText, String FaceNotRecognisedText_Android, String FaceNotRecognisedText, String TryAgainText_Android, String TryAgainText, String TryFaceIDAgainText_Android, String TryFaceIDAgainText,String BiometricLoginCancelledNotSupportedText
                                                     ) throws IOException, InterruptedException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Login with valid username invalid password and invalid username valid password ===============" + "</b>");
		VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons = new VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons();
		verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons.enableDisableBiometricLogin(UserName,Password,OnBoardingHomeText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "FingerPrint"),
				"FingerPrint");
		String strAct_faceNotRecognisedText =null;
		String strExp_faceNotRecognisedText=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "FaceRecognition"),"Face Recognition");
			strAct_faceNotRecognisedText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "AuthenticationRequired"), "name");
			strExp_faceNotRecognisedText = FaceNotRecognisedText_Android;
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_faceNotRecognisedText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "AuthenticationRequired"), "name");
			strExp_faceNotRecognisedText =FaceNotRecognisedText;
		}
		System.out.println("strAct_faceNotRecognisedText.."+strAct_faceNotRecognisedText);
		System.out.println("strExp_faceNotRecognisedText.."+strExp_faceNotRecognisedText);
		mobileActions.verifyText(strAct_faceNotRecognisedText, strExp_faceNotRecognisedText);

		String strAct_tryAgainText = null;
		String strExp_TryAgainText=null;
		Thread.sleep(1000);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_tryAgainText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "TryAgain"), "content-desc");
			strExp_TryAgainText =TryAgainText_Android;
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_tryAgainText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "TryAgain"), "name");
			strExp_TryAgainText =TryAgainText;
		}
		mobileActions.verifyText(strAct_tryAgainText, strExp_TryAgainText);

		String strAct_tryfaceIdAgainText =null;
		String strExp_tryfaceIdAgainText=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_tryfaceIdAgainText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "TryfaceIdAgain"), "content-desc");
			strExp_tryfaceIdAgainText = TryFaceIDAgainText_Android;
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_tryfaceIdAgainText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "TryfaceIdAgain"), "name");
			strExp_tryfaceIdAgainText = TryFaceIDAgainText;
		}
		mobileActions.verifyText(strAct_tryfaceIdAgainText, strExp_tryfaceIdAgainText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Cancel2"), "name");

		String strAct_LoginText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_LoginText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "BiometricLoginCancelled"), "content-desc");
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_LoginText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "BiometricLoginCancelled"), "name");
			System.out.println("act ==" + strAct_LoginText);
		}
		String strExp_LoginText = BiometricLoginCancelledNotSupportedText;
		mobileActions.verifyText(strAct_LoginText, strExp_LoginText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully verified error message while user do not enters username and password" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated 'Please enter username', 'Please enter password' Text===============" + "</b>");

	}


	public void verifyLoginPageAfterClickCancelOnAuthenticationPage(String UserName, String Password, String OnBoardingHomeText, String FaceNotRecognisedText_Android, String FaceNotRecognisedText, String TryAgainText_Android, String TryAgainText, String TryFaceIDAgainText_Android, String TryFaceIDAgainText,String BiometricLoginCancelledNotSupportedText) throws IOException, InterruptedException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Login with valid username invalid password and invalid username valid password ===============" + "</b>");
		VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons = new VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons();
		verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons.enableDisableBiometricLogin(UserName,Password, OnBoardingHomeText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "FingerPrint"),
				"FingerPrint");
		String strAct_faceNotRecognisedText = null;
		String strExp_faceNotRecognisedText=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "FaceRecognition"),"Face Recognition");
			strAct_faceNotRecognisedText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "AuthenticationRequired"), "content-desc");
			 strExp_faceNotRecognisedText =FaceNotRecognisedText_Android;
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_faceNotRecognisedText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "AuthenticationRequired"), "name");
			 strExp_faceNotRecognisedText = FaceNotRecognisedText;
		}
		mobileActions.verifyText(strAct_faceNotRecognisedText, strExp_faceNotRecognisedText);
		Thread.sleep(1000);
		String strAct_tryAgainText =null;
		String strExp_TryAgainText=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_tryAgainText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "TryAgain"), "Retry");
			strExp_TryAgainText = TryAgainText_Android;
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_tryAgainText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "TryAgain"), "name");
			strExp_TryAgainText =TryAgainText;
		}
		mobileActions.verifyText(strAct_tryAgainText, strExp_TryAgainText);

		String strAct_tryfaceIdAgainText =null;
		String strExp_tryfaceIdAgainText=null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_tryfaceIdAgainText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "TryfaceIdAgain"), "Couldn't verify your identity");
			strExp_tryfaceIdAgainText = TryFaceIDAgainText_Android;
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_tryfaceIdAgainText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "TryfaceIdAgain"), "name");
			strExp_tryfaceIdAgainText = TryFaceIDAgainText;
		}
		mobileActions.verifyText(strAct_tryfaceIdAgainText, strExp_tryfaceIdAgainText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Cancel2"), "Cancel2");

		String strAct_LoginText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_LoginText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "BiometricLoginCancelled"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_LoginText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "BiometricLoginCancelled"), "name");
		}
		String strExp_LoginText =BiometricLoginCancelledNotSupportedText;
		mobileActions.verifyText(strAct_LoginText, strExp_LoginText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully verified error message while user do not enters username and password" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated 'Please enter username', 'Please enter password' Text===============" + "</b>");



	}

	public void verifyLoginPageAfterClickCancelOnAuthenticationPageFingerPrint(String UserName, String Password, String OnBoardingHomeText, String FaceNotRecognisedText_Android, String BiometricLoginCancelledNotSupportedText) throws IOException, InterruptedException
	{
		if (Constants.platformName.equalsIgnoreCase("android"))
		{
			ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Login with valid username invalid password and invalid username valid password ===============" + "</b>");
			VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons = new VerifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons();
			verifyBiometricLoginAndShowFeaturesOnStartUpToggleButtons.enableDisableBiometricLogin(UserName, Password, OnBoardingHomeText);
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "FingerPrint"),
					"FingerPrint");
			String strAct_faceNotRecognisedText = null;
			String strExp_faceNotRecognisedText = null;
			strAct_faceNotRecognisedText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "AuthenticationRequired"), "content-desc");
			strExp_faceNotRecognisedText = FaceNotRecognisedText_Android;

			//String strExp_faceNotRecognisedText = "Face Not Recognised";
			mobileActions.verifyText(strAct_faceNotRecognisedText, strExp_faceNotRecognisedText);
			Thread.sleep(1000);

			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Cancel2"), "Cancel2");

			String strAct_LoginText = null;
			strAct_LoginText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "BiometricLoginCancelled"), "content-desc");

			String strExp_LoginText = BiometricLoginCancelledNotSupportedText;
			mobileActions.verifyText(strAct_LoginText, strExp_LoginText);
			ReportManager.logScreenshotInfo();
			ReportManager.logPass("<b style=\"color:green;\">" + "Successfully verified error message while user do not enters username and password" + "</b>");
			ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully Validated 'Please enter username', 'Please enter password' Text===============" + "</b>");


		}
	}

		public void verifyErrorMessageForToManyAttemptsOfIncorrectPassword(String UserName, String Password, String ErrorMessageforTooManyAttemptText) throws InterruptedException {
			ReportManager.logInfo("Test started login");
		//	for (int i =0; i<=10; i++)
				for (int i =0; i<=9; i++)
			{
				System.out.println(i);
				if (Constants.platformName.equalsIgnoreCase("android")) {
					mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "UserName"), UserName);
				}
				Thread.sleep(500);
				mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "UserName"), UserName);
				mobileActions.hideKeyboard();
				if (Constants.platformName.equalsIgnoreCase("android")) {
					mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Password"), Password);
				}
				mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Password"), Password);
				mobileActions.hideKeyboard();
				//Thread.sleep(5000);
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Submit"), "Submit");
			}
			String strExp_ErrorMessageforTooManyAttempts = ErrorMessageforTooManyAttemptText;
			String strAct_ErrorMessageforTooManyAttempts =  null;
			Thread.sleep(500);
			if (Constants.platformName.equalsIgnoreCase("android")) {
				mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","ErrorMessageforTooManyAttempts"),"content-desc");
			}
			mobileActions.verifyText(strAct_ErrorMessageforTooManyAttempts,strExp_ErrorMessageforTooManyAttempts);
			}

}
