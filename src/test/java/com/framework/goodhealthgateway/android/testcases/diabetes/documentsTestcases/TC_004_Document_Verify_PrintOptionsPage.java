package com.framework.goodhealthgateway.android.testcases.diabetes.documentsTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen.VerifyPrintOptionPage;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_004_Document_Verify_PrintOptionsPage
{
	@Test(description = "[TC_Documents_004]Verify print option page after tap on print icon",
            groups = {"regression", "registration_and_login"})
    public void verifyPrintOptionPage() throws Exception {
        
		VerifyPrintOptionPage verifyPrintOptionPage = new VerifyPrintOptionPage();

		verifyPrintOptionPage.isPrintOptionDisplayed(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName2"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DownloadDocumentsText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("PCFText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("PrintOptionsText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("RxCardText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("RxCardWalletText"),
				ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("DHAPText"));

	    
	}
	
}
