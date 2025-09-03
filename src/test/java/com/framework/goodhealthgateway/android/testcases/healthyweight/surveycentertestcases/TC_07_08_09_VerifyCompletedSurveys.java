package com.framework.goodhealthgateway.android.testcases.healthyweight.surveycentertestcases;

import com.framework.goodhealthgateway.android.screens.healthyweight.surveyscreen.SurveyCenterScreen_HW;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_07_08_09_VerifyCompletedSurveys {

    @Test(description ="Verify that when there are no completed surveys available, the proper No Surveys Found message is displayed.",groups= {"CompletedSurveys", "Regression"})
    public void testNoSurveysFoundMsgsForCompletedSurveys() throws Exception {
        SurveyCenterScreen_HW surveyCenterScreenHw = new SurveyCenterScreen_HW();
        surveyCenterScreenHw.navigationToSurveyCenterScreen(ExcelReader.excel("UserNameNoCompletedSurvey", "LoginPage"),
                ExcelReader.excel("Password", "LoginPage"));
        surveyCenterScreenHw.verifyNoCompletedSurveysMessage();
    }
    @Test(description="Verify navigation to Completed Surveys page and that the back button works correctly.",groups= {"CompletedSurveys", "Regression"})
    public void testBackButtonInCompletedSurveysPage() throws Exception {
        SurveyCenterScreen_HW surveyCenterScreenHw = new SurveyCenterScreen_HW();
        surveyCenterScreenHw.navigationToSurveyCenterScreen(ExcelReader.excel("UserName", "LoginPage"),
                ExcelReader.excel("Password", "LoginPage"));
        surveyCenterScreenHw.verifyBackButtonInCompletedSurveysScreen();
    }
}
 