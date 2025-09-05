package com.framework.goodhealthgateway.android.testcases.healthyweight.surveycentertestcases;

import com.framework.goodhealthgateway.android.screens.healthyweight.surveyscreen.SurveyCenterScreen_HW;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_04_05_06_VerifyActiveSurveys {
	@Test(description="Verify that when there are no active surveys available, the proper No Surveys Found message is displayed.",groups= {"ActiveSurveys", "Regression"})
	public void testNoSurveysFoundMsgsForActiveSurveys() throws Exception {
	    SurveyCenterScreen_HW surveyCenterScreenHw = new SurveyCenterScreen_HW();
	    surveyCenterScreenHw.navigationToSurveyCenterScreen(ExcelReader.excel("UserNameNoActiveSurvey", "LoginPage"),
	            ExcelReader.excel("Password", "LoginPage"));
	    surveyCenterScreenHw.verifyNoActiveSurveysMessage();
	}
	@Test(description="Verify navigation to Active Surveys page and that the back button works correctly.",groups= {"ActiveSurveys", "Regression"})
	public void testBackButtonInActiveSurveysPage() throws Exception {
	    SurveyCenterScreen_HW surveyCenterScreenHw = new SurveyCenterScreen_HW();
	    surveyCenterScreenHw.navigationToSurveyCenterScreen(ExcelReader.excel("UserName", "LoginPage"),
	            ExcelReader.excel("Password", "LoginPage"));
	    surveyCenterScreenHw.verifyBackButtonInActiveSurveysScreen();
	}
    
    @Test(description="Validate that the active survey count displayed on the home screen matches the number of surveys listed in the Active Surveys page.",groups= {"ActiveSurveys", "Regression"})
    public void testActiveSurveysCount() throws Exception{
    	  	
  SurveyCenterScreen_HW surveyCenterScreenHw=  	new SurveyCenterScreen_HW();
  
  			surveyCenterScreenHw.validateTheActiveSurveysCount(
  					ExcelReader.excel("UserName", "LoginPage"),
  	                ExcelReader.excel("Password", "LoginPage")
  					);
  
  
    }
    
    
    
//    @Test
//    public void testBackNavigationInActiveSurveysScreen() throws Exception{
//    	
//    	  SurveyCenterScreen_HW surveyCenterScreenHw=  	new SurveyCenterScreen_HW();
//    	  
//          surveyCenterScreenHw.navigationToSurveyCenterScreen(ExcelReader.excel("UserName", "LoginPage"),
//                  ExcelReader.excel("Password", "LoginPage"));
//          
//          surveyCenterScreenHw.navigateToActiveSurveysScreen();
//          
//          surveyCenterScreenHw.testBackButtonInActiveSurveysScreen();
//          
//          surveyCenterScreenHw.verifyWelcomeText();
//          
//          
//          
//
//    	
//    	
//    }
    
    
    
    
}
