package com.framework.goodhealthgateway.android.screens.healthyweight.inboxscreen;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.utilities.ReportManager;

public class VerifySendingReplyInNewMessageScreen {

	
	
	
	
	
	
	
	MobileActions mobileActions=new MobileActions();
	CommonHelper CommonHelper=new CommonHelper();


    
    
    
    public void replyToExistingMessage() throws Exception{
    	
    	



    	 String username=ExcelReader.excel("UserName", "LoginPage");

    	 String password=ExcelReader.excel("Password", "LoginPage");

    	 String messageToBeReply=ExcelReader.excel("MessageToBeReply", "InboxPage");

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

    	
    	//checcking whether we can reply to the message or not 
    	boolean canWeReply=	mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "ReplyMessageField"));
    	
    	//If randomly picked one message is a automated message then we cant reply to it .So we are failing the testcase	
    	Assert.assertTrue(canWeReply);
    	
    	
    	
    	//If there is a chance to reply then we need to give reply
    	
    //	String messageToBeReply="This is a reply message";
    	mobileActions.clickAndSendKeys(
    			
    			MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "ReplyMessageField"),
    			"Reply Message Field",
    			messageToBeReply);
    	
    		//click on reply button
    		mobileActions.click(
    				MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "ReplyMessageButton")    				
    				, "Reply Message Button");

    		
    	//	//android.view.View[@content-desc="sdfhgfhsdfj
    		//-35999 sec ago"]
    
    		//checking the replied message is visible 
    		boolean isMessageRepliedSuccessfully=		mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "RepliedMessage"));
    
    	Assert.assertTrue(isMessageRepliedSuccessfully);
   
    	//checking the recently replied message content with text
    		
    	String recentlyRepliedMessagetext=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox","RepliedMessage" ), "content-desc");
    
    	
//    	String recentlyRepliedMessageTextAfterTrimming=    recentlyRepliedMessagetext.split("-35999 sec ago")[0];
//    
//    	mobileActions.verifyText(messageToBeReply, recentlyRepliedMessageTextAfterTrimming)
//    	
    	
    	
    	Assert.assertTrue(recentlyRepliedMessagetext.contains(messageToBeReply));
    	
    	
    }
    
    
    
    
    
    

    
    public void replyAsHyperLinkToExistingMessage() throws Exception{
    	
    	



    	 String username=ExcelReader.excel("UserName", "LoginPage");

    	 String password=ExcelReader.excel("Password", "LoginPage");

    	 String messageToBeReply=ExcelReader.excel("MessageToBeReplyAsHyperLink", "InboxPage");

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

    	ReportManager.logInfo("No of conversations present on screen :-  <b style=\"color:yellow;\">"+totalMessages.size()+"</b>");


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

    	
    	//checcking whether we can reply to the message or not 
    	boolean canWeReply=	mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "ReplyMessageField"));
    	
    	//If randomly picked one message is a automated message then we cant reply to it .So we are failing the testcase	
    	Assert.assertTrue(canWeReply);
    	
    	
    	
    	//If there is a chance to reply then we need to give reply
    	
    //	String messageToBeReply="This is a reply message";
    	mobileActions.clickAndSendKeys(
    			
    			MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "ReplyMessageField"),
    			"Reply Message Field",
    			messageToBeReply);
    	
    		//click on reply button
    		mobileActions.click(
    				MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "ReplyMessageButton")    				
    				, "Reply Message Button");

    		
    
    		//checking the replied message is visible 
    		boolean isMessageRepliedSuccessfully=		mobileActions.waitForVisible1(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox", "RepliedMessage"));
    
    	Assert.assertTrue(isMessageRepliedSuccessfully);
   
    	//checking the recently replied message content with text
    		
  
    	
   String actualContentDescription= mobileActions.checkHyperLinkIsPresentOrNot( messageToBeReply.replaceAll("^(?:https?://)?(?:www\\.)?(.*)$", "$1"));
   
   
   Assert.assertTrue(messageToBeReply.contains(actualContentDescription));
   
   // WebElement hyperLink=	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("NewMessageScreenInInbox","RepliedMessage" ));
    
    
    	
    }
    
    
    
   
    
}
