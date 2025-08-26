package com.framework.goodhealthgateway.android.testcases.diabetes.editProfileTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.editProfileScreen.VerifyRedirectConfirmationPopUp;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_004_Verify_Menu_Page {
    @Test(dataProviderClass = ExcelDataReader.class,description = "[TC_EditProfile_004]Verify Menu page after clicking done button on GHG website", groups = {
            "regression", "registration_and_login" })
    public void verifyMenuPageAfterClickingDoneBtnInGhgWebsite() throws Exception {

        VerifyRedirectConfirmationPopUp verifyRedirectConfirmationPopUp= new VerifyRedirectConfirmationPopUp();
        verifyRedirectConfirmationPopUp.isUserNavigatedMenuPageAndVerifyMenuPageAfterClickingDoneBtn(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("RedirectConfirmationText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("EditProfileDescriptionText"),
                ExcelDataReader.getLanguagesFromHomePage("HomePage").get("MenuText"));

    }
}
