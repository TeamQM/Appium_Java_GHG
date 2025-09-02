package com.framework.goodhealthgateway.android.screens.healthyweight.inboxscreen;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bouncycastle.asn1.x509.qualified.TypeOfBiometricData;
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
				int unreadMessagesCountGiven=0;;
				int conversationsCountGiven=0;
	
		//Extracting the data from Excel file 
	     String username=ExcelReader.excel("UserName", "LoginPage");
	     String password=ExcelReader.excel("Password", "LoginPage");

	    	//This Method is responsible for login operation
	   	 CommonHelper.loginWithValidUserNameAndPwdForHw(username, password)   ;
	   	     
	   	     
	        //This will click the inbox tab in home scrren
	    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "InboxTab")," Inbox Tab ");
	    
	    	
	    	//This will extract the count of unread messages from Inbox Tab Button
	        String inboxTabContentDescription=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "InboxTab"), "content-desc");
	   		int  unReadMessagesCount=		inboxTabContentDescription.startsWith("Inbox")?0:Character.getNumericValue(inboxTabContentDescription.charAt(0));
	   		ReportManager.logInfo("No of Unread Messages extracted from Inbox Tab Button  : - <b style=\"color:yellow;\">" +unReadMessagesCount+ "</b>");

	   		
	    	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
	    	WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW","Heading"));
	        mobileActions.verifyText("Inbox", el.getAttribute("content-desc"));
	        ReportManager.logInfo("Just Navigated to Inbox Screen");

	        
	      //This webelement will give the overview of the message [unread,conversations]
	      WebElement inboxOverview=  mobileActions.waitForVisible(   MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW", "InboxOverview"));
	      System.out.println("Messages Info In Inbox Tab "+		inboxOverview.getAttribute("content-desc"));
	 //Messages Info In Inbox Tab0 unread, 10 conversations

	      
	      //Extracting unread and conversations count from the content description
	      String msgInfo=inboxOverview.getAttribute("content-desc");
	
	      Matcher matcher = Pattern.compile("(\\d+)\\s*unread.*?(\\d+)\\s*conversations").matcher(msgInfo);

	      if(matcher.find()) {
	       unreadMessagesCountGiven=	 Integer.parseInt(matcher.group(1));
	       conversationsCountGiven=Integer.parseInt(matcher.group(2));
	      }
	      
	      
		ReportManager.logInfo("No of Unread Messages given in Inbox Screen : - <b style=\"color:yellow;\">" + unreadMessagesCountGiven+ "</b>");
		ReportManager.logInfo("No of Total Conversations given in Inbox Screen: - <b style=\"color:yellow;\">" + conversationsCountGiven+ "</b>");

		
		
		//validating the unread messages count
		Assert.assertTrue( unReadMessagesCount==unreadMessagesCountGiven);
		

		//This will extrat the conversations count and unread count from heading of Inbox screen
		int value=unreadMessagesCountGiven+conversationsCountGiven;
	 
		
		//This will caluclate the total conversation count based on the classname
		
	//	mobileActions.scrollToEnd("android.widget.TextView");
		//List<WebElement>   totalMessages=mobileActions.elements(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "TotalMessages"));
		int messagesCountAfterSwiping=	mobileActions.swipeUpAndCollectMessageCount(5, MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW", "TotalMessages"));
		int totalMessagesCount=	messagesCountAfterSwiping;
		
		System.out.println("No of Messages are "+totalMessagesCount);
		ReportManager.logInfo("No of conversations after validation:-  <b style=\"color:yellow;\">"+totalMessagesCount+"</b>");

	  

		
		//validating the conversations count
	    Assert.assertTrue(totalMessagesCount==value);
	    

	
	
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
   	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "InboxTab")," Inbox Tab ");
   	
   	
   	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
   	WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW","Heading"));
       mobileActions.verifyText("Inbox", el.getAttribute("content-desc"));
       ReportManager.logInfo("Just Navigated to Inbox Screen");
       
       
       //This will click on New Message[+] Icon in Inbox Screen 
       mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW", "NewMessageIcon"), "New Message Symbol");
       
       
       //This will check the heading text in New Message Scrreen
       String  headerText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "Heading"),"content-desc");
       mobileActions.verifyText(headerText, "New Message");
       ReportManager.logInfo("Just navigated to New Message Screen ");
	}
	
	
	
	  /**
     *    check the navigation of Back Arrow in New Message Subscreen 
     *
     *
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
		    	WebElement el1= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW","Heading"));
		        mobileActions.verifyText("Inbox", el1.getAttribute("content-desc"));
		        ReportManager.logInfo("Navigated to Inbox Screen Again.");
				
	}
	
	
	
	
	  /**
     * This Method is responsible for sending the message [Inbox section]
     * We need to enter message subject,message body and click on send Message Button
     * @throws Exception
     */
	
	public void createNewMessage() throws Exception
	{
	

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

	
	
	
    public void verifyMessageSubjectInInbox() throws Exception{




 String username=ExcelReader.excel("UserName", "LoginPage");

 String password=ExcelReader.excel("Password", "LoginPage");



//This Method is responsible for login operation

CommonHelper.loginWithValidUserNameAndPwdForHw(username, password);
 //This will click the inbox tab in home scrren

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "InboxTab")," Inbox Tab ");
//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly

