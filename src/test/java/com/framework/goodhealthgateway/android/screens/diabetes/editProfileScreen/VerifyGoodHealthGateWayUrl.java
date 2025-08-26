package com.framework.goodhealthgateway.android.screens.diabetes.editProfileScreen;

import java.io.IOException;

import org.testng.Assert;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;


public class VerifyGoodHealthGateWayUrl {


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
	public void isUserNavigatedToGoodHealthGateWayUrl(String UserName, String Password, String RedirectConfirmationText, String EditProfileDescriptionText, String GoodHealthGateWayText)

	throws InterruptedException, IOException, FilloException {
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Redirect To Good Health Gate Way Url Validation  ===============" + "</b>");
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
		CommonHelper.menuPageFlow();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "editProfile"), "editProfile");
		String StrAct_RedirectConfirmation = null ;
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
		String StrExp_RedirecConfirmationText = EditProfileDescriptionText;
		mobileActions.verifyText(StrAct_RedirecConfirmationText, StrExp_RedirecConfirmationText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Continue"), "Continue");
		String StrAct_GoodHealthGateWayText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			StrAct_GoodHealthGateWayText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "goodHealthGateWay"), "value");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			StrAct_GoodHealthGateWayText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "goodHealthGateWay"), "value");
		}
		Assert.assertEquals(StrAct_GoodHealthGateWayText.contains("goodhealthgateway"),true );
		ReportManager.logScreenshotInfo();
		ReportManager.logPass("<b style=\"color:green;\">" + " Successfully Redirected To Good Health Gate Way Url " + "</b>");
		ReportManager.logInfo("<b style=\"color:blue;\">" + "====================  Successfully validated Good Health Gate Way Url  ===============" + "</b>");
	}

}
