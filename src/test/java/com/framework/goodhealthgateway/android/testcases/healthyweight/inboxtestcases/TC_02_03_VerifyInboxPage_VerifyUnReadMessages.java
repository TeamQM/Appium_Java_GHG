package com.framework.goodhealthgateway.android.testcases.healthyweight.inboxtestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.healthyweight.inboxscreen.VerifyInboxScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_02_03_VerifyInboxPage_VerifyUnReadMessages {
  
	
	
	
	@Test
  public void verifyInboxPage() throws Exception {
  
  
//VerifyLoginScreen_HW   verifyLoginScreen_HW=		new				VerifyLoginScreen_HW() ;


VerifyInboxScreen verifyInboxScreen=		new VerifyInboxScreen();


verifyInboxScreen.checkingInbox();

  
  }
	
	
	@Test
	public void verifyNewMessageButton() throws Exception{
		
	VerifyInboxScreen inboxScreen=	new VerifyInboxScreen();
	inboxScreen.checkNewMessageButton();
	
	}
	
	
	@Test
	public void sendMessage() throws Exception{
		
		VerifyInboxScreen inboxScreen=	new VerifyInboxScreen();
		inboxScreen.createNewMessage();
	}
	
	
	@Test
	public void verifyBackButtonInNewMessageScreen() throws Exception{
	
		
	VerifyInboxScreen inboxScreen=	new VerifyInboxScreen();
	inboxScreen.checkBackButtonInNewMessage();
	}
	
	
	
	
	
  
}
