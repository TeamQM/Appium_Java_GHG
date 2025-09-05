package com.framework.goodhealthgateway.android.testcases.healthyweight.inboxtestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.healthyweight.inboxscreen.VerifyInboxScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_02_03_VerifyInboxPage_VerifyUnReadMessages {
  
	
	
	/**
	 * =============================================================================
	 * Method: testInboxValidation
	 * Description: Verify unread messages count, conversations, and header text in Inbox.
	 * Groups/Tags: Inbox, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */


	@Test(description="Verify unread messages count, conversations count, and header text in Inbox tab.",groups= {"Inbox","Regression"})
  public void testInboxValidation() throws Exception {
  
VerifyInboxScreen verifyInboxScreen=new VerifyInboxScreen();
verifyInboxScreen.checkingInbox();

  
  }
	
	
	@Test(enabled=false,description="Verify that user can navigate from Inbox to New Message screen using the '+' icon.",groups= {"Messaging","Regression"})
	public void testNewMessageButtonNavigation() throws Exception{
		
	VerifyInboxScreen inboxScreen=	new VerifyInboxScreen();
	inboxScreen.checkNewMessageButton();
	
	}
	
	/**
	 * =============================================================================
	 * Method: testComposeNewMessage
	 * Description: Verify user can compose and send a new message successfully.
	 * Groups/Tags: Messaging, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */


	@Test(description="Validate that user can compose and send a new message successfully.",groups={"Messaging", "Regression"})
	public void testComposeNewMessage() throws Exception{
		
		VerifyInboxScreen inboxScreen=	new VerifyInboxScreen();
		inboxScreen.createNewMessage();
	}
	
	
	/**
	 * =============================================================================
	 * Method: testNavigateBackFromNewMessage
	 * Description: Verify navigating back to Inbox after opening New Message via + symbol.
	 * Groups/Tags: Messaging, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */

	@Test(description="Verify that user can navigate back to the Inbox using the back arrow in New Message Screen.",groups= {"Messaging","Regression"})
	public void testBackButtonNavigationInNewMessageScreen() throws Exception{
	
		
	VerifyInboxScreen inboxScreen=	new VerifyInboxScreen();
	inboxScreen.checkBackButtonInNewMessage();
	}
	
	
	/**
	 * =============================================================================
	 * Method: testOpenMessage
	 * Description: Verify that message details open correctly when a conversation is selected.
	 * Groups/Tags: Messaging, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */


	@Test(description="Verify that message details open correctly when a conversation is selected.",groups= {"Messaging","Regression"})
	public void testOpenMessage() throws Exception{

      VerifyInboxScreen inboxScreen=  new VerifyInboxScreen();
      inboxScreen.verifyMessageSubjectInInbox();
    }

	
	/**
	 * =============================================================================
	 * Method: testReplyNotAllowedForAutomatedMessage
	 * Description: Validate that automated messages cannot be replied to.
	 * Groups/Tags: Messaging, Negative, Regression
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */


	@Test(description="Validate that automated messages do not allow user replies.",groups= {"Messaging","Regression","Negative"})
	public void testReplyNotAllowedForAutomatedMessage() throws Exception{
		
		
	VerifyInboxScreen inboxScreen=	new VerifyInboxScreen();
	inboxScreen.checkingForReplyMessageFieldForAutomatedMessageInInboxScreen();
	}
  
	
	

/**
 * =============================================================================
 * Method: testInboxHeaderWithNoMessages
 * Description: Verify Inbox header and text when no conversations exist.
 * Groups/Tags: Inbox, Regression
 * Parameters: None
 * Return: void
 * =============================================================================
 */


	@Test(description="Validate Inbox header and text when no conversations are present.",groups= {"Inbox","Regression"})
	public void testInboxHeaderWithNoMessages() throws Exception{
				VerifyInboxScreen inboxScreen=			new VerifyInboxScreen();
				inboxScreen.checkingInboxWithEmptyMessages();
	}

	
}
