
package com.framework.goodhealthgateway.android.screens.healthyweight.loginscreen;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.utilities.ReportManager;

public class VerifyLoginScreen_HW{
	MobileActions mobileActions = new MobileActions();
	CommonHelper CommonHelper = new CommonHelper();
	

	public  void loginInHW() throws Exception {
		
		
		CommonHelper.loginWithValidUserNameAndPwdForHw(
				ExcelReader.excel("UserName", "LoginPage"),
			//"qm1003@test.com"	,
				ExcelReader.excel("Password", "LoginPage")
				);
		
	}
	
	
	
	
	public void loginWithEmptyCredentials() throws Exception{
		//CommonHelper.loginWithEmptyCredentials();
		
		
		
		String expectedErrorTextForInvalidUserName=ExcelReader.excel("ErrorTextForInvalidUserName", "LoginPage");
		String expectedErrorTextForInvalidPassword=ExcelReader.excel("ErrorTextForInvalidPassword", "LoginPage");

		
		
        mobileActions.smartClickWithVerification(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"), "Ok Button in Warning Popup", 5);

		
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "LoginButton"), "Log in");
        
        
  boolean isUsernameFieldErrorVisible=  	mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "UsernameError"));
    	
  boolean isPasswordFieldErrorVisible=  	mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "PasswordError"));

  			boolean isErrorMessagesDisplayed=isPasswordFieldErrorVisible && isUsernameFieldErrorVisible;
  			
  	if(	isErrorMessagesDisplayed) {	
  	    	ReportManager.logPass("Error Messages are displayed for both form fields"); }
  	else {
  	    	ReportManager.logFail("Error Messages are not displayed for both form fields")
  	    	;	}
  
    Assert.assertTrue( isErrorMessagesDisplayed, "Not displayed the error messages even after clicking login without entering credentials");

	
    
    
    
  String actualErrorTextForInvalidUserName=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "UsernameError"),"content-desc");
    
  String actualErrorTextForInvalidPassword=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "PasswordError"),"content-desc");

  mobileActions.verifyText(actualErrorTextForInvalidUserName,expectedErrorTextForInvalidUserName);
  
 mobileActions.verifyText(actualErrorTextForInvalidPassword, expectedErrorTextForInvalidPassword);
  
    
	
	}
	
	
	
	public void forgotPasswordInHw() throws Exception{
		
	//	CommonHelper.checkingForgotPasswordLinkInLoginPage();
		
//
//        mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
//
//        mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
//      
		
		
        mobileActions.smartClickWithVerification(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"), "Ok Button in Warning Popup", 5);

    	mobileActions.click(
    			MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "ForgotPasswordLink"),
    			"Forgot Password Link");
    	
    	
   WebElement header= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ForgotPasswordScreeen_HW", "Header"));
			
    	mobileActions.verifyText(
    			header.getAttribute("content-desc")
    			, "Forgot\nPassword");
   
    	
    	
    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ForgotPasswordScreeen_HW", "BackArrow"), "Back Arrow in Forgot Passowrd Screen");
    	
    boolean isVisible=	mobileActions.waitForVisible1(
    			MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "ForgotPasswordLink")
    			);
    
    
    Assert.assertTrue(isVisible, "Screen is not redirected to login even after clicking back arrow also");
		
		
	}
	
	
	
	
	public void verifyRegistrationLinkAndBackButtonInEligibilityScreen() {
		
		//This will handle popup.It will clicks [5] ok in warning popup until it closes 
		mobileActions.smartClickWithVerification(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"), "Ok Button in Warning Popup", 5);

		
			// This will clicks registration link in login screen
    	mobileActions.click(
    			MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "RegistrationLink"),
    			"Register Link");
    	
    	// This will extract the content description of header in eligibility screen and stored in variable
    	String contentDescriptionOfHeaderInEligibilityScreen=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EligibilityScreen_HW", "Header"), "content-desc");
		
    	//condition for checking whether navigated to eligibility screen or not
    	boolean  isNavigated=contentDescriptionOfHeaderInEligibilityScreen.startsWith("Eligibility");
    	
    	ReportManager.logInfo("Just Navigated to Eligibility Screen:"+isNavigated);
    	
    	//Validating whether navigated to eligibility screen or not
    	Assert.assertTrue(isNavigated, "Not Navigated to Eligibility Screen even after clicking the Registration Link which is present in Login Screen");
    	
    	//This will click on Back arrow symbol in Eligibility Screen
    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EligibilityScreen_HW","BackArrow"), "Back Arrow ");
    	
    	// checcking the Login Header in Login screen return true if navigated to login screen otherwise false
    	boolean isNavigatedToLoginScreen=		mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "LoginHeader"));
    	
    	
    	ReportManager.logInfo("Navigated to Login Screen: "+isNavigatedToLoginScreen);
    	
    	//validating whether navigated to Login Screen or not
    	Assert.assertTrue(isNavigatedToLoginScreen,"Not Navigated to Login Screen even after clicking the Back Arrow in Eligibility Screen");
    	
    	
    	
		
	}
	
	
	public void verifyAppUpdatePopupFunctionality() throws Exception{
		
//		CommonHelper.checkAppUpdatePopupUponClicking(
//				ExcelReader.excel("AppUpdatePopupHeader", "LoginPage")
//				);
		String appUpdatePopupHeaderText=	ExcelReader.excel("AppUpdatePopupHeader", "LoginPage");
        mobileActions.smartClickWithVerification(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"), "Ok Button in Warning Popup", 5);

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "AppVersionLink"), "App Version Link");
    	Thread.sleep(1000);
    	ReportManager.logInfo("App Update Popup is displayed ");
    	
    String actualHeaderOfPopup=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "AppUpdatePopupHeader"),"content-desc");
       
    mobileActions.verifyText(actualHeaderOfPopup,
    		
    		appUpdatePopupHeaderText
    		
    		);
    mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "AppUpdate"),"Not Now");
       
     boolean isAppUpdatePopupDisappeared=   mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "AppUpdate"));
    
     		Assert.assertFalse(isAppUpdatePopupDisappeared,"App update popup is not disappeared even after clicking Not Now button");     
	}
	
	
	
	
	
	
	public void loginWithInvalidUsernameAndValidPassword() throws Exception{
		
		String inValidUserName=ExcelReader.excel("InvalidUserNameForHW","LoginPage");
		String password=ExcelReader.excel("Password", "LoginPage");
		String expectedErrorMessage=ExcelReader.excel("LoginErrorMessage", "LoginPage");
		
//	     mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
//
//	        mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
//	      
        mobileActions.smartClickWithVerification(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"), "Ok Button in Warning Popup", 5);

	    
	        mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "UserName"), "username",inValidUserName);
	     
	        
	        
	        mobileActions.hideKeyboard();
	        Thread.sleep(1000);

	        mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Password"),"password", password);
	       mobileActions.hideKeyboard();
	        Thread.sleep(2000);
	        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "LoginButton"), "Log in");
	        mobileActions.smartClickWithVerification(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"), "Ok Button in Warning Popup", 5);

	        
		
	        String actualErrorMessage=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW","LoginErrorMessage"), "content-desc");
	
	        	
	        mobileActions.verifyText(actualErrorMessage, expectedErrorMessage);
	
	}
	
	
	
	
	
	

	public void loginWithInvalidPasswordAndValidUsername() throws Exception{
		
		String userName=ExcelReader.excel("UserName","LoginPage");
		String inValidPassword=ExcelReader.excel("InValidPasswordForHW", "LoginPage");
		String expectedErrorMessage=ExcelReader.excel("LoginErrorMessage", "LoginPage");
		
//	     mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
//
//	        mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
//	      
        mobileActions.smartClickWithVerification(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"), "Ok Button in Warning Popup", 5);

	    
	        mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "UserName"), "username",userName);
	     
	        
	        
	        mobileActions.hideKeyboard();
	        Thread.sleep(1000);

	        mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Password"),"password", inValidPassword);
	        mobileActions.hideKeyboard();
	        Thread.sleep(2000);
	        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "LoginButton"), "Log in");
	      
	        mobileActions.smartClickWithVerification(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"), "Ok Button in Warning Popup", 5);

		
	        String actualErrorMessage=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW","LoginErrorMessage"), "content-desc");
	
	        	
	        mobileActions.verifyText(actualErrorMessage, expectedErrorMessage);
	
	}
	
	
	
	
}