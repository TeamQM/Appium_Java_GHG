package com.framework.goodhealthgateway.android.testcases.diabetes.documentsTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen.VerifyListedDocumentInDownloadDocumentsScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;


@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_001_003_005_Documents_Verify_ListedDocument_After_User_Tap_On_Document_Icon {
	
	
	@Test(dataProviderClass = ExcelDataReader.class,description = "[TC_Documents_001,TC_Documents_003,TC_Documents_005]Verify listed Documents after user tap on document icon",
            groups = {"regression", "registration_and_login"})
    public void verifyListedDocumentAfterUserTapOnDocumentIcon() throws Exception {
        
		VerifyListedDocumentInDownloadDocumentsScreen verifyListedDocumentInDownloadDocumentsScreen = new VerifyListedDocumentInDownloadDocumentsScreen();

		verifyListedDocumentInDownloadDocumentsScreen.isListedDocumentsDisplayedOnDownloadDocumentsScreen(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DownloadDocumentsText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("PCFText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("PrintableRxRewardsText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DiabetesHealthActionPlanText"));
	}
	
}
