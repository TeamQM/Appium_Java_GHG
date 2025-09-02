package com.framework.goodhealthgateway.android.screens;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.model.Report;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
//import com.framework.android.utils.MobileActions;
import com.framework.goodhealthgateway.utilities.ReportManager;
//import com.framework.utilities.Constants;
//import com.framework.utilities.MobileUtil;
//import com.framework.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.utilities.Constants;
import io.appium.java_client.android.Activity;

public class CommonHelper {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to login on GHG application
     *
     * @param UserName
     * @param Password
     * @throws InterruptedException
     * @throws IOException
     */

    public void loginWithValidUserNameAndPwd(String UserName, String Password)
            throws InterruptedException, IOException {
        ReportManager.logInfo("Test started login");
        Thread.sleep(4000);

//        mobileActions.acceptAlert("Ok Button for warning");



        if (Constants.platformName.equalsIgnoreCase("android")) {
            //mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen","Okbutton"),"Ok Button for warning");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "UserName"), "Username");
        }
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "UserName"), UserName);
        mobileActions.hideKeyboard();
        Thread.sleep(1000);
        if (Constants.platformName.equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Password"), "Password");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "EyeIcon"), "EyeIcon");
        }
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Password"), Password);
        mobileActions.hideKeyboard();
        Thread.sleep(2000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Submit"), "Submit");
        Thread.sleep(2000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","Closebutton"),"Close button");
    }

    
    
    /**
     * This method is responsible for performing login in GoodHealth Gateway Application
     * @param UserName
     * @param Password
     * @throws InterruptedException
     * @throws IOException
     */
    public void loginWithValidUserNameAndPwdForHw(String UserName, String Password) throws InterruptedException, IOException {
        ReportManager.logInfo("Test started login");
       // Thread.sleep(4000);
    
    /**
     *  mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");

        mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
         
     */
        mobileActions.smartClickWithVerification(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"), "Ok Button in Warning Popup", 5);
    
        mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "UserName"), "username",UserName);
     
        
        
     //   mobileActions.hideKeyboard(); //comment it if u running this on emulator
        Thread.sleep(1000);

        mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Password"),"password", Password);
       // mobileActions.hideKeyboard(); //comment it if u running this on emulator
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "LoginButton"), "Log in");
      
        boolean isPageLoaded = mobileActions.waitForPageToLoadViaPageSource();
     Thread.sleep(3000);
     if(isPageLoaded) {
     mobileActions.dismissPopupUsingEscapeButton();
     }
     
    		  //}
        
        mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "AppUpdate"),"Update Popup");
        
    WebElement element=    mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "NameOfTheUser"));
        
  String s= element.getAttribute("content-desc");
    System.out.println(  s);
        
     
      
      
      Assert.assertTrue(s.length()!=0);
    }
    
    
    
//    
//    public void checkingForgotPasswordLinkInLoginPage() throws Exception{
//    	
//
//        //mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
//
//      //  mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "Warning"),"Warning");
//      
//    	mobileActions.click(
//    			MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "ForgotPasswordLink"),
//    			"Forgot Password Link");
//    	
//    	
//   WebElement header= mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ForgotPasswordScreeen_HW", "Header"));
//			
//    	mobileActions.verifyText(
//    			header.getAttribute("content-desc")
//    			, "Forgot\nPassword");
//   
//    	
//    	
//    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ForgotPasswordScreeen_HW", "BackArrow"), "Back Arrow in Forgot Passowrd Screen");
//    	
//    boolean isVisible=	mobileActions.waitForVisible1(
//    			MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "ForgotPasswordLink")
//    			);
//    
//    
//    Assert.assertTrue(isVisible, "Screen is not redirected to login even after clicking back arrow also");
//    	
//    }
    
    
    
//    
//    
//    public void loginWithEmptyCredentials() throws Exception{
//    	
//    	
//        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "LoginButton"), "Log in");
//        
//        
//  boolean isUsernameFieldErrorVisible=  	mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "UsernameError"));
//    	
//  boolean isPasswordFieldErrorVisible=  	mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "PasswordError"));
//
//  			boolean isErrorMessagesDisplayed=isPasswordFieldErrorVisible && isUsernameFieldErrorVisible;
//  			
//  	if(	isErrorMessagesDisplayed) {	
//  	    	ReportManager.logPass("Error Messages are displayed for both form fields"); }
//  	else {
//  	    	ReportManager.logFail("Error Messages are not displayed for both form fields")
//  	    	;	}
//  
//    Assert.assertTrue( isErrorMessagesDisplayed, "Not displayed the error messages even after clicking login without entering credentials");
//    }
//    
//    
    
    
    
    
    
