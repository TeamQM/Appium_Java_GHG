package com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen;

import java.io.IOException;
import com.framework.goodhealthgateway.android.screens.CommonHelper;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;

import com.framework.goodhealthgateway.android.Actions.MobileActions;

public class VerifyDocumentShareOptionPageAfterUserSelectShareIcon {
	static MobileActions mobileActions = new MobileActions();
	CommonHelper CommonHelper = new CommonHelper();
	public void isDocumentShareOptionPageDisplayedAfterUserSelectShareIcon(String UserName, String Password, String DownloadDocumentsText, String PCFText,  String documentText, String RxCardText, String DHAPText)

	throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Document Share Option Validation  ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		CommonHelper.documentFlow();
		Thread.sleep(5000);
		VerifyDocumentShareOptionPageAfterUserSelectShareIcon.downloadDocumentPage(DownloadDocumentsText);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProvideConfirmationFormBtn"),
				"ProvideConfirmationFormBtn");
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(326,204);
		}
		Thread.sleep(2000);
		String pcFText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			pcFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PCFText"), "content-desc");
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			pcFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PCFText"), "name");
		}
		String expectedpcFText = PCFText;
		mobileActions.verifyText(pcFText, expectedpcFText);
		VerifyDocumentShareOptionPageAfterUserSelectShareIcon.printAndShareIcon(documentText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
				"BackArrowButton");
		Thread.sleep(2000);
		VerifyDocumentShareOptionPageAfterUserSelectShareIcon.downloadDocumentPage(DownloadDocumentsText);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxRewardCardBtn"),
				"RxRewardCardBtn");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(328,336);
		}
		Thread.sleep(2000);
		String rxCardFText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			rxCardFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxcardText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			rxCardFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxcardText"), "name");
		}
		String expectedrXcardText = RxCardText;
		mobileActions.verifyText(rxCardFText, expectedrXcardText);
		VerifyDocumentShareOptionPageAfterUserSelectShareIcon.printAndShareIcon(documentText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
				"BackArrowButton");
		VerifyDocumentShareOptionPageAfterUserSelectShareIcon.downloadDocumentPage(DownloadDocumentsText);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DiabetesHealthActionPlanBtn"),
				"DiabetesHealthActionPlanBtn");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(328,554);
		}
		Thread.sleep(2000);
		String DhapText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			DhapText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DHAPText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			DhapText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DHAPText"), "name");
		}
		String expectedDHAPText = DHAPText;
		mobileActions.verifyText(DhapText, expectedDHAPText);
		VerifyDocumentShareOptionPageAfterUserSelectShareIcon.printAndShareIcon(documentText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
				"BackArrowButton");
		VerifyDocumentShareOptionPageAfterUserSelectShareIcon.downloadDocumentPage(DownloadDocumentsText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully displayed document share option" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Successfully Validated documents shared option page  ===============" + "</b>");
	}

	public static void downloadDocumentPage(String DownloadDocumentsText) throws InterruptedException {
		Thread.sleep(5000);
		String DownDocPage = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			DownDocPage=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			DownDocPage=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "name");
		}
		String expectedDaText = DownloadDocumentsText;
		mobileActions.verifyText(DownDocPage, expectedDaText);
	}

	public static void printAndShareIcon(String documentText) throws InterruptedException {
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Setting"), "printerIcon");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ShareIcon"), "shareIcon");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ShareIcon"),
				"ShareIcon");
		String strAct_documentText = null;
		System.out.println(strAct_documentText);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_documentText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "copyText"), "content-desc").replace(".pdf","");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_documentText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "document_Text"), "name");
		}
		String strExp_documentText = documentText;
		mobileActions.verifyText(strAct_documentText, strExp_documentText);
		mobileActions.clickUsingCoordinates(208,300);
	}

}
