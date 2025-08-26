package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import java.io.IOException;

//import com.framework.android.screens.CommonHelper;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.openqa.selenium.By;

public class verifyContactUsPageCallOrCancel {

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


    public void isContactUsPageDisplayedAndVerifyCallOrCancelOptions(String UserName, String Password, String ContactUsText, String ThousandCharactersRemainingText, String QuestionCommentsFieldRequired,String QuestionText, String MessageSentSucceessText,  String MenuText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Contact Us Screen Validation ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        CommonHelper.menuPageFlow();
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "contactUs_btn"), "contactUs");
        String strAct_ContactusText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_ContactusText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "contactUs_btn"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_ContactusText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "contact_Us"), "name");
        }
        String strExp_Contactus = ContactUsText;
        mobileActions.verifyText(strAct_ContactusText, strExp_Contactus);
        ReportManager.logScreenshotInfo();
        String strExp_PhoneNumberText =null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strExp_PhoneNumberText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ContactUS_PhoneNo"), "content-desc").substring(10, 14);
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strExp_PhoneNumberText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "ContactUS_PhoneNo"), "name").substring(10, 14);
        }
        System.out.println("exp   ="+strExp_PhoneNumberText);

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "PhoneLink"), "PhoneLink");
        String strAct_PhoneNumberText =null;

        if (Constants.platformName.equalsIgnoreCase("android")) {
            Thread.sleep(2000);
            CommonHelper.swichApp("com.samsung.android.dialer","com.samsung.android.dialer.DialtactsActivity");
            strAct_PhoneNumberText= mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "phoneNumberKeypadText"), "content-desc").substring(6,10);
            System.out.println("act  ="+strAct_PhoneNumberText);
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_PhoneNumberText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "phoneNumberText"), "name").substring(12,16);
        }
        mobileActions.verifyText(strAct_PhoneNumberText, strExp_PhoneNumberText);
        Thread.sleep(500);
        if (Constants.platformName.equalsIgnoreCase("android")) {

            mobileActions.appSwitch();
            mobileActions.clickUsingCoordinates(506,824);
           // mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "GHG_App"), "GHG_App");
        }
        String strAct_contactusText2 = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_contactusText2= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "contactUs_btn"), "content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
            mobileActions.clickUsingCoordinates(180,750);
            strAct_contactusText2= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "contact_Us"), "name");
        }
        String strExp_contactus2 = "Contact Us";
        mobileActions.verifyText(strAct_contactusText2, strExp_contactus2);
        String strAct_CharactersReamaining = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_CharactersReamaining = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CharRemaining"),"content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
          strAct_CharactersReamaining = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CharRemaining"),"name");
        }
        String strExp_CharactersReamaining = ThousandCharactersRemainingText;
        mobileActions.verifyText(strAct_CharactersReamaining,strExp_CharactersReamaining);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Submit"), "Submit");
        String strAct_ErrorMessage = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_ErrorMessage = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","QuestionOrCommentsRequiredErrorMsg"),"content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
         strAct_ErrorMessage = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","QuestionOrCommentsRequiredErrorMsg"),"name");
        }
        String strExp_ErrorMessage = QuestionCommentsFieldRequired;
        mobileActions.verifyText(strAct_ErrorMessage,strExp_ErrorMessage);
        if (Constants.platformName.equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "QuestionOrComments"),"QuestionOrComments");

        }
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "QuestionOrComments"),QuestionText);
        if (Constants.platformName.equalsIgnoreCase("android")) {

            mobileActions.swipeElementAndroid(By.xpath("//android.view.View[contains(@content-desc,\"We value your opinion\")]"), "UP", By.xpath("//android.widget.Button[@content-desc='Submit']"), 4);
        }
        String strAct_CharactersReamaining1 = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_CharactersReamaining1 = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "NoCharRemaining"),"content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
         strAct_CharactersReamaining1 = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "NoCharRemaining"),"name");
        }

        String strExp_CharactersReamaining1 = "No characters remaining";
		mobileActions.verifyText(strAct_CharactersReamaining1,strExp_CharactersReamaining1);

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "Submit"), "Submit");
        String strAct_MessageSentText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_MessageSentText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MessageSentText"),"content-desc");
        }
        String strExp_MessageSentText=MessageSentSucceessText;
        mobileActions.verifyText(strAct_MessageSentText,strExp_MessageSentText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "okBtn"), "okBtn");


        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackButton"), "BackButton");
        String StrAct_menuText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_menuText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_menuText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "name");
        }        String StrExp_MenuText = MenuText;
        mobileActions.verifyText(StrAct_menuText, StrExp_MenuText);
        ReportManager.logScreenshotInfo();
        ReportManager.logPass("<b style=\"color:green;\">" + "Successfully Redirected To Contact Us Screen" + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Contact Us Screen, PopUp to Call and Cancel===============" + "</b>");


    }

}
