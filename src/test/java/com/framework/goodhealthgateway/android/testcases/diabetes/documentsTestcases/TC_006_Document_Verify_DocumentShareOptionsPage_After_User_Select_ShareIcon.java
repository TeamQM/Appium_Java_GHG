package com.framework.goodhealthgateway.android.testcases.diabetes.documentsTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen.VerifyDocumentShareOptionPageAfterUserSelectShareIcon;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_006_Document_Verify_DocumentShareOptionsPage_After_User_Select_ShareIcon {

	@Test(description = "[TC_Documents_006]Verify document share options page after user select share icon",
            groups = {"regression", "registration_and_login"})
    public void verifyDocumentShareOptionPageAfterUserSelectShareIcon() throws Exception {
        
		VerifyDocumentShareOptionPageAfterUserSelectShareIcon DocumentGhgPage5 = new VerifyDocumentShareOptionPageAfterUserSelectShareIcon();
		
		DocumentGhgPage5.isDocumentShareOptionPageDisplayedAfterUserSelectShareIcon(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName2"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DownloadDocumentsText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("PCFText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("documentText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("RxCardText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DHAPText"));
	    
	}
	
}
