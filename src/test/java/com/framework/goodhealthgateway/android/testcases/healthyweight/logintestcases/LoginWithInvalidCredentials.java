package com.framework.goodhealthgateway.android.testcases.healthyweight.logintestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.healthyweight.loginscreen.VerifyLoginScreen_HW;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;

@Listeners({SuiteEvent.class,MobileEvent.class})
public class LoginWithInvalidCredentials {

	
	
	/**
	 * =============================================================================
	 * Method: testLoginWithInvalidUsername
	 * Description: Validate error when logging in with invalid username and valid password.
	 * Groups/Tags: Login, Negative, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */


	@Test(enabled=false,description="Validate error message when logging in with invalid username and valid password.",groups= {"Login","Negative","Regression"})
	public void testLoginWithInvalidUsername() throws Exception{
		VerifyLoginScreen_HW    loginScreen_HW=	new VerifyLoginScreen_HW();
		loginScreen_HW.loginWithInvalidUsernameAndValidPassword();
	}
	
	
	
	
	/**
	 * =============================================================================
	 * Method: testLoginWithInvalidPassword
	 * Description: Validate error when logging in with valid username and invalid password.
	 * Groups/Tags: Login, Negative, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */


	@Test(description="Validate error message when logging in with valid username and invalid password.",groups= {"Login","Negative","Regression"})
	public void testLoginWithInvalidPassword() throws Exception{
		VerifyLoginScreen_HW    loginScreen_HW=	new VerifyLoginScreen_HW();
		loginScreen_HW.loginWithInvalidPasswordAndValidUsername();
	}
	
  
  
  
  
  
  
}
