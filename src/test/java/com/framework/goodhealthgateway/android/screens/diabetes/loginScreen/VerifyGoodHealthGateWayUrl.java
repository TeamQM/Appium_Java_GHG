package com.framework.goodhealthgateway.android.screens.diabetes.loginScreen;

import java.io.IOException;


import org.openqa.selenium.By;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.testng.Assert;

public class VerifyGoodHealthGateWayUrl {
    MobileActions mobileActions = new MobileActions();
CommonHelper CommonHelper = new CommonHelper();
    /**
     * This method is to login on GHG application Ø
     *
     * @param mobileNumber
     * @throws InterruptedException
     * @throws IOException
     * @throws FilloException
     */

    By goodHealthGateWay = By.xpath("//XCUIElementTypeOther[contains(@value,'‎goodhealthgateway.com')]");

    public void verifyGoodHealthGateWaywebSite(String GoodhealthgatewayComSecureAndValidatedText) throws InterruptedException, IOException, FilloException {


        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("LoginScreen", "ForgetPassword"),
                "ForgotPassword");

        String strAct_goodHealthGateWayText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_goodHealthGateWayText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "goodHealthGateway"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_goodHealthGateWayText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "goodHealthGateway"), "goodHealthGateway");
        }

        System.out.println("strAct_goodHealthGateWayText..." + strAct_goodHealthGateWayText);
        String expectedgoodHealthGateWayText = GoodhealthgatewayComSecureAndValidatedText;
        System.out.println("expectedgoodHealthGateWayText..." + expectedgoodHealthGateWayText);
        Assert.assertEquals(strAct_goodHealthGateWayText.contains(expectedgoodHealthGateWayText), true);
        ReportManager.logScreenshotInfo();
        ReportManager.logPass("<b style=\"color:green;\">" + "Successfully Validated Forget Password" + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated goodHealthGateWay Url===============" + "</b>");

    }
}
