package com.framework.goodhealthgateway.android.testcases.diabetes.uploadTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.uploadScreen.VerifyUserAbleToTakePhotoOfFormPhotoTakenFileNameRetryBtnAndUploadIt;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_008_009_010_011_012_013_014_015_Upload_verify_UserAbleTakePhotoOfForm_PhotoTaken_FileName_RetryBtn {

	@Test(description = "[TC_Upload_008,TC_Upload_009,TC_Upload_010,TC_Upload_011,TC_Upload_012,TC_Upload_013,TC_Upload_014,TC_Upload_015] verify user able to take photo of there form,photo taken,file name displayed"
			+ "retyry and take photo again",
			groups = {"regression", "registration_and_login"})
    public void verifyUserAbleToTakePhotoOfFormPhotoTakenFileNameRetryBtnAndUploadIt() throws Exception {
		VerifyUserAbleToTakePhotoOfFormPhotoTakenFileNameRetryBtnAndUploadIt UploadGhgApp2 = new VerifyUserAbleToTakePhotoOfFormPhotoTakenFileNameRetryBtnAndUploadIt();
		UploadGhgApp2.isUserAbleToTakePhotoOfFormPhotoTakenFileNameRetryBtn(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("WelcomeBackText"),
				ExcelDataReader.getLanguagesFromHomePage("UploadPage").get("UploadProviderFormText"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("CancelText"),
				ExcelDataReader.getLanguagesFromHomePage("UploadPage").get("RetryText"),
				ExcelDataReader.getLanguagesFromHomePage("UploadPage").get("RetakeText"),
				ExcelDataReader.getLanguagesFromHomePage("UploadPage").get("UploadStatusText"),
				ExcelDataReader.getLanguagesFromHomePage("UploadPage").get("ProviderFormuploadedsuccessfullyText")
		);
	}
	
}
