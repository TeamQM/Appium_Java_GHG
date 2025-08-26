package com.framework.goodhealthgateway.android.screens.healthyweight.inboxscreen;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.utilities.ReportManager;

public class VerifyInboxScreen {

	
	MobileActions mobileActions = new MobileActions();
	CommonHelper CommonHelper = new CommonHelper();

	
	
	
	
	public void checkingInbox() throws Exception {
		
		//CommonHelper.checkingInboxTabAndItsFeatures(
				
	
		
	     String username=ExcelReader.excel("UserName", "LoginPage");

	    		 String password=ExcelReader.excel("Password", "LoginPage");

	    	//This Method is responsible for login operation
	   	 CommonHelper.loginWithValidUserNameAndPwdForHw(username, password)   ;
	   	     
	   	     
	        //This will click the inbox tab in home scrren
	    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomePage", "InboxTab")," Inbox Tab ");
	    
	    	
	    	//This will extract the count of unread messages from Inbox Tab Button
	        String inboxTabContentDescription=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomePage", "InboxTab"), "content-desc");
	   		int  unReadMessagesCount=		inboxTabContentDescription.startsWith("Inbox")?0:Character.getNumericValue(inboxTabContentDescription.charAt(0));
	   		ReportManager.logInfo("No of Unread Messages extracted from Inbox Tab Button  : - <b style=\"color:yellow;\">" +unReadMessagesCount+ "</b>");

	   		
	    	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
	    	WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage","Heading"));
	        mobileActions.verifyText("Inbox", el.getAttribute("content-desc"));
	        ReportManager.logInfo("Just Navigated to Inbox Screen");

	        
	      //This webelement will give the overview of the message [unread,conversations]
	      WebElement inboxOverview=  mobileActions.waitForVisible(   MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "InboxOverview"));
	      System.out.println("Messages Info In Inbox Tab"+		inboxOverview.getAttribute("content-desc"));
	 
	      
	      //Extracting unread and conversations count from the content description
	      String[] msgInfo=inboxOverview.getAttribute("content-desc").split(",");
	      System.out.println(msgInfo[0].trim().charAt(0));
	      System.out.println(msgInfo[1].trim().charAt(0));
	 
	 
		ReportManager.logInfo("No of Unread Messages given in Inbox Screen : - <b style=\"color:yellow;\">" + msgInfo[0].trim().charAt(0)+ "</b>");
		ReportManager.logInfo("No of Total Conversations given in Inbox Screen: - <b style=\"color:yellow;\">" + msgInfo[1].trim().charAt(0)+ "</b>");

		
		
		//validating the unread messages count
		Assert.assertTrue( unReadMessagesCount==Character.getNumericValue(msgInfo[0].trim().charAt(0)));
		

		//This will extrat the conversations count and unread count from heading of Inbox screen
		int value=Character.getNumericValue(msgInfo[1].trim().charAt(0))+Character.getNumericValue(msgInfo[0].trim().charAt(0));
	 
		
		//This will caluclate the total conversation count based on the classname
		List<WebElement>   totalMessages=			mobileActions.elements(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "TotalMessages"));
	    System.out.println("No of Messages are "+totalMessages.size());
		ReportManager.logInfo("No of conversations after validation:-  <b style=\"color:yellow;\">"+totalMessages.size()+"</b>");

	  

		
		//validating the conversations count
	    Assert.assertTrue(totalMessages.size()==value);
	    

	
	
	}
	
	
	 
    /**
     * This method is used to check whether New Message Icon Button in `Inbox Screen`
     * and      [Just Navigation Checking with help of content-desc attribute]
     * @throws Exception
     */	
	
	public void checkNewMessageButton() throws Exception{
		
			String username=	ExcelReader.excel("UserName", "LoginPage");
				String password=ExcelReader.excel("Password", "LoginPage");
				
		
		
		
		//This Method is responsible for login operation
  	     CommonHelper.loginWithValidUserNameAndPwdForHw(username, password);
  	     
       //This will click the inbox tab in home scrren
   	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomePage", "InboxTab")," Inbox Tab ");
   	
   	
   	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
   	WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage","Heading"));
       mobileActions.verifyText("Inbox", el.getAttribute("content-desc"));
       ReportManager.logInfo("Just Navigated to Inbox Screen");
       
       
       //This will click on New Message[+] Icon in Inbox Screen 
       mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "NewMessageIcon"), "New Message Symbol");
       
       
       //This will check the heading text in New Message Scrreen
       String  headerText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "Heading"),"content-desc");
       mobileActions.verifyText(headerText, "New Message");
       ReportManager.logInfo("Just navigated to New Message Screen ");
	}
	
	
	
	  /**
     *    check the navigation of Back Arrow in New Message Subscreen 
     * @param username
     * @param password
     * @throws Exception
     */
	public void checkBackButtonInNewMessage() throws Exception{
		
		//CommonHelper.checkBackNavigationToInboxFromNewMessageScreen(
//		String username=		ExcelReader.excel("UserName", "LoginPage");
//		String password=		ExcelReader.excel("Password", "LoginPage");
//

		 //   	checkNavigationToNewMessageInInbox(username, password);
		    	
		    checkNewMessageButton();	
		    	  
		        //This will navigate to Inbox Screen Again [Clicking on Back Arrow]
		        
		        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "BackArrow"), "Back Arrow Symbol");
		        
		        
		        
		        //Checking whether it is navigated to Inbox Screen or not
		    	
		    	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
		    	WebElement el1= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage","Heading"));
		        mobileActions.verifyText("Inbox", el1.getAttribute("content-desc"));
		        ReportManager.logInfo("Navigated to Inbox Screen Again.");
				
	}
	
	
	
	
	  /**
     * This Method is responsible for sending the message [Inbox section]
     * We need to enter message subject,message body and click on send Message Button
     * @throws Exception
     */
	
	public void createNewMessage() throws Exception{
		
	//	CommonHelper.sendMessage(
				
				//ExcelReader.excel("UserName", "LoginPage"),ExcelReader.excel("Password", "LoginPage")


String messageSubject=ExcelReader.excel("SufficientMessageSubjectText", "InboxPage");
String messageBody=ExcelReader.excel("SufficientMessageBodyText", "InboxPage");
String popupText=ExcelReader.excel("SuccessMessagePopupTextInNewMessageScreen", "InboxPage");


checkNewMessageButton();

//checkNavigationToNewMessageInInbox(username, password);
		    	
		    	
		    	mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "MessageSubject"),"Message Subject Field", messageSubject);
		    	
		    	mobileActions.clickAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "MessageBody"),"Message Body Field",messageBody);

		    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "SendMessageButton"), "Send Message Button");
		    	
		    	String contentDescriptionOfPopup=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "SuccessMessagePopupText"), "content-desc");
		    	
		    	
		    	mobileActions.verifyText(popupText, contentDescriptionOfPopup);
		    	
		    	
		    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "AcceptOk"), "Ok Button ");
		    	

				
				
	}
}
