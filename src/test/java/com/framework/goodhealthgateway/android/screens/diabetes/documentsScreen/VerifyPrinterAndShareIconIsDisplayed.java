package com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen;

import java.io.IOException;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;


public class VerifyPrinterAndShareIconIsDisplayed {
	static MobileActions mobileActions = new MobileActions();
	CommonHelper CommonHelper = new CommonHelper();
	public void isPrinterAndShareIconIsDisplayed(String UserName, String Password, String DownloadDocumentsText, String PCFText, String RxCardText, String RxCardWalletText, String DHAPText)
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Printer and Share Icons Validation on Download Documents Screen  ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		CommonHelper.documentFlow();
		Thread.sleep(5000);
		downloadDocumentPage(DownloadDocumentsText);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProvideConfirmationFormBtn"),
				"ProvideConfirmationFormBtn");
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(328,203);
		}
		Thread.sleep(2000);
		String strAct_pcFText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_pcFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PCFText"), "content-desc");
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_pcFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PCFText"), "name");
		}
		String strExp_pcFText = PCFText;
		mobileActions.verifyText(strAct_pcFText, strExp_pcFText);
		VerifyPrinterAndShareIconIsDisplayed.printAndShareIcon();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
				"BackArrowButton");
		VerifyPrinterAndShareIconIsDisplayed.downloadDocumentPage(DownloadDocumentsText);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxRewardCardBtn"),
				"RxRewardCardBtn");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(328,336);
		}
		Thread.sleep(2000);
		String strAct_rxCardFText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_rxCardFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxcardText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_rxCardFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxcardText"), "name");
		}
		String strExp_rxCardFText = RxCardText;
		mobileActions.verifyText(strAct_rxCardFText, strExp_rxCardFText);
		VerifyPrinterAndShareIconIsDisplayed.printAndShareIcon();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
				"BackArrowButton");
		CommonHelper.downloadDocumentPage();
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PrintableRxCardRewardsCardBtn"), "PrintableRxCardRewardsCardBtn");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(328,449);
		}
		Thread.sleep(2000);
		String strAct_rxCardWalletFText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_rxCardWalletFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxCardWallet"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_rxCardWalletFText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxCardWallet"), "name");
		}
		String strExp_rxCardWalletFText = RxCardWalletText;
		mobileActions.verifyText(strAct_rxCardWalletFText, strExp_rxCardWalletFText);

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
				"BackArrowButton");
		CommonHelper.downloadDocumentPage();
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DiabetesHealthActionPlanBtn"),
				"DiabetesHealthActionPlanBtn");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(328,554);
		}
		Thread.sleep(2000);
		String strAct_DhapText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_DhapText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DHAPText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_DhapText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DHAPText"), "name");
		}
		String strExp_DhapText =DHAPText;
		mobileActions.verifyText(strAct_DhapText, strExp_DhapText);
		VerifyPrinterAndShareIconIsDisplayed.printAndShareIcon();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
				"BackArrowButton");
		CommonHelper.downloadDocumentPage();
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + " Successfully displayed Printer and Share Icon on Download Documents screen " + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Successfully Validated Printer and Share Icons on listed documents on Download Documents screen  ===============" + "</b>");
	}

	public static void downloadDocumentPage(String DownloadDocumentsText) {
		String DownDocPage = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			DownDocPage=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			DownDocPage=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "name");
		}
		String expectedDaText = DownloadDocumentsText;
		mobileActions.verifyText(DownDocPage, expectedDaText);
	}

	public static void printAndShareIcon() {
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PrinterIcon"), "print Icon");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ShareIcon"), "shareIcon");

	}


}