//    public void checkAppUpdatePopupUponClicking(String appUpdatePopupHeaderText) throws Exception{
//    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "AppVersionLink"), "App Version Link");
//    	Thread.sleep(1000);
//    	ReportManager.logInfo("App Update Popup is displayed ");
//    	
//    String actualHeaderOfPopup=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "AppUpdatePopupHeader"),"content-desc");
//       
//    mobileActions.verifyText(actualHeaderOfPopup, appUpdatePopupHeaderText);
//    mobileActions.clickIfVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "AppUpdate"),"Not Now");
//       
//     boolean isAppUpdatePopupDisappeared=   mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen_HW", "AppUpdate"));
//    
//     		Assert.assertFalse(isAppUpdatePopupDisappeared,"App update popup is not disappeared even after clicking Not Now button");     
//    }
//    
//    
    
    
//    
//    
//    
//    public void checkingInboxTabAndItsFeatures(String username,String password) throws Exception {
//    	
//
//        
//    	//This Method is responsible for login operation
//   	     loginWithValidUserNameAndPwdForHw(username, password);      
//   	     
//   	     
//        //This will click the inbox tab in home scrren
//    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomePage", "InboxTab")," Inbox Tab ");
//    
//    	
//    	//This will extract the count of unread messages from Inbox Tab Button
//        String inboxTabContentDescription=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomePage", "InboxTab"), "content-desc");
//   		int  unReadMessagesCount=		inboxTabContentDescription.startsWith("Inbox")?0:Character.getNumericValue(inboxTabContentDescription.charAt(0));
//   		ReportManager.logInfo("No of Unread Messages extracted from Inbox Tab Button  : - <b style=\"color:yellow;\">" +unReadMessagesCount+ "</b>");
//
//   		
//    	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
//    	WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage","Heading"));
//        mobileActions.verifyText("Inbox", el.getAttribute("content-desc"));
//        ReportManager.logInfo("Just Navigated to Inbox Screen");
//
//        
//      //This webelement will give the overview of the message [unread,conversations]
//      WebElement inboxOverview=  mobileActions.waitForVisible(   MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "InboxOverview"));
//      System.out.println("Messages Info In Inbox Tab"+		inboxOverview.getAttribute("content-desc"));
// 
//      
//      //Extracting unread and conversations count from the content description
//      String[] msgInfo=inboxOverview.getAttribute("content-desc").split(",");
//      System.out.println(msgInfo[0].trim().charAt(0));
//      System.out.println(msgInfo[1].trim().charAt(0));
// 
// 
//	ReportManager.logInfo("No of Unread Messages given in Inbox Screen : - <b style=\"color:yellow;\">" + msgInfo[0].trim().charAt(0)+ "</b>");
//	ReportManager.logInfo("No of Total Conversations given in Inbox Screen: - <b style=\"color:yellow;\">" + msgInfo[1].trim().charAt(0)+ "</b>");
//
//	
//	
//	//validating the unread messages count
//	Assert.assertTrue( unReadMessagesCount==Character.getNumericValue(msgInfo[0].trim().charAt(0)));
//	
//
//	//This will extrat the conversations count from heading of Inbox screen
//	int value=Character.getNumericValue(msgInfo[1].trim().charAt(0));
// 
//	
//	//This will caluclate the total conversation count based on the classname
//	List<WebElement>   totalMessages=			mobileActions.elements(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "TotalMessages"));
//    System.out.println("No of Messages are "+totalMessages.size());
//	ReportManager.logInfo("No of conversations after validation:-  <b style=\"color:yellow;\">"+totalMessages.size()+"</b>");
//
//  
//
//	
//	//validating the conversations count
//    Assert.assertTrue(totalMessages.size()==value);
//    
//    }
//    
//    
    
    
//    /**
//     * This method is used to check whether New Message Icon Button in `Inbox Screen`
//     * and      [Just Navigation Checking with help of content-desc attribute]
//     * @throws Exception
//     */
//    public void checkNavigationToNewMessageInInbox(String username,String password) throws Exception{
//    	
//    	
//    	  
//    	//This Method is responsible for login operation
//   	     loginWithValidUserNameAndPwdForHw(username, password);      
//   	     
//   	     
//        //This will click the inbox tab in home scrren
//    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomePage", "InboxTab")," Inbox Tab ");
//    	
//    	
//    	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
//    	WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage","Heading"));
//        mobileActions.verifyText("Inbox", el.getAttribute("content-desc"));
//        ReportManager.logInfo("Just Navigated to Inbox Screen");
//        
//        
//        //This will click on New Message[+] Icon in Inbox Screen 
//        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "NewMessageIcon"), "New Message Symbol");
//        
//        
//        //This will check the heading text in New Message Scrreen
//        String  headerText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "Heading"),"content-desc");
//        mobileActions.verifyText(headerText, "New Message");
//        ReportManager.logInfo("Just navigated to New Message Screen ");
//        
        
        
//        
//        //This will navigate to Inbox Screen Again [Clicking on Back Arrow]
//        
//        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "BackArrow"), "Back Arrow Symbol");
//        
//        
//        
//        //Checking whether it is navigated to Inbox Screen or not
//    	
//    	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
//    	WebElement el1= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage","Heading"));
//        mobileActions.verifyText("Inbox", el1.getAttribute("content-desc"));
//        ReportManager.logInfo("Navigated to Inbox Screen Again.");
        
        
        
    
  //  }
    
    /**
     *    check the navigation of Back Arrow in New Message Subscreen 
     * @param username
     * @param password
     * @throws Exception
     */
    
