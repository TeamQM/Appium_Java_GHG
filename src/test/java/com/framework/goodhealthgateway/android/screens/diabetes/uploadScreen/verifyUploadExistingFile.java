package com.framework.goodhealthgateway.android.screens.diabetes.uploadScreen;

import com.codoid.products.exception.FilloException;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.MobileUtil;
import com.framework.goodhealthgateway.android.screens.CommonHelper;
import com.framework.goodhealthgateway.android.Actions.MobileActions;
import com.framework.goodhealthgateway.drivermanager.DriverFactory;

import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;

import java.io.IOException;

public class verifyUploadExistingFile {

    MobileActions mobileActions = new MobileActions();
    CommonHelper CommonHelper = new CommonHelper();

    /**
     * This method is to login on GHG application Ø
     *
     * @param UserName
     * @throws InterruptedException
     * @throws IOException
     * @throws FilloException
     */

    public void isUserAbleToUploadExistingLessThanOrEqualsTwentyMBSizePDFFile(String UserName, String Password, String WelcomeBackText, String UploadProviderFormText, String FileshouldbeJPGPNGorPDFText, String UploadStatusText, String ProviderFormuploadedsuccessfullyText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Upload Existing File Validation ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        String StrAct_WelcomeBackText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_WelcomeBackText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_WelcomeBackText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
        }
        String StrExp_WelcomeBackText = WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "Upload"), "Upload");
        String strAct_UploadProviderForm = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_UploadProviderForm = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_UploadProviderForm = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "uploadProviderform");
        }
        String strExp_UploadProviderForm = UploadProviderFormText;
        mobileActions.verifyText(strAct_UploadProviderForm, strExp_UploadProviderForm);

        String strAct_acceptableFileType = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_acceptableFileType = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_acceptableFileType = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "acceptableFileType");
        }
        String ExpectedacceptableFileTypeText = FileshouldbeJPGPNGorPDFText;
        mobileActions.verifyText(strAct_acceptableFileType, ExpectedacceptableFileTypeText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadAnExistingFile"), "UploadAnExistingFile");
        Thread.sleep(2000);


        String strExp_FileName = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            if (mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"))) {
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"), "Allow");
            }
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Search"), "Search");
            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "SearchFileFormat"), ".pdf");

            mobileActions.hideKeyboard();
            strExp_FileName = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'.pdf')]")).getText();
            System.out.println(" strExp_FileName " + strExp_FileName);

            //  strExp_FileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileName_Text"), "Expected File Name");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strExp_FileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileName_Text"), "Expected File Name");
        }
        if (Constants.platformName.equalsIgnoreCase("android")) {
            DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("(//android.widget.ImageView[@index='0'])[5]")).click();
            // mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileName_Text"), "File Name");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileName_Text"), "fileToUpload");
        }
        String strAct_FileName = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_FileName = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadNameDisplayed"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_FileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadNameDisplayed"), "Actual File Name");
        }
        System.out.println("Verifying text");
        mobileActions.verifyText(strAct_FileName, strExp_FileName);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadBtn"), "UploadBtn");
        String strAct_UploadstatusText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_UploadstatusText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_UploadstatusText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "name");
        }
        String strExp_UploadstatusText = UploadStatusText;
        mobileActions.verifyText(strAct_UploadstatusText, strExp_UploadstatusText);

        String strAct_fileUploadSuccessText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_fileUploadSuccessText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProviderFormUploadedSuccessfully"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_fileUploadSuccessText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProviderFormUploadedSuccessfully"), "ProviderFormUploadedSuccessfully");
        }
        String strExp_fileUploadSuccessText = ProviderFormuploadedsuccessfullyText;
        mobileActions.verifyText(strAct_fileUploadSuccessText, strExp_fileUploadSuccessText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "okBtn"), "okBtn");
        ReportManager.logScreenshotInfo();
        ReportManager.logPass("<b style=\"color:green;\">" + "Successfully uploaded existing file" + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated uploaded existing file status===============" + "</b>");


    }


    public void isUserAbleToUploadExistingJPGFile(String UserName, String Password, String WelcomeBackText, String UploadProviderFormText, String FileshouldbeJPGPNGorPDFText, String UploadStatusText, String ProviderFormuploadedsuccessfullyText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Upload Existing File Validation ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        String StrAct_WelcomeBackText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_WelcomeBackText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_WelcomeBackText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
        }
        String StrExp_WelcomeBackText = WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "Upload"), "Upload");
        String strAct_UploadProviderForm = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_UploadProviderForm = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_UploadProviderForm = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "uploadProviderform");
        }
        String strExp_UploadProviderForm = UploadProviderFormText;
        mobileActions.verifyText(strAct_UploadProviderForm, strExp_UploadProviderForm);

        String strAct_acceptableFileType = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_acceptableFileType = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_acceptableFileType = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "acceptableFileType");
        }
        String ExpectedacceptableFileTypeText = FileshouldbeJPGPNGorPDFText;
        mobileActions.verifyText(strAct_acceptableFileType, ExpectedacceptableFileTypeText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadAnExistingFile"), "UploadAnExistingFile");
        Thread.sleep(2000);


        String strExp_FileName = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            if (mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"))) {
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"), "Allow");
            }
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Search"), "Search");
            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "SearchFileFormat"), ".jpg");


            strExp_FileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileNameJPG_Text"), "Expected File Name");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strExp_FileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileNameJPG_Text"), "Expected File Name");
        }
        if (Constants.platformName.equalsIgnoreCase("android")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileNameJPG_Text"), "File Name");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileNameJPG_Text"), "fileToUpload");
        }
        String strAct_FileName = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_FileName = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadNameDisplayed"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_FileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadNameDisplayed"), "Actual File Name");
        }
        mobileActions.verifyText(strAct_FileName, strExp_FileName);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadBtn"), "UploadBtn");
        String strAct_UploadstatusText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_UploadstatusText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_UploadstatusText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "name");
        }
        String strExp_UploadstatusText = UploadStatusText;
        mobileActions.verifyText(strAct_UploadstatusText, strExp_UploadstatusText);

        String strAct_fileUploadSuccessText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_fileUploadSuccessText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProviderFormUploadedSuccessfully"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_fileUploadSuccessText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProviderFormUploadedSuccessfully"), "ProviderFormUploadedSuccessfully");
        }
        String strExp_fileUploadSuccessText = ProviderFormuploadedsuccessfullyText;
        mobileActions.verifyText(strAct_fileUploadSuccessText, strExp_fileUploadSuccessText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "okBtn"), "okBtn");
        ReportManager.logScreenshotInfo();
        ReportManager.logPass("<b style=\"color:green;\">" + "Successfully uploaded existing file" + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated uploaded existing file status===============" + "</b>");


    }

    public void isUserAbleToUploadExistingPNGFile(String UserName, String Password, String WelcomeBackText, String UploadProviderFormText, String FileshouldbeJPGPNGorPDFText, String UploadStatusText, String ProviderFormuploadedsuccessfullyText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Upload Existing File Validation ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        String StrAct_WelcomeBackText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_WelcomeBackText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_WelcomeBackText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
        }
        String StrExp_WelcomeBackText = WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "Upload"), "Upload");
        String strAct_UploadProviderForm = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_UploadProviderForm = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_UploadProviderForm = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "uploadProviderform");
        }
        String strExp_UploadProviderForm = UploadProviderFormText;
        mobileActions.verifyText(strAct_UploadProviderForm, strExp_UploadProviderForm);

        String strAct_acceptableFileType = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_acceptableFileType = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_acceptableFileType = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "acceptableFileType");
        }
        String ExpectedacceptableFileTypeText = FileshouldbeJPGPNGorPDFText;
        mobileActions.verifyText(strAct_acceptableFileType, ExpectedacceptableFileTypeText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadAnExistingFile"), "UploadAnExistingFile");
        Thread.sleep(2000);


        String strExp_FileName = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            if (mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"))) {
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"), "Allow");
            }
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Search"), "Search");
            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "SearchFileFormat"), ".png");

            Thread.sleep(5000);
            mobileActions.hideKeyboard();
            strExp_FileName = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.widget.TextView[contains(@text,'.png')]")).getText();
            System.out.println("strExp_FileName.."+strExp_FileName);
            // strExp_FileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileNamePNG_Text"), "Expected File Name");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strExp_FileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileNamePNG_Text"), "Expected File Name");
        }
        if (Constants.platformName.equalsIgnoreCase("android")) {
            DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("(//android.widget.ImageView[@index='0'])[5]")).click();
            //   mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileNamePNG_Text"), "File Name");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "fileNamePNG_Text"), "fileToUpload");
        }
        String strAct_FileName = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_FileName = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadNameDisplayed"), "content-desc");
            System.out.println("strAct_FileName......"+strAct_FileName);

        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_FileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadNameDisplayed"), "Actual File Name");
        }
        mobileActions.verifyText(strAct_FileName, strExp_FileName);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadBtn"), "UploadBtn");
        String strAct_UploadstatusText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_UploadstatusText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_UploadstatusText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "name");
        }
        String strExp_UploadstatusText = UploadStatusText;
        mobileActions.verifyText(strAct_UploadstatusText, strExp_UploadstatusText);

        String strAct_fileUploadSuccessText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_fileUploadSuccessText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProviderFormUploadedSuccessfully"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_fileUploadSuccessText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "ProviderFormUploadedSuccessfully"), "ProviderFormUploadedSuccessfully");
        }
        String strExp_fileUploadSuccessText = ProviderFormuploadedsuccessfullyText;
        mobileActions.verifyText(strAct_fileUploadSuccessText, strExp_fileUploadSuccessText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "okBtn"), "okBtn");
        ReportManager.logScreenshotInfo();
        ReportManager.logPass("<b style=\"color:green;\">" + "Successfully uploaded existing file" + "</b>");
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated uploaded existing file status===============" + "</b>");


    }


    public void isUserAbleToUploadExistingDOCFile(String UserName, String Password, String WelcomeBackText, String UploadProviderFormText, String FileshouldbeJPGPNGorPDFText, String UploadStatusText, String ProviderFormuploadedsuccessfullyText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Upload Existing File with doc, xlsx, csv and txt format ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        String StrAct_WelcomeBackText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_WelcomeBackText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_WelcomeBackText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
        }
        String StrExp_WelcomeBackText = WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "Upload"), "Upload");
        String strAct_UploadProviderForm = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_UploadProviderForm = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_UploadProviderForm = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "uploadProviderform");
        }
        String strExp_UploadProviderForm = UploadProviderFormText;
        mobileActions.verifyText(strAct_UploadProviderForm, strExp_UploadProviderForm);

        String strAct_acceptableFileType = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_acceptableFileType = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_acceptableFileType = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "acceptableFileType");
        }
        String ExpectedacceptableFileTypeText = FileshouldbeJPGPNGorPDFText;
        mobileActions.verifyText(strAct_acceptableFileType, ExpectedacceptableFileTypeText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadAnExistingFile"), "UploadAnExistingFile");
        Thread.sleep(2000);


        String strExp_FileName = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            if (mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"))) {
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"), "Allow");
            }


            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Search"), "Search");


            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "SearchFileFormat"), ".doc");
            mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadDoc"), "Upload Document");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrow"), "BackArrow");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Search"), "Search");
            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "SearchFileFormat"), ".csv");
            mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadDoc"), "Upload Document");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrow"), "BackArrow");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Search"), "Search");
            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "SearchFileFormat"), ".xlsx");
            mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadDoc"), "Upload Document");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "BackArrow"), "BackArrow");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Search"), "Search");
            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "SearchFileFormat"), ".txt");
            mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadDoc"), "Upload Document");
            ReportManager.logScreenshotInfo();
            ReportManager.logPass("<b style=\"color:green;\">" + "Successfully validated Document is not selectable" + "</b>");
            ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated Document is not selectable===============" + "</b>");


        }
    }


    public void isUserAbleToUploadMaxSizeFiles(String UserName, String Password, String WelcomeBackText, String UploadProviderFormText, String FileshouldbeJPGPNGorPDFText, String UploadStatusText, String UploadStatusWarningText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Upload Existing File with Greater Than 20 MB size and Validate error message ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        String StrAct_WelcomeBackText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_WelcomeBackText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_WelcomeBackText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
        }
        String StrExp_WelcomeBackText = WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "Upload"), "Upload");
        String strAct_UploadProviderForm = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_UploadProviderForm = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_UploadProviderForm = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "uploadProviderform");
        }
        String strExp_UploadProviderForm = UploadProviderFormText;
        mobileActions.verifyText(strAct_UploadProviderForm, strExp_UploadProviderForm);

        String strAct_acceptableFileType = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_acceptableFileType = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_acceptableFileType = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "acceptableFileType");
        }
        String ExpectedacceptableFileTypeText = FileshouldbeJPGPNGorPDFText;
        mobileActions.verifyText(strAct_acceptableFileType, ExpectedacceptableFileTypeText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadAnExistingFile"), "UploadAnExistingFile");
        Thread.sleep(2000);


        String strExp_FileName = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            if (mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"))) {
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"), "Allow");
            }


            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Search"), "Search");


            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "SearchFileFormat"), ".pdf");
            if (Constants.platformName.equalsIgnoreCase("android")) {
                mobileActions.enterKeyboard(AndroidKey.ENTER);
                mobileActions.swipeUp(6);
                Thread.sleep(2000);
            }
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "FileGreaterthan20MB"), "FileGreaterthan20MB");
            String strAct_UploadstatusText = null;
            if (Constants.platformName.equalsIgnoreCase("android")) {
                strAct_UploadstatusText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "content-desc");
            } else if (Constants.platformName.equalsIgnoreCase("ios")) {
                strAct_UploadstatusText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "name");
            }
            String strExp_UploadstatusText = UploadStatusText;
            mobileActions.verifyText(strAct_UploadstatusText, strExp_UploadstatusText);

            String strAct_UploadstatusWarningText = null;
            if (Constants.platformName.equalsIgnoreCase("android")) {
                strAct_UploadstatusWarningText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "WarningMessage"), "content-desc");
            } else if (Constants.platformName.equalsIgnoreCase("ios")) {
                strAct_UploadstatusWarningText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "WarningMessage"), "name");
            }
            String strExp_UploadstatusWarningText = UploadStatusWarningText;
            mobileActions.verifyText(strAct_UploadstatusWarningText, strExp_UploadstatusWarningText);


            ReportManager.logScreenshotInfo();
            ReportManager.logPass("<b style=\"color:green;\">" + "Successfully validated error message" + "</b>");
            ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated error message===============" + "</b>");


        }
    }


    public void isUserAbleToUploadLessThanOrEqualsTwentyMBSizeFiles(String UserName, String Password, String WelcomeBackText, String UploadProviderFormText, String FileshouldbeJPGPNGorPDFText, String UploadStatusText, String UploadStatusWarningText)
            throws InterruptedException, IOException, FilloException {
        ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Upload Existing File Validation ===============" + "</b>");
        CommonHelper.loginWithValidUserNameAndPwd(UserName, Password);
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "CloseBtn"), "Close");
        String StrAct_WelcomeBackText = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            StrAct_WelcomeBackText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            StrAct_WelcomeBackText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "WelcomeBackText"), "name");
        }
        String StrExp_WelcomeBackText = WelcomeBackText;
        mobileActions.verifyText(StrAct_WelcomeBackText, StrExp_WelcomeBackText);

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "Upload"), "Upload");
        String strAct_UploadProviderForm = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_UploadProviderForm = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_UploadProviderForm = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadProviderForm"), "uploadProviderform");
        }
        String strExp_UploadProviderForm = UploadProviderFormText;
        mobileActions.verifyText(strAct_UploadProviderForm, strExp_UploadProviderForm);

        String strAct_acceptableFileType = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            strAct_acceptableFileType = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "content-desc");
        } else if (Constants.platformName.equalsIgnoreCase("ios")) {
            strAct_acceptableFileType = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "acceptableFileType"), "acceptableFileType");
        }
        String ExpectedacceptableFileTypeText = FileshouldbeJPGPNGorPDFText;
        mobileActions.verifyText(strAct_acceptableFileType, ExpectedacceptableFileTypeText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "UploadAnExistingFile"), "UploadAnExistingFile");
        Thread.sleep(2000);


        String strExp_FileName = null;
        if (Constants.platformName.equalsIgnoreCase("android")) {
            if (mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"))) {
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "allowBtn"), "Allow");
            }


            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "Search"), "Search");


            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "SearchFileFormat"), ".pdf");
            mobileActions.enterKeyboard(AndroidKey.ENTER);
            mobileActions.swipeUp(6);
            Thread.sleep(2000);
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "FileGreaterthan20MB"), "FileGreaterthan20MB");
            String strAct_UploadstatusText = null;
            if (Constants.platformName.equalsIgnoreCase("android")) {
                strAct_UploadstatusText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "content-desc");
            } else if (Constants.platformName.equalsIgnoreCase("ios")) {
                strAct_UploadstatusText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "name");
            }
            String strExp_UploadstatusText = UploadStatusText;
            mobileActions.verifyText(strAct_UploadstatusText, strExp_UploadstatusText);

            String strAct_UploadstatusWarningText = null;
            if (Constants.platformName.equalsIgnoreCase("android")) {
                strAct_UploadstatusWarningText = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "WarningMessage"), "content-desc");
            } else if (Constants.platformName.equalsIgnoreCase("ios")) {
                strAct_UploadstatusWarningText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UploadScreen", "uploadstatusText"), "name");
            }
            String strExp_UploadstatusWarningText = UploadStatusWarningText;
            mobileActions.verifyText(strAct_UploadstatusWarningText, strExp_UploadstatusWarningText);


            ReportManager.logScreenshotInfo();
            ReportManager.logPass("<b style=\"color:green;\">" + "Successfully uploaded existing file" + "</b>");
            ReportManager.logInfo("<b style=\"color:blue;\">" + "====================Successfully validated uploaded existing file status===============" + "</b>");


        }
    }
}
