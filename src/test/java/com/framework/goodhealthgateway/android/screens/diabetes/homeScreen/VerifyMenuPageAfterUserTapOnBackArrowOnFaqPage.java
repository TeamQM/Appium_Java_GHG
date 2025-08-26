package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import java.io.IOException;


import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;


public class VerifyMenuPageAfterUserTapOnBackArrowOnFaqPage {
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


    public void isMenuPageDisplayedAfterUserTapOnBackArrowOnFaqPage(String UserName, String Password, String FAQText, String MenuText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Menu Screen Validation ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        CommonHelper.menuPageFlow();
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FAQs_btn"), "FAQs");
        String StrAct_FaqsText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_FaqsText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FAQs_text"), "content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_FaqsText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "FAQs"), "name");

        }
        String StrExp_FaqsText = FAQText;
        mobileActions.verifyText(StrAct_FaqsText, StrExp_FaqsText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackButton"), "BackButton");
        String StrAct_menuText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {

            StrAct_menuText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_menuText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "content-desc");

        }
            String StrExp_MenuText = MenuText;
        mobileActions.verifyText(StrAct_menuText, StrExp_MenuText);
        ReportManager.logScreenshotInfo();
        ReportManager.logPass("<b style=\"color:green;\">" + "Successfully redirected to Menu screen" + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated menu screen ===============" + "</b>");


    }
}
