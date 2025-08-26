package com.framework.goodhealthgateway.android.screens.diabetes.messagesScreen;

import java.io.IOException;


import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;


public class VerifyInboxMessagePage {

    MobileActions mobileActions = new MobileActions();
    CommonHelper CommonHelper = new CommonHelper();

    public void verifyInboxPageMsgDisplayed(String UserName2, String Password, String  InboxText , String NoMessageText , String YouDoNotHaveAnyMessagesCurrentlyText)
            throws InterruptedException, IOException, FilloException {
        CommonHelper.loginWithValidUserNameAndPwd(UserName2, Password);
        Thread.sleep(500);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "Message"), "Messages");

        String strAct_InboxText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_InboxText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "Inbox"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_InboxText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "Inbox"), "Inbox");
        }
        String strExp_InboxText = InboxText;
        mobileActions.verifyText(strAct_InboxText, strExp_InboxText);

        ReportManager.logScreenshotInfo();

        String strAct_NomessageText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_NomessageText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "noMessage"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_NomessageText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "noMessage"), "noMessage");
		}
		String strExp_NomessageText = NoMessageText;
        mobileActions.verifyText(strAct_NomessageText, strExp_NomessageText);

        String strAct_MessageStatusText = null;
		if (Constants.platformName.equalsIgnoreCase("android")) {
			strAct_MessageStatusText=mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "messageStatus"), "content-desc");
		} else if (Constants.platformName.equalsIgnoreCase("ios")) {
			strAct_MessageStatusText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("MessageScreen", "messageStatus"), "messageStatus");
		}
		String strExp_MessageStatusText = YouDoNotHaveAnyMessagesCurrentlyText;
        mobileActions.verifyText(strAct_MessageStatusText, strExp_MessageStatusText);
    }
}
