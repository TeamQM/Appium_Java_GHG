package com.framework.goodhealthgateway.android.testcases.diabetes.loginScreen;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.goodhealthgateway.android.screens.diabetes.loginScreen.VerifyGoodHealthGateWayUrl;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;


@Listeners({ SuiteEvent.class, MobileEvent.class })


public class TC_036_LoginPage_Verify_GoodHealthGateWay_Website {
	
	
	@Test(description = "[TC_LoginPage_036] verify GoodHealthGateWay website after user click on forget password link ",
            groups = {"regression", "registration_and_login"})
    public void verifyGoodHealthGateWayUrl() throws Exception {
        
		VerifyGoodHealthGateWayUrl verifyGoodHealthGateWayUrl = new VerifyGoodHealthGateWayUrl();
		
		verifyGoodHealthGateWayUrl.verifyGoodHealthGateWaywebSite(ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("GoodhealthgatewayComSecureAndValidatedText"));

	    
	}
	
}
