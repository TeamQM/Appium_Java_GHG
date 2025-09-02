package com.framework.goodhealthgateway.android.screens.healthyweight.surveyscreen;

import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.utilities.ExcelReader;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.utilities.ReportManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SurveyCenterScreen_HW {
    MobileActions mobileActions = new MobileActions();
    CommonHelper commonHelper = new CommonHelper();

    public void navigationToSurveyCenterScreen(String Username, String Password) throws Exception {

        commonHelper.loginWithValidUserNameAndPwdForHw(Username,Password);

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen_HW", "SurveysTab")," Surveys Tab ");

        //This will verify the title text of Survey Center tab to ensure that screen is redirected properly
        WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterTitle"));
        mobileActions.verifyText(el.getAttribute("content-desc"),"Survey Center");
        ReportManager.logInfo("Successfully Navigated to Survey Center Screen");

    }
    public void verifyWelcomeText(){
        WebElement welcomemsg= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterWelcomeMessage"));
        mobileActions.verifyText(welcomemsg.getAttribute("content-desc"),"Welcome to the Survey Center");
        WebElement el= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterWelcomeText"));

        mobileActions.verifyText(el.getAttribute("content-desc"),"Click on any of the Active surveys to provide your answers before the expiration date. Each survey should take about 5 minutes to complete. Most of the surveys help your Coach understand your current thoughts and feelings about your health and weight loss journey.");
        ReportManager.logInfo("Verified Welcome Text");
    }

    public void verifyWelcomeTextBoxCloses() throws Exception {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen", "WelcomeTextCloseButton")," WelcomeTextCloseButton ");

        boolean welcomeMsgNotDisplayed = mobileActions.isNotDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","SurveyCenterWelcomeMessage"),"Welcome Message");
        Assert.assertTrue(welcomeMsgNotDisplayed);
    }

    public void verifyNoCompletedSurveysMessage() throws InterruptedException {

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","ViewAllButtonForCompletedSurveys"), "View All Button For Completed Surveys");
        WebElement noSurveysText= 	mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SurveyCenterScreen","NoSurveysFoundTextInCompletedSurveysPage"));
        mobileActions.verifyText(noSurveysText.getAttribute("content-desc"),"You do not have any surveys currently.");
        ReportManager.logInfo("Successfully verified no surveys found messages when there are no completed surveys");

    }


}
