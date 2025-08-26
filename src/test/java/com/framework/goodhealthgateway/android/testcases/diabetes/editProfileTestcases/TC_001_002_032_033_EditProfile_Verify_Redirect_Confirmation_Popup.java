package com.framework.goodhealthgateway.android.testcases.diabetes.editProfileTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.editProfileScreen.VerifyRedirectConfirmationPopUp;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_001_002_032_033_EditProfile_Verify_Redirect_Confirmation_Popup {

	  @Test(description = "[TC_EditProfile_001,TC_Home_032] Verify redirect confirmation popup after clicking editProfile on menu page",
	            groups = {"regression", "registration_and_login"})
	    public void verifyRedirectConfirmationPopupafterClickingEditProfile() throws Exception {
		  VerifyRedirectConfirmationPopUp verifyRedirectConfirmationPopUp = new VerifyRedirectConfirmationPopUp();
		  verifyRedirectConfirmationPopUp.isRedirectConfirmationPopupPopulated( ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				  ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("RedirectConfirmationText"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("EditProfileDescriptionText"));
	  }
	  @Test(description = "[TC_EditProfile_002,TC_Home_033]Verify Menu page after clicking cancel on redirect confirmation popup", groups = {
				"regression", "registration_and_login" })
		public void verifyMenuPageAfterClickCancelOnRedirectConfirmationPopup() throws Exception {
		    VerifyRedirectConfirmationPopUp verifyRedirectConfirmationPopUp = new VerifyRedirectConfirmationPopUp();
		  verifyRedirectConfirmationPopUp.isUserNavigatedMenuPageAfterClickingCancelOnRedirecConfirmation(  ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				  ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("RedirectConfirmationText"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("EditProfileDescriptionText"),
				  ExcelDataReader.getLanguagesFromHomePage("HomePage").get("MenuText")
		  );
	  }

}
