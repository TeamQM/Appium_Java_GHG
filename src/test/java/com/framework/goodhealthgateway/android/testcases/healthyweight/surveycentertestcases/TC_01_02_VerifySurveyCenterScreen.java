package com.framework.goodhealthgateway.android.testcases.healthyweight.surveycentertestcases;

import com.framework.goodhealthgateway.android.screens.healthyweight.surveyscreen.SurveyCenterScreen_HW;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({ SuiteEvent.class, MobileEvent.class })
public class TC_01_02_VerifySurveyCenterScreen {

    @Test(description="Verify that after navigating to the Survey Center screen, the welcome text is displayed properly.",groups= {"SurveyCenter", "Regression"})
    public void checkingSurveyCenterScreen() throws Exception {
        SurveyCenterScreen_HW surveyCenterScreenHw = new SurveyCenterScreen_HW();
        surveyCenterScreenHw.navigationToSurveyCenterScreen(ExcelReader.excel("UserName", "LoginPage"),
                ExcelReader.excel("Password", "LoginPage"));
        surveyCenterScreenHw.verifyWelcomeText();
    }

    @Test(description = "Verify that the welcome text box in the Survey Center can be dismissed by clicking the close (x) button.",groups= {"SurveyCenter","UI", "Regression"})
    public void verifyWelcomeTextBoxCloses() throws Exception {
        SurveyCenterScreen_HW surveyCenterScreenHw = new SurveyCenterScreen_HW();
        surveyCenterScreenHw.navigationToSurveyCenterScreen(ExcelReader.excel("UserName", "LoginPage"),
                ExcelReader.excel("Password", "LoginPage"));
        surveyCenterScreenHw.verifyWelcomeTextBoxCloses();

    }


}
