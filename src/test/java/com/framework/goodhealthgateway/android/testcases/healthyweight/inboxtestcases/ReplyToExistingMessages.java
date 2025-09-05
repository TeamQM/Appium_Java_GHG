package com.framework.goodhealthgateway.android.testcases.healthyweight.inboxtestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.healthyweight.inboxscreen.VerifyInboxScreen;
import com.framework.goodhealthgateway.android.screens.healthyweight.inboxscreen.VerifySendingReplyInNewMessageScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;



@Listeners({SuiteEvent.class,MobileEvent.class})

public class ReplyToExistingMessages {
 
	
	

	@Test(description="Verify that user can reply to an existing message with text.",groups= {"Messaging","Regression"})
	public void testReplyToMessageWithText() throws Exception{
	VerifySendingReplyInNewMessageScreen r=	new 	VerifySendingReplyInNewMessageScreen();
		r.replyToExistingMessage();
	}
	
	
	
	@Test(description="Verify that user can reply to an existing message with a hyperlink.",groups= {"Messaging","Regression"})
	public void testReplyToMessageWithHyperlink() throws Exception{
		VerifySendingReplyInNewMessageScreen r=	new 	VerifySendingReplyInNewMessageScreen();
		r.replyAsHyperLinkToExistingMessage();
	}

}
