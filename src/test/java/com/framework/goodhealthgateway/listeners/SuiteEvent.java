package com.framework.goodhealthgateway.listeners;

import java.util.ArrayList;
import java.util.List;

import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.TestListenerAdapter;

import com.framework.goodhealthgateway.utilities.ConfigReader;
import com.framework.goodhealthgateway.utilities.Constants;
import com.framework.goodhealthgateway.utilities.ReportManager;
import com.opencsv.CSVWriter;

import lombok.SneakyThrows;

public class SuiteEvent extends TestListenerAdapter implements ISuiteListener, IExecutionListener, IReporter {
	CSVWriter writer;
	public List<String[]> data = new ArrayList<String[]>();

	@Override
	public void onFinish(ISuite arg0) {
//		try {
//			//sendReportByOutlook();
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
	}

	@Override
	public void onStart(ISuite arg0) {

	}

	@Override
	public void onExecutionStart() {
		if(System.getProperty("platform")!=null) {
			Constants.platformName =  System.getProperty("platform");
		}else {
			Constants.platformName =  ConfigReader.getValue("platFormName");
		}
		String suite = System.getProperty("suite","Default suite picked");
		System.out.println("Going to start suite: "+ suite);
		ReportManager.startReportMobile();

	}

	@SneakyThrows
	@Override
	public void onExecutionFinish() {
//        try {
//            //TestCaseResult.saveToExcel();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InvalidFormatException e) {
//            throw new RuntimeException(e);
//        }
        ReportManager.endReportMobile();
		

	}

}
