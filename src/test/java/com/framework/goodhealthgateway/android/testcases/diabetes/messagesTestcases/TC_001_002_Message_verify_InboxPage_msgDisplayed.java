package com.framework.goodhealthgateway.android.testcases.diabetes.messagesTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.messagesScreen.VerifyInboxMessagePage;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_001_002_Message_verify_InboxPage_msgDisplayed {
	
	@Test(description = "[TC_Messags_001,TC_Messags_002] verify inbox page and no message displayed inside the inbox ",
            groups = {"regression", "registration_and_login"})
    public void verifyInboxMessagePage() throws Exception {
        
		VerifyInboxMessagePage verifyInboxMessagePage = new VerifyInboxMessagePage();
		
		verifyInboxMessagePage.verifyInboxPageMsgDisplayed(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("MessagePage").get("InboxText"),
				ExcelDataReader.getLanguagesFromHomePage("MessagePage").get("NoMessageText"),
				ExcelDataReader.getLanguagesFromHomePage("MessagePage").get("YouDoNotHaveAnyMessagesCurrentlyText"));

	}
	
}
