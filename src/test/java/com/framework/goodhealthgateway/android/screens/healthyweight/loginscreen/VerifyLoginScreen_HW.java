
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
				ExcelReader.excel("Password", "LoginPage")
				);
		
	}
	
	
	
	
	public void loginWithEmptyCredentials() throws Exception{
		//CommonHelper.loginWithEmptyCredentials();
		
		
		
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
	}
	
	
	
	public void forgotPasswordInHw() throws Exception{
		
	//	CommonHelper.checkingForgotPasswordLinkInLoginPage();
		

        mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");

        mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
      
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
	
	
	public void verifyAppUpdatePopupFunctionality() throws Exception{
		
//		CommonHelper.checkAppUpdatePopupUponClicking(
//				ExcelReader.excel("AppUpdatePopupHeader", "LoginPage")
//				);
		String appUpdatePopupHeaderText=	ExcelReader.excel("AppUpdatePopupHeader", "LoginPage");
		
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
	
	
	
	
}