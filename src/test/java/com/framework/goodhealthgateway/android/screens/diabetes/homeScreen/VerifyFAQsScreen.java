package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.testng.Assert;

import java.io.IOException;

public class VerifyFAQsScreen {
    MobileActions mobileActions = new MobileActions();
    CommonHelper CommonHelper = new CommonHelper();

    public void isFAQsScreenDisplayedAndValidatedScreen(String UserName, String Password, String FAQText, String FAQConfirmationFormText, String FAQSimplyProvideSeperateCopyText, String FAQHemoglobinA1cTestText, String FAQOverTimeHighBloodSugarEffectsText,
                                                        String FAQLookForCutsText, String FAQBecauseDiabetesText, String FAQItIsBestToHaveAnEyeDoctorText, String FAQBeingSickByItselfText, String FAQPeopleWithUncontrolleddiabetesText, String FAQkidneyProblemsText, String FAQYourDoctorOrOtherHealthCareText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================FAQs Screens Validation ===============" + "</b>");

        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        CommonHelper.menuPageFlow();
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FAQs_btn"),"FAQs_btn");
        Thread.sleep(200);
        String StrAct_FAQsText =null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_FAQsText=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FAQs"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_FAQsText=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FAQs"), "name");
        }
        String StrExp_FAQsText = FAQText;
        mobileActions.verifyText(StrAct_FAQsText, StrExp_FAQsText);
        String strAct_submitNewConfirmationText =null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_submitNewConfirmationText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "submitNewConfirmation_Text"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_submitNewConfirmationText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "submitNewConfirmation_Text"), "name");
        }
        String strExp_submitNewConfirmationText = FAQConfirmationFormText;
        mobileActions.verifyText(strAct_submitNewConfirmationText,strExp_submitNewConfirmationText);

        String strAct_simplyProvideText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_simplyProvideText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "simplyProvide_Text"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_simplyProvideText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "simplyProvide_Text"), "name");
        }
        Assert.assertEquals(strAct_simplyProvideText.contains(FAQSimplyProvideSeperateCopyText),true );
        String strAct_hemoglobinText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_hemoglobinText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "hemoglobin_Text"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_hemoglobinText= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "hemoglobin_Text"), "name");
        }
        Assert.assertEquals(strAct_hemoglobinText.contains(FAQHemoglobinA1cTestText),true );
        String strAct_overTimeText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_overTimeText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "overTime_Text"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_overTimeText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "overTime_Text"), "name");
        }
        Assert.assertEquals(strAct_overTimeText.contains(FAQOverTimeHighBloodSugarEffectsText),true );

      //  mobileActions.swipeUp(1);
        mobileActions.swipeUp(2);
        String strAct_betweenFootExams =null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_betweenFootExams= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "betweenFootExams"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_betweenFootExams=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "betweenFootExams"), "name");
        }
        Assert.assertEquals(strAct_betweenFootExams.contains(FAQLookForCutsText),true );
        String strAct_eyeExam = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_eyeExam= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "eyeExam"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_eyeExam= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "eyeExam"), "name");
        }
        Assert.assertEquals(strAct_eyeExam.contains(FAQBecauseDiabetesText),true );

        String strAct_dialatedEyeExams = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_dialatedEyeExams= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "dialatedEyeExam"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_dialatedEyeExams= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "dialatedEyeExam"), "name");
        }
        Assert.assertEquals(strAct_dialatedEyeExams.contains(FAQItIsBestToHaveAnEyeDoctorText),true );
        mobileActions.swipeUp(1);
        String strAct_coldOrFlu = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_coldOrFlu= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "coldOrFlu"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_coldOrFlu= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "coldOrFlu"), "name");
        }
        Assert.assertEquals(strAct_coldOrFlu.contains(FAQBeingSickByItselfText),true );

        mobileActions.swipeUp(1);
        String strAct_bloodLipidProfile = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_bloodLipidProfile=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "bloodLipidProfile"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_bloodLipidProfile=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "bloodLipidProfile"), "name");
        }
        Assert.assertEquals(strAct_bloodLipidProfile.contains(FAQPeopleWithUncontrolleddiabetesText),true );

        String strAct_proteinLevelMeasured =null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_proteinLevelMeasured= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "proteinLevelMeasured"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_proteinLevelMeasured= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "proteinLevelMeasured"), "name");
        }
        Assert.assertEquals(strAct_proteinLevelMeasured.contains(FAQkidneyProblemsText),true );

        String strAct_myDiabetes = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_myDiabetes=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "myDiabetes"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_myDiabetes=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "myDiabetes"), "name");
        }
        Assert.assertEquals(strAct_myDiabetes.contains(FAQYourDoctorOrOtherHealthCareText),true );


        ReportManager.logScreenshotInfo();
        ReportManager.logPass("<b style=\"color:green;\">" + "Successfully displayed Diabetes Resources screen" + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Diabetes Resources screen, Phone number, TYY number, Visit Website, Email Id===============" + "</b>");

    }
}
