package com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

public class  VerifyListedDocumentInDownloadDocumentsScreen {
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



    public void isListedDocumentsDisplayedOnDownloadDocumentsScreen(String UserName, String Password, String DownloadDocumentsText, String PCFText, String PrintableRxRewardsText, String DiabetesHealthActionPlanText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Listed Documents Validation on Download Documents Screen  ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        CommonHelper.documentFlow();
        Thread.sleep(5000);
        String DownDocPage = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            DownDocPage = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
            DownDocPage = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DownloadDocumnent"), "name");
        }
        String expectedDaText = DownloadDocumentsText;
        mobileActions.verifyText(DownDocPage, expectedDaText);
        String StrAct_PCFText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_PCFText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "PCFDocument"), "content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_PCFText = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeOther[contains(@name,'PCF')]")).getAttribute("name");

        }
        Assert.assertEquals(StrAct_PCFText.contains(PCFText), true);
        String RxRewardCards = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            RxRewardCards = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "RXRewardCards"), "content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
            RxRewardCards = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("(//XCUIElementTypeOther[contains(@name,'Rx Rewards Card')])[1]")).getAttribute("name");
        }
        String expectedRxRewardCards = RxRewardCards;
        mobileActions.verifyText(RxRewardCards, expectedRxRewardCards);

        String StrAct_PrintableRXRewards = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_PrintableRXRewards = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "PrintableRXRewardCards"), "content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_PrintableRXRewards = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeOther[contains(@name,'Printable Rx Rewards')]")).getAttribute("name");
        }
        System.out.println("StrAct_PrintableRXRewards...  " + StrAct_PrintableRXRewards);
		Assert.assertEquals(StrAct_PrintableRXRewards.contains(PrintableRxRewardsText),true );

        String StrAct_DiabetesHealthActionPlan = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_DiabetesHealthActionPlan = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DibetesHealthActionPlan"), "content-desc");
        }
        else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_DiabetesHealthActionPlan = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeOther[contains(@name,'Diabetes Health Action Plan')]")).getAttribute("name");
        }

		Assert.assertEquals(StrAct_DiabetesHealthActionPlan.contains(DiabetesHealthActionPlanText),true );
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + " Successfully listed documents are displayed on Download Documents screen " + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Successfully Validated listed documents are displayed on Download Documents screen  ===============" + "</b>");

    }
}