//    public void checkBackNavigationToInboxFromNewMessageScreen(String username,String password) throws Exception {
//
//    	
//    	checkNavigationToNewMessageInInbox(username, password);
//    	
//    	
//    	  
//        //This will navigate to Inbox Screen Again [Clicking on Back Arrow]
//        
//        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "BackArrow"), "Back Arrow Symbol");
//        
//        
//        
//        //Checking whether it is navigated to Inbox Screen or not
//    	
//    	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
//    	WebElement el1= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage","Heading"));
//        mobileActions.verifyText("Inbox", el1.getAttribute("content-desc"));
//        ReportManager.logInfo("Navigated to Inbox Screen Again.");
//    	
//    }
//    
    
    
//    
//    /**
//     * This Method is responsible for sending the message [Inbox section]
//     * We need to enter message subject,message body and click on send Message Button
//     * @throws Exception
//     */
//    public void sendMessage(String username,String password,String messageSubject,String messageBody,String popupText) throws Exception{
//    	
//    	checkNavigationToNewMessageInInbox(username, password);
//    	
//    	
//    	mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "MessageSubject"),"Message Subject Field", messageSubject);
//    	
//    	mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "MessageBody"),"Message Body Field",messageBody);
//
//    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "SendMessageButton"), "Send Message Button");
//    	
//    	String contentDescriptionOfPopup=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "SuccessMessagePopupText"), "content-desc");
//    	
//    	
//    	mobileActions.verifyText(popupText, contentDescriptionOfPopup);
//    	
//    	
//    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "AcceptOk"), "Ok Button ");
//    	
//    	
//    }
//    
    
    
    
    /**
     * This method is use to navigate to menu page
     *
     * @throws InterruptedException
     * @throws IOException
     */
    public void menuPageFlow() throws InterruptedException, IOException {
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        Thread.sleep(5000);
        String daText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            daText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DiabetesActivityText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            daText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DiabetesActivityText"), "name");
        }
        String expectedDaText = "Diabetes Activity";
        mobileActions.verifyText(daText, expectedDaText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "hamburgerButton"),
                "hamburgerButton");
       // Thread.sleep(1000);
        String menuText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            menuText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            menuText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "name");
        }
        String ExpectedMenuText = "Menu";
        mobileActions.verifyText(menuText, ExpectedMenuText);
    }

    public void documentFlow() throws InterruptedException {
Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        Thread.sleep(2000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DocumentIcon"),
                "DocumentIcon");

    }

    public void downloadDocumentPage() {
        MobileActions mobileActions = new MobileActions();

        String DownDocPage = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            DownDocPage = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            DownDocPage = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "name");
        }
        String expectedDaText = "Download Documents";
        mobileActions.verifyText(DownDocPage, expectedDaText);
    }

    public void swichApp(String appPackage,String appActivity) {
        Activity activity = new Activity(appPackage, appActivity);
        //DriverFactory.getInstance().getMobileDriver().startActivity(activity);
        ReportManager.logInfo("Successfully Switched To Message App");

    }
}
