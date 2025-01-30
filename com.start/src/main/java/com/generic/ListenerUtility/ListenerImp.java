package com.generic.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseTest.BaseClass;
import com.generic.webdriverUtility.UtilityClassObject;
import com.google.common.io.Files;

public class ListenerImp implements ITestListener, ISuiteListener {

	public static ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;

	@Override
	public void onTestFailure(ITestResult res) {
		String testname = res.getMethod().getMethodName();

		TakesScreenshot tscreen = (TakesScreenshot) UtilityClassObject.getDriver();
		String src = tscreen.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		test.addScreenCaptureFromBase64String(src, testname + "_" + time);

		UtilityClassObject.getTest().log(Status.INFO,
				res.getMethod().getMethodName() + "<============ Failed =============> ");
	}

	@Override
	public void onStart(ISuite suiteInfo) {
		System.out.println("report backup");

		spark = new ExtentSparkReporter("./AdvanceReport/Report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("CRM Reports");

		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-11");
		report.setSystemInfo("BROWSER", "chrome-100");

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO,
				result.getMethod().getMethodName() + "==============> Test STARTED <===============");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		UtilityClassObject.getTest().log(Status.INFO,
				result.getMethod().getMethodName() + "==============> Test Completed Successfully <===============");

	}
}
