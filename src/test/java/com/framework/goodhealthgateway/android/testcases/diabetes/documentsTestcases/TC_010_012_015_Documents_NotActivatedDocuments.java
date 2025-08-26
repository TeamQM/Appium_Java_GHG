package com.framework.goodhealthgateway.android.testcases.diabetes.documentsTestcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.android.screens.diabetes.documentsScreen.VerifyNotActivatedDocuments;
import com.framework.goodhealthgateway.listeners.MobileEvent;
import com.framework.goodhealthgateway.listeners.SuiteEvent;
import com.framework.goodhealthgateway.utilities.ExcelDataReader;
@Listeners({ SuiteEvent.class, MobileEvent.class })

public class TC_010_012_015_Documents_NotActivatedDocuments {
    @Test
    public void verifyNotActivatedDocuments() throws IOException, InterruptedException, FilloException {
        VerifyNotActivatedDocuments verifyNotActivatedDocuments = new VerifyNotActivatedDocuments();
        verifyNotActivatedDocuments.verifyNotActivatedDocuments(
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("UserName1"),
                ExcelDataReader.getLanguagesFromHomePage("LoginPage").get("Password"),
                ExcelDataReader.getLanguagesFromHomePage("DocumentPage").get("NoDHAPAvailableText"));
    }
}