WebElement el=mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW","Heading"));
mobileActions.verifyText("Inbox", el.getAttribute("content-desc"));

ReportManager.logInfo("Just Navigated to Inbox Screen");




//This will caluclate the total conversation count based on the classname

List<WebElement> totalMessages=mobileActions.elements(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW", "TotalMessages"));

System.out.println("No of Messages are "+totalMessages.size());

ReportManager.logInfo("No of conversations :-  <b style=\"color:yellow;\">"+totalMessages.size()+"</b>");


//Generating a random number within range

Random r=new Random();

int randomMessageBox= r.nextInt( totalMessages.size());

System.out.println("The random messsage number picked"+randomMessageBox);
//picking the content description of  random message

WebElement randomMessage=totalMessages.get(randomMessageBox);
String contentDescriptionOfRandomMessage=randomMessage.getAttribute("content-desc");


//clicking on randomMessage which will open message in next page

mobileActions.click(randomMessage);
ReportManager.logInfo("Clicking on  Message where message subject is :  <b style=\"color:yellow;\">" +contentDescriptionOfRandomMessage.split("\\n")[0] +"</b> ");


//Extracting the content-description of message subject after opening the particcular message
	String value=contentDescriptionOfRandomMessage.split("\\n")[0];
	String xpath = String.format("//android.view.View[contains(@content-desc,'%s')]", value);
        String contentDescriptionOfOpenedMessageSubject=mobileActions.getAttribute(MobileUtil.returnBy("xpath", xpath),"content-desc");


        System.out.println("checking the message subject in selected one"+contentDescriptionOfRandomMessage.split("\\n")[0]);
        System.out.println("checking the message subject in new page "+contentDescriptionOfOpenedMessageSubject.split("\\n")[0]);

        ReportManager.logInfo("Checking the  message subject  after opening  :  <b style=\"color:yellow;\">" +contentDescriptionOfOpenedMessageSubject.split("\\n")[0] +"</b> ");

       ReportManager.logInfo("Validating the particular Message subject in Message list is similar to message subject after opening it"); 
	Assert.assertTrue(contentDescriptionOfRandomMessage.split("\\n")[0].contains(contentDescriptionOfOpenedMessageSubject.split("\\n")[0]),"Not showing appropraite message subject upon opening message");


    }







    		
    
    
    
    
    
    public void checkingForReplyMessageFieldForAutomatedMessageInInboxScreen() throws Exception{
    	

   	 String username=ExcelReader.excel("UserName", "LoginPage");

   	 String password=ExcelReader.excel("Password", "LoginPage");



   	//This Method is responsible for login operation

   	CommonHelper.loginWithValidUserNameAndPwdForHw(username, password);
   	 //This will click the inbox tab in home scrren

   	  mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "InboxTab")," Inbox Tab ");
   	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly

   	WebElement el=mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW","Heading"));
   	mobileActions.verifyText("Inbox", el.getAttribute("content-desc"));

   	ReportManager.logInfo("Just Navigated to Inbox Screen");
  
   	
   	//  finding and   clicking on automated message
   	
   	ReportManager.logInfo("checking whether the automated message is present or not");

   
   	
   	
   	WebElement element1 = mobileActions.scrollUntilElementFound("Program Overview Session Completed!", true);
   
   	if(element1!=null) {
   		ReportManager.logInfo("Automated Message found successfully");
   	mobileActions.click(element1);
   	ReportManager.logInfo("Just clicked/opened on Automated Message");
   	
   	}
   	else {
   		System.out.println("Automated Message Not found");
   		ReportManager.logFail("Automated Message is not found ");
   		Assert.assertNotNull(element1,"Automated message not found");
   	}
   	
   	
