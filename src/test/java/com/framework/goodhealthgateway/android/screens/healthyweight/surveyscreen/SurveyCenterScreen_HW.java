package com.framework.goodhealthgateway.android.screens.healthyweight.surveyscreen;

import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.utilities.ReportManager;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SurveyCenterScreen_HW {
    MobileActions mobileActions = new MobileActions();
    CommonHelper commonHelper = new CommonHelper();

    public void navigationToSurveyCenterScreen(String Username, String Password) throws Exception {

    	commonHelper.loginWithValidUserNameAndPwdForHw(Username,Password);

    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "SurveysTab")," Surveys Tab ");


    	WebElement el=  mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterTitle"));
    	mobileActions.verifyText(el.getAttribute("content-desc"),ExcelReader.excel("SurveyCenterTitle","SurveysPage"));
    	ReportManager.logInfo("Successfully Navigated to Survey Center Screen");

    }
    public void verifyWelcomeText() throws Exception {
    	WebElement welcomemsg=  mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterWelcomeMessage"));
    	mobileActions.verifyText(welcomemsg.getAttribute("content-desc"),ExcelReader.excel("SurveyCenterWelcomeMessage","SurveysPage"));

    	WebElement el=  mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterWelcomeText"));
    	mobileActions.verifyText(el.getAttribute("content-desc"),ExcelReader.excel("SurveyCenterWelcomeText","SurveysPage"));
    	ReportManager.logInfo("Verified Welcome Text");
    }

    public void verifyWelcomeTextBoxCloses() throws Exception {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen", "WelcomeTextCloseButton")," Welcome Text Close Button ");

        boolean welcomeMsgNotDisplayed = mobileActions.isNotDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterWelcomeMessage"),"Survey Center Welcome Message");
        Assert.assertTrue(welcomeMsgNotDisplayed);
    }

    public void verifyNoCompletedSurveysMessage() throws Exception {

    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen", "WelcomeTextCloseButton")," Welcome Text Close Button ");
    	WebElement noSurveysMsg= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","NoSurveysFoundTextInCompletedSurveysSection"));
    	mobileActions.verifyText(noSurveysMsg.getAttribute("content-desc"),ExcelReader.excel("NoSurveysMessage","SurveysPage"));
    	ReportManager.logInfo("Successfully verified no surveys found message when there are no Completed surveys in Survey Center Screen");

    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","ViewAllButtonForCompletedSurveys"), "View All Button For Completed Surveys");
    	WebElement noSurveysText= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","NoSurveysFoundTextInCompletedSurveysPage"));
    	mobileActions.verifyText(noSurveysText.getAttribute("content-desc"),ExcelReader.excel("NoSurveysText","SurveysPage"));
    	ReportManager.logInfo("Successfully verified no surveys found messages when there are no completed surveys in Completed Surveys Screen");
    	 
    }
    
    
    
    
    public int extractTheActiveSurveysCountFromTab() {

    	
    	// Extracting the content-desc attribute of surveys tab in HomeScreen
   String contentDescriptionOfActiveSurveysTab= 	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "SurveysTab"), "content-desc");
    
   
   // Extracting the active surveys count from surveys tab in Home Screen and convert in to integer
  String s=contentDescriptionOfActiveSurveysTab.startsWith("Surveys")?  "0" : contentDescriptionOfActiveSurveysTab.split("\\n")[0].trim();
  int activeSurveysCountDerivedFromSurevysTab=Integer.parseInt(s);  			
	ReportManager.logInfo("No of Active Surveys in Surveys Tab  : - <b style=\"color:yellow;\">" + activeSurveysCountDerivedFromSurevysTab+ "</b>");

 return activeSurveysCountDerivedFromSurevysTab;
  
  
    
    }
    
    
    
    
    public void navigateToActiveSurveysScreen() {
    	
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen", "ViewAllButtonForActiveSurveys"), "View All");
  
    
    String actualHeader=   mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("ActiveSurveysScreen", "ActiveSurveysHeader"),"content-desc");
    
    
    mobileActions.verifyText(actualHeader, "Active Surveys");
    ReportManager.logInfo("Just Navigated to Active Surveys Screen");
 
 
    }
    
 
    
    
    public void validateTheActiveSurveysCount(String Username,String Password) throws Exception{
    	
        commonHelper.loginWithValidUserNameAndPwdForHw(Username,Password);
                
        int activeSurveysCountFromSurveyTab= extractTheActiveSurveysCountFromTab();

        
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "SurveysTab")," Surveys Tab ");


 //This will verify the title text of Survey Center tab to ensure that screen is redirected properly
 WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterTitle"));
 mobileActions.verifyText(el.getAttribute("content-desc"),"Survey Center");
 ReportManager.logInfo("Successfully Navigated to Survey Center Screen");

 		verifyWelcomeText();
 		navigateToActiveSurveysScreen();
 		
 		
 		List<WebElement>  activeSurveysInSurveysCenterScreen=	mobileActions.scrollAndCollectByXpath(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","ActiveSurveysList"), "android.view.View");
   
 		
 		
		ReportManager.logInfo("No of Active Surveys Found in Survey Center Screen : - <b style=\"color:yellow;\">" + activeSurveysInSurveysCenterScreen.size()+ "</b>");

		
 		ReportManager.logInfo("Validating the Active Surveys Count ");

 		Assert.assertEquals(activeSurveysInSurveysCenterScreen.size(),activeSurveysCountFromSurveyTab);
		
 			
    
    
    }
    
    
    
   
    public void verifyNoActiveSurveysMessage() throws Exception {

        WebElement noSurveysMsg= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","NoSurveysFoundTextInActiveSurveysSection"));
        mobileActions.verifyText(noSurveysMsg.getAttribute("content-desc"),ExcelReader.excel("NoSurveysMessage","SurveysPage"));
        ReportManager.logInfo("Successfully verified no surveys found message when there are no Active surveys in Survey Center Screen");

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","ViewAllButtonForActiveSurveys"), "View All Button For Active Surveys");
        WebElement noSurveysText= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","NoSurveysFoundTextInActiveSurveysPage"));
        mobileActions.verifyText(noSurveysText.getAttribute("content-desc"),ExcelReader.excel("NoSurveysText","SurveysPage"));
        ReportManager.logInfo("Successfully verified no surveys found messages when there are no Active surveys in Active Surveys page");
    }

    public void verifyBackButtonInActiveSurveysScreen() throws Exception {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","ViewAllButtonForActiveSurveys"), "View All Button For Active Surveys");
        WebElement activeSurveysTitle= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","ActiveSurveysPageTitle"));
        mobileActions.verifyText(activeSurveysTitle.getAttribute("content-desc"),ExcelReader.excel("ActiveSurveysScreenTitle","SurveysPage"));
        ReportManager.logInfo("Successfully navigated to the Active Surveys Screen");

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","BackButtonInActiveSurveysPage"), "Back Button In Active Surveys Screen");
        WebElement surveyCenterTitle= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterTitle"));
        mobileActions.verifyText(surveyCenterTitle.getAttribute("content-desc"),ExcelReader.excel("SurveyCenterTitle","SurveysPage"));
        ReportManager.logInfo("Successfully navigated back to the Survey Center Screen");
    }
    public void verifyBackButtonInCompletedSurveysScreen() throws Exception {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","ViewAllButtonForCompletedSurveys"), "View All Button For Completed Surveys");
        WebElement completedSurveysTitle= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","CompletedSurveysPageTitle"));
        mobileActions.verifyText(completedSurveysTitle.getAttribute("content-desc"),ExcelReader.excel("CompletedSurveysScreenTitle","SurveysPage"));
        ReportManager.logInfo("Successfully navigated to the Completed Surveys Screen");

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","BackButtonInCompletedSurveysPage"), "Back Button In Completed Surveys Screen");
        WebElement surveyCenterTitle= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterTitle"));
        mobileActions.verifyText(surveyCenterTitle.getAttribute("content-desc"),ExcelReader.excel("SurveyCenterTitle","SurveysPage"));
        ReportManager.logInfo("Successfully navigated back to the Survey Center Screen");
    }


}
