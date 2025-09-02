package com.framework.goodhealthgateway.android.testcases.healthyweight.surveycentertestcases;

import com.framework.goodhealthgateway.android.screens.healthyweight.surveyscreen.SurveyCenterScreen_HW;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_04_05_06_VerifyActiveSurveys {
    @Test
    public void testNoSurveysFoundMsgsForCompletedSurveys() throws Exception {
        SurveyCenterScreen_HW surveyCenterScreenHw = new SurveyCenterScreen_HW();
        surveyCenterScreenHw.navigationToSurveyCenterScreen(ExcelReader.excel("UserName", "LoginPage"),
                ExcelReader.excel("Password", "LoginPage"));
        surveyCenterScreenHw.verifyNoCompletedSurveysMessage();
    }
}
