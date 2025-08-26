package com.framework.goodhealthgateway.android.testcases.diabetes.documentsTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen.VerifyPrinterAndShareIconIsDisplayed;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_002_009_011_013_014_Document_Verify_PrinterAndShareIcon_Is_Displayed {
	
	@Test(description = "[TC_Documents_002,TC_Documents_003,TC_Documents_009,TC_Documents_011,TC_Documents_013,TC_Documents_014]Verify printer and share icon is present after tap on arrow icon next to document, Verify download document page after user tap back on arrow ",
			groups = {"regression", "registration_and_login"})
    public void verifyprinterAndShareIconIsDisplayed() throws Exception {
        
		VerifyPrinterAndShareIconIsDisplayed verifyPrinterAndShareIconIsDisplayed = new VerifyPrinterAndShareIconIsDisplayed();

		verifyPrinterAndShareIconIsDisplayed.isPrinterAndShareIconIsDisplayed(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName2"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DownloadDocumentsText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("PCFText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("RxCardText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("RxCardWalletText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DHAPText"));

	    
	}
	
}
