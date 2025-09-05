
package com.framework.goodhealthgateway.android.testcases.healthyweight.logintestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.healthyweight.loginscreen.VerifyLoginScreen_HW;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;

@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_05_LoginWithValidCredentials{
	
	
	
	/**
	 * =============================================================================
	 * Method: testLoginWithValidCredentials
	 * Description: Verify that user is able to log in with valid credentials and navigate to Home.
	 * Groups/Tags: Login, Smoke
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */

	@Test(description ="Verify that user is able to log in with valid credentials and navigate to the home screen.",groups= {"Login","Smoke"})
	public void testLoginWithValidCredentials() throws Exception {

	VerifyLoginScreen_HW loginScreen_Hw=	new VerifyLoginScreen_HW();
		
	loginScreen_Hw.loginInHW();
		
	}
	
	
	/**
	 * =============================================================================
	 * Method: testForgotPasswordNavigation
	 * Description: Verify Forgot Password link navigates and header is correct.
	 * Groups/Tags: Login, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 **/
	
	@Test(enabled=false,description="Verify that clicking on the Forgot Password link navigates to the Forgot Password screen and validates the header text.",groups= {"Login","Regression"})
	public void testForgotPasswordNavigation() throws Exception{
		
		
		  		VerifyLoginScreen_HW    loginScreen_HW=					new VerifyLoginScreen_HW();
		loginScreen_HW.forgotPasswordInHw();	
		
	}
	
	
	/**
	 * =============================================================================
	 * Method: testLoginWithEmptyCredentials
	 * Description: Verify error messages when login is attempted with empty fields.
	 * Groups/Tags: Login, Negative, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */

	@Test(description="Verify that error messages are displayed when login is attempted with empty credentials.",groups= {"Login","Negative","Regression"})
	public void testLoginWithEmptyCredentials() throws Exception{
		VerifyLoginScreen_HW    loginScreen_HW=					new VerifyLoginScreen_HW();
		loginScreen_HW.loginWithEmptyCredentials();
	}
	
	
	
	/**
	 * =============================================================================
	 * Method: testAppVersionPopup
	 * Description: Verify App Version hyperlink shows popup and dismisses correctly.
	 * Groups/Tags: Login, UI, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */

	@Test(enabled=false,description="Verify that clicking on the App Version hyperlink displays a popup with correct content and dismisses it with OK button.",groups= {"Login","UI","Regression"})
	public void testAppVersionPopup() throws Exception{
	VerifyLoginScreen_HW    loginScreen_HW=	new VerifyLoginScreen_HW();
	
	loginScreen_HW.verifyAppUpdatePopupFunctionality();
	}
	
	
	
	/**
	 * =============================================================================
	 * Method: testRegisterNavigation
	 * Description: Verify Register link navigates to Eligibility screen and header is correct.
	 * Groups/Tags: Login, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */


	
	@Test(enabled=false,description="Verify that clicking on the Register link navigates to the Eligibility screen and validates the header text.",groups= {"Login","Regression"})
	public void testRegisterNavigation() throws Exception{
	VerifyLoginScreen_HW   loginScreen_HW=	new VerifyLoginScreen_HW();
	
	loginScreen_HW.verifyRegistrationLinkAndBackButtonInEligibilityScreen();
	}
	
//	
//	
//	@Test
//	public void loginWithInvalidUserNameAndValidPassword() throws Exception{
//		VerifyLoginScreen_HW    loginScreen_HW=	new VerifyLoginScreen_HW();
//		loginScreen_HW.loginWithInvalidUsernameAndValidPassword();
//	}
//	
//	
//	
//	@Test
//	public void loginWithValidUserNameAndInvalidPassword() throws Exception{
//		VerifyLoginScreen_HW    loginScreen_HW=	new VerifyLoginScreen_HW();
//		loginScreen_HW.loginWithInvalidPasswordAndValidUsername();
//	}
	
	
}