package com.framework.goodhealthgateway.android.screens.diabetes.editProfileScreen;
import java.io.IOException;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

public class VerifyRedirectConfirmationPopUp {
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
	public void isRedirectConfirmationPopupPopulated(String UserName, String Password, String RedirectConfirmationText, String EditProfileDescriptionText)
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Redirect Confirmation PopUp Validation ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		CommonHelper.menuPageFlow();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "editProfile"), "editProfile");
		String StrAct_RedirectConfirmation =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_RedirectConfirmation=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "redirectConfirmation"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_RedirectConfirmation=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "redirectConfirmation"), "name");
		}
		String StrExp_RedirectConfirmation =RedirectConfirmationText;
		mobileActions.verifyText(StrAct_RedirectConfirmation, StrExp_RedirectConfirmation);
		String StrAct_RedirecConfirmationText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_RedirecConfirmationText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "toEdit"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_RedirecConfirmationText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "toEdit"), "name");
		}
		String StrExp_RedirecConfirmationText = EditProfileDescriptionText;
		mobileActions.verifyText(StrAct_RedirecConfirmationText, StrExp_RedirecConfirmationText);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully Redirect Confirmation PopUP Populated" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Redirect Confirmation PopUP===============" + "</b>");
	}

	public void isUserNavigatedMenuPageAfterClickingCancelOnRedirecConfirmation(String UserName, String Password, String RedirectConfirmationText, String EditProfileDescriptionText, String MenuText)
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Cancel Redirect Confirmation PopUp and Validation for Menu Screen ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		Thread.sleep(500);
		CommonHelper.menuPageFlow();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "editProfile"), "editProfile");
		String StrAct_RedirectConfirmation = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_RedirectConfirmation=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "redirectConfirmation"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_RedirectConfirmation=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "redirectConfirmation"), "name");
		}
		String StrExp_RedirectConfirmation =RedirectConfirmationText;
		mobileActions.verifyText(StrAct_RedirectConfirmation, StrExp_RedirectConfirmation);

		String StrAct_RedirecConfirmationText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_RedirecConfirmationText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "toEdit"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_RedirecConfirmationText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "toEdit"), "name");
		}
		String StrExp_RedirecConfirmationText =EditProfileDescriptionText;
		mobileActions.verifyText(StrAct_RedirecConfirmationText, StrExp_RedirecConfirmationText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Cancel"), "Cancel");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "Menu");

		String StrAct_Menu = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_Menu=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_Menu=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "name");
		}
		String StrExp_Menu = MenuText;
		mobileActions.verifyText(StrAct_Menu, StrExp_Menu);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + "Successfully User Navigated to Menu Screen" + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Menu Screen after clicking on cancel button on redirect confirmation popUP===============" + "</b>");
}
	
	public void isUserNavigatedMenuPageAndVerifyMenuPageAfterClickingDoneBtn(String UserName, String Password, String RedirectConfirmationText, String EditProfileDescriptionText, String MenuText)
			throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "==================== Validation for Menu Screen ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		CommonHelper.menuPageFlow();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "editProfile"), "editProfile");
		String StrAct_RedirectConfirmation =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_RedirectConfirmation=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "redirectConfirmation"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_RedirectConfirmation=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "redirectConfirmation"), "name");
		}
		String StrExp_RedirectConfirmation = RedirectConfirmationText;
		mobileActions.verifyText(StrAct_RedirectConfirmation, StrExp_RedirectConfirmation);

		String StrAct_RedirecConfirmationText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_RedirecConfirmationText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "toEdit"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_RedirecConfirmationText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "toEdit"), "name");
		}
		String StrExp_RedirecConfirmationText =EditProfileDescriptionText;
		mobileActions.verifyText(StrAct_RedirecConfirmationText, StrExp_RedirecConfirmationText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Continue"), "Continue");

		Thread.sleep(2000);
		if (Constants.platformName.equalsIgnoreCase("android")) {
			mobileActions.backButton();
		}
		else if (Constants.platformName.equalsIgnoreCase("ios")) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "DoneButton"), "DoneButton");
		}
		String StrAct_Menu = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_Menu=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_Menu=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Menutext"), "name");
		}
		String StrExp_Menu = MenuText;
		mobileActions.verifyText(StrAct_Menu, StrExp_Menu);
		ReportManager.logInfo("Successfully Verified" + "<b style=\"color:green;\"> : " + StrAct_Menu + "</b>");
		System.out.println("Successfully Verified :-" + StrAct_Menu);
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + " Successfully User Navigated to Menu Screen " + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Successfully validated Menu Screen after clicking on Done button  ===============" + "</b>");
}

	public void loginWithValidUserNameAndPwd(String UserName, String Password)
			throws InterruptedException, IOException, FilloException {
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		CommonHelper.menuPageFlow();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "editProfile"), "editProfile");
		String RedirectConfirmation = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			RedirectConfirmation=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "redirectConfirmation"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			RedirectConfirmation=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "redirectConfirmation"), "name");
		}
		String ExpectedRc = "Redirect Confirmation";
		mobileActions.verifyText(RedirectConfirmation, ExpectedRc);

		String RedirecConfirmationText =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			RedirecConfirmationText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "toEdit"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			RedirecConfirmationText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "toEdit"), "name");
		}
		String ExpectedRcText = "To edit your profile, you will be redirected to www.GoodHealthGateway.com. Please click “Continue” to proceed. ";
		mobileActions.verifyText(RedirecConfirmationText, ExpectedRcText);
		String RedirectConfirmationCancelBtn =null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			RedirectConfirmationCancelBtn=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Cancel"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			RedirectConfirmationCancelBtn=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Cancel"), "name");
		}
		String ExpectedCancelText = "Cancel";
		mobileActions.verifyText(RedirectConfirmationCancelBtn, ExpectedCancelText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Continue"), "Continue");
		String goodHealthGateWayText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			goodHealthGateWayText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "goodHealthGateWay"), "Good Health GateWay");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			goodHealthGateWayText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "goodHealthGateWay"), "value");
		}
		String expectedgoodHealthGateWayText = goodHealthGateWayText;
		mobileActions.verifyText(goodHealthGateWayText, expectedgoodHealthGateWayText);
		ReportManager.logScreenshotInfo();
	}

}
