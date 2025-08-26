package com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;


public class VerifyNotActivatedDocuments {
   CommonHelper CommonHelper = new CommonHelper();
    MobileActions mobileActions = new MobileActions();
    public void verifyNotActivatedDocuments(String UserName, String Password, String NoDHAPAvailableText) throws IOException, InterruptedException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Validate Not Activated Documents  ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        CommonHelper.documentFlow();
        Thread.sleep(5000);
        if (Constants.platformName.equalsIgnoreCase("android")) {
            Assert.assertFalse(DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("(//android.view.View[contains(@content-desc,'Rx Rewards Card')])[1]/..//android.widget.Button")).isEnabled());
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            Assert.assertFalse(DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeOther[contains(@name,'pharmacy')]/..//XCUIElementTypeButton")).isEnabled());
        }
        if (Constants.platformName.equalsIgnoreCase("android")) {
            Assert.assertFalse(DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("(//android.view.View[contains(@content-desc,'Rx Rewards Card')])[2]/..//android.widget.Button\n")).isEnabled());
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            Assert.assertFalse(DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeOther[contains(@name,'Printable')]/..//XCUIElementTypeButton")).isEnabled());
        }
        if (Constants.platformName.equalsIgnoreCase("android")) {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DiabetesHealthAction"),"Diabetes Health Action");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            mobileActions.clickUsingCoordinates(328, 580);
        }
        String strAct_OopsText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_OopsText=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "OopsText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_OopsText=  mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "OopsText"), "OopsText");
        }
        String strExp_OopsText = "Oops...";
        mobileActions.verifyText(strAct_OopsText,strExp_OopsText);
        String strAct_NoDhapAvailableText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_NoDhapAvailableText=  mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "NoDHAPAvailableText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_NoDhapAvailableText=  mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "NoDHAPAvailableText"), "NoDHAPAvailableText");
        }
        String strExp_NoDhapAvailableText = NoDHAPAvailableText;
        mobileActions.verifyText(strAct_NoDhapAvailableText,strExp_NoDhapAvailableText);
        ReportManager.logPass("<b style=\"color:green;\">" + " Successfully Validated Not Activated Documents " + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Successfully validated 'Oops...', ' message  ===============" + "</b>");

    }
}
