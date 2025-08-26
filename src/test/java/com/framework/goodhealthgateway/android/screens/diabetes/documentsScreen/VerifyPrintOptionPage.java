package com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen;

import java.io.IOException;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

public class VerifyPrintOptionPage {
    static MobileActions mobileActions = new MobileActions();
   CommonHelper CommonHelper = new CommonHelper();

    public void isPrintOptionDisplayed(String UserName, String Password, String DownloadDocumentsText, String PCFText , String PrintOptionsText, String RxCardText, String RxCardWalletText, String DHAPText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Print Option Validation on Download Documents Screen  ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        CommonHelper.documentFlow();
        Thread.sleep(5000);

        VerifyPrintOptionPage.downloadDocumentPage(DownloadDocumentsText);
        if (Constants.platformName.equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProvideConfirmationFormBtn"),
                "ProvideConfirmationFormBtn");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            mobileActions.clickUsingCoordinates(326,204);
        }
        Thread.sleep(2000);
        String strAct_pcFText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_pcFText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PCFText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_pcFText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PCFText"), "name");
        }
        String strExp_pcFText = PCFText;
        mobileActions.verifyText(strAct_pcFText, strExp_pcFText);
        VerifyPrintOptionPage.printAndShareIcon(PrintOptionsText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
                "BackArrowButton");
        VerifyPrintOptionPage.downloadDocumentPage(DownloadDocumentsText);
        if (Constants.platformName.equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxRewardCardBtn"),
                "RxRewardCardBtn");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            mobileActions.clickUsingCoordinates(328,336);
        }
        Thread.sleep(2000);
        String strAct_rxCardFText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_rxCardFText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxcardText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_rxCardFText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "RxcardText"), "name");
        }
        String strExp_rxCardFText = RxCardText;
        mobileActions.verifyText(strAct_rxCardFText, strExp_rxCardFText);
        VerifyPrintOptionPage.printAndShareIcon(PrintOptionsText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
                "BackArrowButton");
        VerifyPrintOptionPage.downloadDocumentPage(DownloadDocumentsText);

        //===========Printer and Share icons are not visible in Printable RX Reward Card=======================


        //		mobileActions.click(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "PrintableRxCardRewardsCardBtn"),
//				"PrintableRxCardRewardsCardBtn");
//		Thread.sleep(2000);
//		String rxCardWalletFText = mobileActions.getAttribute(RxCardWallet, "name");
//		String expectedrxCardWalletFText = rxCardWalletFText;
//		mobileActions.verifyText(rxCardWalletFText, expectedrxCardWalletFText);
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "BackArrowButton"),
//				"BackArrowButton");
//		DocumentGhgPage2.downloadDocumentPage();


        if (Constants.platformName.equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DiabetesHealthActionPlanBtn"), "DiabetesHealthActionPlanBtn");
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
        String strExp_DhapText = DHAPText;
        mobileActions.verifyText(strAct_DhapText, strExp_DhapText);
        VerifyPrintOptionPage.printAndShareIcon(PrintOptionsText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrowButton"),
                "BackArrowButton");
        VerifyPrintOptionPage.downloadDocumentPage(DownloadDocumentsText);
        ReportManager.logScreenshotInfo();
        ReportManager.logPass("<b style=\"color:green;\">" + " Successfully displayed Print Option " + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Successfully Validated Print Option ===============" + "</b>");

    }

    public static void downloadDocumentPage(String DownloadDocumentsText) {
        String DownDocPage = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			DownDocPage=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			DownDocPage=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "name");
		}
		String expectedDaText =DownloadDocumentsText;
        mobileActions.verifyText(DownDocPage, expectedDaText);
    }

    public static void printAndShareIcon(String PrintOptionsText) throws InterruptedException {

        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Print Option Screen  ===============" + "</b>");
        mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PrinterIcon"), "printerIcon");
        mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ShareIcon"), "shareIcon");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PrinterIcon"), "PrinterIcon");
        String printOpt =null;
		String expectedPrintOption=null;

		if (Constants.platformName.equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PrintIconDropdown"), "PrintIconDropdown");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PrintIconDropdown"), "PrintIconDropdown");
            DriverFactory.getInstance().getMobileDriver().navigate().back();


        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
			printOpt=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "printOption"), "name");
			 expectedPrintOption = PrintOptionsText;
            mobileActions.verifyText(printOpt, expectedPrintOption);
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Cancel"),
                    "Cancel");
        }
    }

}