//   	boolean isAutomatedMessageVisible = mobileActions.waitForVisible1(
//   	        MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "AutomatedMessage")
//   	);
//
//   	boolean flag = isAutomatedMessageVisible;  
//   	if(flag) {
//   		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "AutomatedMessage"), "Automated Message");
//   	}
//   	if (!isAutomatedMessageVisible) {
//   		ReportManager.logInfo("Swiping up to find automated message");
//   	    boolean b = mobileActions.swipeUpFindElementClick1(
//   	            3, MobileUtil.returnByBasedOnPageNameAndObjectName("InboxPage", "AutomatedMessage")
//   	    );
//   	    flag = b; 
//   	}
//
//   	if (!flag) {
//   	    //
//   	    Assert.assertTrue(flag, "Automated Message is not found");
//   	}
//
//   	
//   	
   	
   	
   	
   	
   	
   	
   	
	//checcking whether we can reply to the automated message or not 
	boolean canWeReply=	mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "ReplyMessageField"));
	
	
    	ReportManager.logInfo("we cant reply to automated message  <b style=\"color:yellow;\">"+!canWeReply+"</b>");
	
	Assert.assertFalse(canWeReply,"Displaying Reply Message form field for automated messages also");
	
	
    }
    
    

    
    
    
    
    
    
    
    public void checkingInboxWithEmptyMessages() throws Exception{
    	
    	
    	//Extracting the data from Excel file 
	     String username=  "qm1003@test.com";   //ExcelReader.excel("UserName", "LoginPage");
	     String password=ExcelReader.excel("Password", "LoginPage");
	     
	     
	     String expectedHeaderForEmptyMessagesInInbox=ExcelReader.excel("ExpectedHeaderForEmptyMessagesInInbox", "InboxPage");
	     String expectedTextForEmptyMessagesInInbox=ExcelReader.excel("ExpectedTextForEmptyMessagesInInbox", "InboxPage");

	     

	    	//This Method is responsible for login operation
	   	 CommonHelper.loginWithValidUserNameAndPwdForHw(username, password)   ;
	   	     
	   	     
	        //This will click the inbox tab in home scrren
	    	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "InboxTab")," Inbox Tab ");
	    
	 
	   		
	    	//This will verify  the heading text of Inbox tab to ensure that screen is redirected properly
	    	WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW","Heading"));
	        mobileActions.verifyText("Inbox", el.getAttribute("content-desc"));
	        ReportManager.logInfo("Just Navigated to Inbox Screen");

    	
	        
	        //Checking and Validating the header and text of Inbox Screen With Empty Messages
	        
	  String actualEmptyMessagesHeaderInInbox=      mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW", "EmptyMessagesHeader"),"content-desc");
    	
	  String actualEmptyMessagesTextInInbox=      mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("InboxScreen_HW", "EmptyMessagesText"),"content-desc");

	  
	  		ReportManager.logInfo("Checking and Validating the header and text of Inbox Screen With Empty Messages");
	  
	  
	  		mobileActions.verifyText(actualEmptyMessagesHeaderInInbox, expectedHeaderForEmptyMessagesInInbox);
	  		
	  		
	  		mobileActions.verifyText(actualEmptyMessagesTextInInbox, expectedTextForEmptyMessagesInInbox);
    	
    }
    
    
    
    
    
    







}
	



	
	
	

