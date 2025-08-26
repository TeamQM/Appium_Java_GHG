package com.framework.goodhealthgateway.android.testcases.diabetes.editProfileTestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.editProfileScreen.VerifyGoodHealthGateWayUrl;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;


@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_003_005_034_EditProfile_Verify_GoodHealthGateWay_Url {

	@Test(dataProviderClass = ExcelDataReader.class,description = "[TC_EditProfile_003,TC_Home_034] verify www.GoodHealthGateway.com url after click continue redirect confirmation popup",
			groups = {"regression", "registration_and_login"})
    public void verifyGoodHealthGateWayUrl() throws Exception {
		VerifyGoodHealthGateWayUrl verifyGoodHealthGateWayUrl = new VerifyGoodHealthGateWayUrl();
		verifyGoodHealthGateWayUrl.isUserNavigatedToGoodHealthGateWayUrl(
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName"),
				ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("RedirectConfirmationText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("EditProfileDescriptionText"),
				ExcelDataReader.getLanguagesFromHomePage("HomePage").get("GoodHealthGateWayText"));
	}
	
}
