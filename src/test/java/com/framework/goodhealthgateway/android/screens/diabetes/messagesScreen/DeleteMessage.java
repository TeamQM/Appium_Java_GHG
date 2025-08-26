package com.framework.goodhealthgateway.android.screens.diabetes.messagesScreen;

import java.io.IOException;


import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

public class DeleteMessage {

	MobileActions mobileActions = new MobileActions();
	CommonHelper CommonHelper = new CommonHelper();
	public void loginWithValidUserNameAndPwd(String UserName, String Password)
			throws InterruptedException, IOException, FilloException {
		CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Close"), "Close");

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "Messages"), "Messages");

		String inboxText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "Inbox"), "name");
		String expectedinboxText = inboxText;
		mobileActions.verifyText(inboxText, expectedinboxText);



		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "MessageText"), "MessageText");

		String DeleteThisMsgText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "DeleteThisMessage"), "DeleteThisMessageText");
		String expectedDeleteThisMsgText = DeleteThisMsgText;
		mobileActions.verifyText(DeleteThisMsgText, expectedDeleteThisMsgText);

	}
}
