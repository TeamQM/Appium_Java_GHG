package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerifyOnboardingScreens {
    MobileActions mobileActions = new MobileActions();
    CommonHelper LoginGhgApp = new CommonHelper();

    /**
     * This method is to login on GHG application
     *
     * @param UserName
     * @param Password
     * @throws InterruptedException
     * @throws IOException
     */
    public void isOnboardingScreensDisplayed(String UserName, String Password, String OnBoardingHomeText, String OnBoardingCloseBtnText, String OnBoardingNextBtnText, String OnBoardingMessageText, String OnBoardingDocumentText, String WelcomeBackText) throws InterruptedException, IOException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Onboarding Home Screen Validation ===============" + "</b>");
        LoginGhgApp.loginWithValidUserNameAndPwd(UserName, Password);

        String StrAct_OnBoardingHomeText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {

            StrAct_OnBoardingHomeText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Home"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_OnBoardingHomeText = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Home')]")).getAttribute("name");
        }
        assertEquals(StrAct_OnBoardingHomeText.contains(OnBoardingHomeText), true);
        ReportManager.logInfo("Successfully Verified onboarding 'Home' page" + "<b style=\"color:green;\"> : "
                + StrAct_OnBoardingHomeText + "</b>");
        String StrAct_closeButtonText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {

			StrAct_closeButtonText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_closeButtonText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "name");

		}
		String StrExp_closeButtonText = OnBoardingCloseBtnText;
        mobileActions.verifyText(StrAct_closeButtonText, StrExp_closeButtonText);
        ReportManager.logInfo("Successfully Verified" + "<b style=\"color:green;\"> : " + StrAct_closeButtonText + "</b>");
        String StrAct_nextButtonText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_nextButtonText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Next"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_nextButtonText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Next"), "name");
		}
		String StrExp_nextButtonText = OnBoardingNextBtnText;
        mobileActions.verifyText(StrAct_nextButtonText, StrExp_nextButtonText);
        ReportManager.logInfo("Successfully Verified" + "<b style=\"color:green;\"> : " + StrAct_nextButtonText + "</b>");

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Next"), "Next");
        String StrAct_onBoardingMessageText =null;

		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_onBoardingMessageText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "onbordingMessageText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_onBoardingMessageText= DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Messages')]")).getAttribute("name");
		}

        Assert.assertEquals(StrAct_onBoardingMessageText.contains(OnBoardingMessageText), true);
        ReportManager.logInfo("Successfully Verified onboarding 'Message' page" + "<b style=\"color:green;\"> : "
                + StrAct_onBoardingMessageText + "</b>");
        WebElement ele_onBoardingMessageText=null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            ele_onBoardingMessageText = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.view.View[contains(@content-desc,'Messages')]"));
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
             ele_onBoardingMessageText = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Messages')]"));
        }
        System.out.println("Successfully  verified onboarding 'Messages' page:-" + StrAct_onBoardingMessageText);
        mobileActions.swipeLeftOrRight(ele_onBoardingMessageText ,"RIGHT");
        String StrAct_OnBoardingHomeText1=null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            Thread.sleep(1000);
            StrAct_OnBoardingHomeText1= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Home"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
             StrAct_OnBoardingHomeText1 = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Home')]")).getAttribute("name");
        }
        Assert.assertEquals(StrAct_OnBoardingHomeText1.contains(OnBoardingHomeText),true );
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Next"), "Next");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Next"), "Next");

        String StrAct_onBoardingDocumentText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_onBoardingDocumentText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("DocumentsScreen", "DocumentIcon"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			 StrAct_onBoardingDocumentText = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Documents')]")).getAttribute("name");

		}
		Assert.assertEquals(StrAct_onBoardingDocumentText.contains(OnBoardingDocumentText), true);
        ReportManager.logInfo("Successfully Verified onboarding 'Message' page" + "<b style=\"color:green;\"> : "
                + StrAct_onBoardingDocumentText + "</b>");
        System.out.println("Successfully  verified onboarding 'Messages' page:-" + StrAct_onBoardingDocumentText);

        WebElement ele_onBoardingDocumentText=null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            ele_onBoardingDocumentText = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.view.View[contains(@content-desc,'Documents')]"));
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
             ele_onBoardingDocumentText = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Documents')]"));
        }
        mobileActions.swipeLeftOrRight(ele_onBoardingDocumentText ,"RIGHT");
        String StrAct_onBoardingMessageText1=null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_onBoardingMessageText1= mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "onbordingMessageText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
             StrAct_onBoardingMessageText1 = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Messages')]")).getAttribute("name");
        }
        Assert.assertEquals(StrAct_onBoardingMessageText1.contains(OnBoardingMessageText),true );
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        String StrAct_WelcomeBackText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_WelcomeBackText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
		}
		String StrExp_WelcomeBackText =WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
        ReportManager.logInfo("Successfully Verified" + "<b style=\"color:green;\"> : " + StrAct_WelcomeBackText + "</b>");
        System.out.println("Successfully Verified :-" + StrAct_WelcomeBackText);
        ReportManager.logScreenshotInfo();
        ReportManager.logPass("<b style=\"color:green;\">" + "Successfully  Onboarding 'Home' page displayed" + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated 'Home', 'Messages', 'Document'  Screens and  Next, Cancel Buttons===============" + "</b>");
    }
}
