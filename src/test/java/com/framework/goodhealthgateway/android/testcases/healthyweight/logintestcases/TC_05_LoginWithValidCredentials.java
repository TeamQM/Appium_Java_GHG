
package com.framework.goodhealthgateway.android.testcases.healthyweight.logintestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.healthyweight.loginscreen.VerifyLoginScreen_HW;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;

@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_05_LoginWithValidCredentials{
	
	
	
	@Test
	public void verifyUserWithValidCredentials() throws Exception {

	VerifyLoginScreen_HW loginScreen_Hw=	new VerifyLoginScreen_HW();
		
	loginScreen_Hw.loginInHW();
		
	}
	
	
	
	@Test
	public void verifyForgotPasswordLink() throws Exception{
		
		
		  		VerifyLoginScreen_HW    loginScreen_HW=					new VerifyLoginScreen_HW();
		loginScreen_HW.forgotPasswordInHw();	
		
	}
	
	
	@Test
	public void verifyLoginWithEmptyCredentials() throws Exception{
		VerifyLoginScreen_HW    loginScreen_HW=					new VerifyLoginScreen_HW();
		loginScreen_HW.loginWithEmptyCredentials();
	}
	
	
	@Test
	public void verifyAppVersionLinkFeaturesInLogin() throws Exception{
	VerifyLoginScreen_HW    loginScreen_HW=	new VerifyLoginScreen_HW();
	
	loginScreen_HW.verifyAppUpdatePopupFunctionality();
	}
	
	
	
	
	
	
	
	
	
	
}