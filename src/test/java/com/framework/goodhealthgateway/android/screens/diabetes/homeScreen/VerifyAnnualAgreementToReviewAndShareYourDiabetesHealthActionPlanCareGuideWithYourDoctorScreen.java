package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import java.io.IOException;
public class VerifyAnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen {
	MobileActions mobileActions = new MobileActions();
	CommonHelper CommonHelper = new CommonHelper();
	
	/**
	 * This method is to login on GHG application
	 * 
	 * @param UserName
	 * @param Password
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void isAnnualAgreementToReviewAndShareYourDiabetesHealthActionPlanCareGuideWithYourDoctorScreen(String UserName, String Password, String WelcomeBackText, String AnnualAgreementToReviewAndShareYourDHAPText, String AnnualAgreementToReviewAndShareYourDHAPDescriptionText, String DownloadDocumentsText, String DHAPText)
			throws InterruptedException, IOException, FilloException {
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");

		Thread.sleep(5000);
		String StrAct_WelcomeBackText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
		}
		String StrExp_WelcomeBackText =WelcomeBackText;
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
		mobileActions.swipeUp(2);
		Thread.sleep(5000);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnualAgreement"),"AnnualAgreement");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(155, 463);
		}
		Thread.sleep(2000);
		String strAct_annualAgreementToReview= null;
		String strExp_annualAgreementToReview =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_annualAgreementToReview=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "AnnualAgreement"), "content-desc").stripLeading();
			 strExp_annualAgreementToReview ="￼\n" +
					 "￼\n" +
					 "Annual Agreement to Review and Share Your Diabetes Health Action Plan® Care Guide With Your Doctor";
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_annualAgreementToReview=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Annaul"), "name").stripLeading();
			 strExp_annualAgreementToReview =AnnualAgreementToReviewAndShareYourDHAPText;
		}
		mobileActions.verifyText(strAct_annualAgreementToReview, strExp_annualAgreementToReview);
		String strAct_annualAgreementToReviewDescription =null;
		String strExp_annualAgreementToReviewDescription = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_annualAgreementToReviewDescription=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DiabetsHealthAction"), "content-desc").stripLeading();
			 strExp_annualAgreementToReviewDescription = "￼\n" +
					 "￼\n" +
					 "You will need to review your Diabetes Health Action Plan Care Guide and agree that you will share your action plan with the doctor or doctors that manage your diabetes.";
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_annualAgreementToReviewDescription=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "YouWill"), "name").stripLeading();
			 strExp_annualAgreementToReviewDescription = AnnualAgreementToReviewAndShareYourDHAPDescriptionText;
		}
		mobileActions.verifyText(strAct_annualAgreementToReviewDescription, strExp_annualAgreementToReviewDescription);
		Thread.sleep(3000);
	    mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DHAPDownloadBtn"),"DHAPDownloadBtn");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DHAPDownloadBtn"),"DHAPDownloadBtn");
		Thread.sleep(2000);
		String DownDocPage = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			DownDocPage=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			DownDocPage=	mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "name");
		}
		String expectedDaText = DownloadDocumentsText;
		mobileActions.verifyText(DownDocPage, expectedDaText);
		if (Constants.platformName.equalsIgnoreCase("android")) {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DiabetesHealthActionPlanBtn"), "DiabetesHealthActionPlanBtn");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(328, 554);
		}
		Thread.sleep(2000);
		String DhapText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			DhapText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DHAPText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			DhapText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DHAPText"), "name");
		}
		String expectedDHAPText = DHAPText;
		mobileActions.verifyText(DhapText, expectedDHAPText);
		ReportManager.logScreenshotInfo();

	}
}
