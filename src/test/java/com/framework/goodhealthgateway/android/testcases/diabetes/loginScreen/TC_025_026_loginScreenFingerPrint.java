package com.framework.goodhealthgateway.android.testcases.diabetes.loginScreen;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.loginScreen.VeifyLoginScreen;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;


@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_025_026_loginScreenFingerPrint {
   @Test(priority=9,dataProviderClass = ExcelDataReader.class,description = "[TC_Login_025, TC_Login_026]Verify login page after user tap on fingerprint icon and verify login page after user tap on cancel on authentication popup",
            groups = {"regression", "registration_and_login"})
    public void verifyLoginPageAfterUserTapCancelOnAuthenticationPopupForFingerPrintIcon() throws Exception {

       VeifyLoginScreen veifyloginScreen = new VeifyLoginScreen();
       veifyloginScreen.verifyLoginPageAfterClickCancelOnAuthenticationPageFingerPrint(
               ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
               ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
               ExcelDataReader.getLanguagesFromHomePage("HomePage").get("OnBoardingHomeText"),
               ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("FaceNotRecognisedText_Android"),
               ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("BiometricLoginCancelledNotSupportedText"));

   }

    @Test(priority=9,dataProviderClass = ExcelDataReader.class,description = "[TC_Login_015]Verify Error message for User enters correct username, incorrect password 10 times. ",
            groups = {"regression", "registration_and_login"})
    public void verifyLoginPageAfterClickCancelOnAuthenticationPageFingerPrint() throws Exception {

        VeifyLoginScreen veifyloginScreen = new VeifyLoginScreen();
        veifyloginScreen.verifyErrorMessageForToManyAttemptsOfIncorrectPassword(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName3"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("InvalidPassword"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("ErrorMessageforTooManyAttemptText"));


    }
}
