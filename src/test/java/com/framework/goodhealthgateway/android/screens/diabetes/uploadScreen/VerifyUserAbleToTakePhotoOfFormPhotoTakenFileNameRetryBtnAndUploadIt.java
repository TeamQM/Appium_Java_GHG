package com.framework.goodhealthgateway.android.screens.diabetes.uploadScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.openqa.selenium.By;

import java.io.IOException;

public class VerifyUserAbleToTakePhotoOfFormPhotoTakenFileNameRetryBtnAndUploadIt {

	MobileActions mobileActions = new MobileActions();
	CommonHelper CommonHelper = new CommonHelper();
	public void isUserAbleToTakePhotoOfFormPhotoTakenFileNameRetryBtn(String UserName, String Password, String WelcomeBackText , String UploadProviderFormText, String CancelText, String RetryText, String RetakeText, String UploadStatusText, String ProviderFormuploadedsuccessfullyText)

	throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Take a Photo and Retry Button Validation ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
		String StrAct_WelcomeBackText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_WelcomeBackText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
		}
		String StrExp_WelcomeBackText = WelcomeBackText;
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "Upload"), "Upload");
		String strAct_UploadProviderForm = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_UploadProviderForm=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_UploadProviderForm=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "uploadProviderform");
		}
		String strExp_UploadProviderForm = UploadProviderFormText;
		mobileActions.verifyText(strAct_UploadProviderForm, strExp_UploadProviderForm);

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "takeAPhoto"), "takeAPhoto");
		Thread.sleep(2000);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			if (mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"))) {
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"), "Allow");
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "takeAPhoto"), "takeAPhoto");

			}
			else {
				DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.widget.Button[@text='Only this time']")).click();
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "takeAPhoto"), "takeAPhoto");
			}

		}
		String strAct_CancelText = null;
//		if (Constants.platformName.equalsIgnoreCase("android")) {
//			strAct_CancelText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "cancelText"), "cancelText");
//		}
		 if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_CancelText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "cancelText"), "cancelText");
			 String ExpectedCancelText = CancelText;
			 mobileActions.verifyText(strAct_CancelText, ExpectedCancelText);
		 }
		 ReportManager.logScreenshotInfo();

		//mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PhotoCapture"), "photoCapture");
		mobileActions.clickUsingCoordinates(939,252);


		String strAct_retakeText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_retakeText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "retake"), "name");
			String ExpectedretakeText = RetryText;
			mobileActions.verifyText(strAct_retakeText, ExpectedretakeText);
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_retakeText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "retake"), "name");
			String ExpectedretakeText = RetakeText;
			mobileActions.verifyText(strAct_retakeText, ExpectedretakeText);
		}

		ReportManager.logScreenshotInfo();
		if (Constants.platformName.equalsIgnoreCase("android"))
		{
			if (mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "okBtn_photo"))) {

				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "okBtn_photo"), "okBtn_photo");
			}
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "usePhoto"), "usePhoto");
			Thread.sleep(2000);
		}
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "takeAPhoto"), "takeAPhoto");

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PhotoCapture"), "photoCapture");
		String strAct_retakeText1 = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_retakeText1=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "retake"), "name");
			String ExpectedretakeText1 = RetryText;
			mobileActions.verifyText(strAct_retakeText1, ExpectedretakeText1);
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_retakeText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "retake"), "name");
			String ExpectedretakeText = RetakeText;
			mobileActions.verifyText(strAct_retakeText, ExpectedretakeText);
		}

		ReportManager.logScreenshotInfo();
		if (Constants.platformName.equalsIgnoreCase("android"))
		{
			if (mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "okBtn_photo"))) {

				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "okBtn_photo"), "okBtn_photo");
			}
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "usePhoto"), "usePhoto");
			Thread.sleep(2000);
		}




















//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "takeAPhoto"), "takeAPhoto");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PhotoCapture"), "photoCapture");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "retake"), "retake");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "PhotoCapture"), "photoCapture");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "usePhoto"), "usePhoto");
//		String strAct_UploadImageText1 = null;
//		if (Constants.platformName.equalsIgnoreCase("android")) {
//			strAct_UploadImageText1=DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("(//XCUIElementTypeStaticText)[5]")).getText();
//		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
//			strAct_UploadImageText1=DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("(//XCUIElementTypeStaticText)[5]")).getText();
//		}
//		Assert.assertEquals(strAct_UploadImageText1.contains("image_picker"),true );
		Thread.sleep(2000);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadBtn"), "UploadBtn");
		Thread.sleep(2000);
		String strAct_UploadstatusText = null;
		Thread.sleep(500);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_UploadstatusText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_UploadstatusText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "name");
		}
		String strExp_UploadstatusText = UploadStatusText;
		mobileActions.verifyText(strAct_UploadstatusText, strExp_UploadstatusText);

		String strAct_fileUploadSuccessText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_fileUploadSuccessText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProviderFormUploadedSuccessfully"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_fileUploadSuccessText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProviderFormUploadedSuccessfully"), "ProviderFormUploadedSuccessfully");
		}
		String strExp_fileUploadSuccessText = ProviderFormuploadedsuccessfullyText;
		mobileActions.verifyText(strAct_fileUploadSuccessText, strExp_fileUploadSuccessText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "okBtn"), "okBtn");
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully User able to take a Photo and Upload it and Retry Button Validated" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated status for the take a photo file upload and Retry button===============" + "</b>");

	}
}
