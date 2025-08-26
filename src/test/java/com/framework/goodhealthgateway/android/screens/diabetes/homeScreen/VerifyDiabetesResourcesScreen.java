package com.framework.goodhealthgateway.android.screens.diabetes.homeScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

public class VerifyDiabetesResourcesScreen {

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


	public void isDiabetesResourcesScreenDisplayedAndValidatedScreen(String UserName, String Password, String DiabetesResourcesText, String TheCentersForDiseaseControlPublicHealthResourceCenterText,
																	 String PhoneText, String TTYText, String EmailText, String VisitWebsiteText, String CDCWebsiteUrl, String MenuText)
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Diabetes Resources Screens Validation ===============" + "</b>");

		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		CommonHelper.menuPageFlow();

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DiabetesResources"), "DiabetesResources");

		String dResourcesText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			dResourcesText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "DiabetesResources_Text"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			dResourcesText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DiabetesResources_Text"), "DiabetesResources_Text");
		}
		String expecteddResourcesText = DiabetesResourcesText;
		mobileActions.verifyText(dResourcesText, expecteddResourcesText);

//====================Now Visible is set to false========================================
		String theCentersForDiseaseControlText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			theCentersForDiseaseControlText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "theCentersForDiseaseControlText"), "content-desc");;
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			theCentersForDiseaseControlText=DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'The Centers')]")).getText();
		}
		String expectedtheCentersForDiseaseControlText = TheCentersForDiseaseControlPublicHealthResourceCenterText;
		mobileActions.verifyText(theCentersForDiseaseControlText, expectedtheCentersForDiseaseControlText);
		String strAct_PhoneText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_PhoneText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "phoneText1"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_PhoneText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "phoneText1"), "PhoneText1");
		}
		String strExp_PhoneText = PhoneText;
		mobileActions.verifyText(strAct_PhoneText, strExp_PhoneText);
		String strExp_PhoneNumberText =null ;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strExp_PhoneNumberText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "phoneNumberText1"), "content-desc").substring(10,14);
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strExp_PhoneNumberText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "phoneNumberText1"), "PhoneNumberText1").substring(10,14);
		}
		String styrAct_TyyText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			styrAct_TyyText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "tyyText1"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			styrAct_TyyText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "tyyText1"), "TyyText");
		}
		String styrExp_TyyText =TTYText;
		mobileActions.verifyText(styrAct_TyyText, styrExp_TyyText);
		String strExp_TyyNumber =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strExp_TyyNumber=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "tyyNumber1"), "content-desc").substring(10,14);
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strExp_TyyNumber=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "tyyNumber1"), "TyyNumber").substring(10,14);
		}
		String strAct_EmailText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_EmailText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "email"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_EmailText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "email"), "email");
		}
		String strExp_EmailText = EmailText;
		mobileActions.verifyText(strAct_EmailText, strExp_EmailText);
		String strAct_VisitWebSite = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_VisitWebSite=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "visitWebSite"), "content-desc");
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_VisitWebSite=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "visitWebSite"), "visitWebSite");
		}
		String strExp_VisitWebSite = VisitWebsiteText;
		mobileActions.verifyText(strAct_VisitWebSite, strExp_VisitWebSite);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "phoneNumberText1"), "phoneNumber");
		String strAct_callNumberText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_callNumberText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "callNumber"), "callNumber").replace("Call 1", "").substring(7, 11);
			System.out.println("act   "+ strAct_callNumberText);

		}
				else if (Constants.platformName.equalsIgnoreCase("ios")) {
					strAct_callNumberText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "callNumber"), "callNumber").replace("Call 1", "").substring(8, 12);
		}
		mobileActions.verifyText(strAct_callNumberText, strExp_PhoneNumberText);
		if (Constants.platformName.equalsIgnoreCase("android")) {

			mobileActions.appSwitch();
			mobileActions.clickUsingCoordinates(506,824);
		//	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "GHG_App"), "GHG_App");
		}

		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(180, 750);		}

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "tyyNumber1"), "tyyNumber");
		String strAct_TyynumberText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_TyynumberText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "callNumber"), "callNumber").replace("Call 1", "").substring(7, 11);
			System.out.println("act   "+ strAct_callNumberText);

		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			 strAct_TyynumberText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "tyynumberText"), "tyynumberText").replace("Call 1","").substring(6,10);
		}
		mobileActions.verifyText(strAct_TyynumberText, strExp_TyyNumber);

		if (Constants.platformName.equalsIgnoreCase("android")) {

			mobileActions.appSwitch();
			mobileActions.clickUsingCoordinates(506,824);
			//mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "GHG_App"), "GHG_App");
		}

		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.clickUsingCoordinates(180, 750);
		}
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "visitWebSite"), "visitWebSite");
		String StrAct_CDCText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {

			StrAct_CDCText =mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CDCUrl"), "content-desc");;
			Assert.assertEquals(StrAct_CDCText.contains("Centers for Disease Control and Prevention. CDC twenty four seven. Saving Lives, Protecting People"),true );
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_CDCText= mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CDCUrl"), "CDCUrl");
			Assert.assertEquals(StrAct_CDCText.contains(CDCWebsiteUrl),true );
		}

		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.backButton();
		}

	 else if (Constants.platformName.equalsIgnoreCase("ios")) {
		 mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DoneButton"), "DoneButton");
		}
		//======================================
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackButton"), "BackButton");
		String StrAct_menuText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_menuText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_menuText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "name");
		}
		String StrExp_MenuText = MenuText;
		mobileActions.verifyText(StrAct_menuText, StrExp_MenuText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully  displayed Diabetes Resources screen" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Diabetes Resources screen, Phone number, TYY number, Visit Website, Email Id===============" + "</b>");

	}
}
