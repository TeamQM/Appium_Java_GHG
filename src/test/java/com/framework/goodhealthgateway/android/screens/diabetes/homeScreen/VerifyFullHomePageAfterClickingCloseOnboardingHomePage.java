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
import org.testng.Assert;

public class VerifyFullHomePageAfterClickingCloseOnboardingHomePage {
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
	public void isHomePageDisplayedAfterClickingOnCloseOnboardingHomePage(String UserName, String Password) throws InterruptedException, IOException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Home Screen Validation ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		Thread.sleep(5000);
		String StrAct_OnBoardingHomeText= DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Home')]")).getAttribute("name");
		Assert.assertEquals(StrAct_OnBoardingHomeText.contains("Home"),true );
		ReportManager.logInfo("Successfully Verified onboarding 'Home' page" + "<b style=\"color:green;\"> : "
				+ StrAct_OnBoardingHomeText + "</b>");
		System.out.println("Successfully  verified onboarding 'Home' page:-" + StrAct_OnBoardingHomeText);
		String StrAct_closeButtonText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"),"name");
		String StrExp_closeButtonText = "Close";
		mobileActions.verifyText(StrAct_closeButtonText,StrExp_closeButtonText);
		ReportManager.logInfo("Successfully Verified" + "<b style=\"color:green;\"> : " + StrAct_closeButtonText + "</b>");
		String closeButton = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"),"name");;
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
		ReportManager.logInfo("Successfully clicked on" + "<b style=\"color:green;\"> : " + closeButton + "</b>");
		System.out.println("Successfully clicked on :-" + closeButton);
		ReportManager.logInfo("Successfully element displayed" + "<b style=\"color:green;\"> : " + closeButton + "</b>");
		System.out.println("Successfully element displayed :-" + closeButton);
		String StrAct_WelcomeBackText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"),"name");
		String StrExp_WelcomeBackText = "Welcome back";
		mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);
		ReportManager.logInfo("Successfully Verified" + "<b style=\"color:green;\"> : " + StrAct_WelcomeBackText + "</b>");
		System.out.println("Successfully Verified :-" + StrAct_WelcomeBackText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully Home Screen Displayed" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Welcome back text on Home Screen===============" + "</b>");


	}
	}
