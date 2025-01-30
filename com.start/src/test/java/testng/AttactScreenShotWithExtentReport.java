package testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.comcast.crm.baseTest.BaseClass;

public class AttactScreenShotWithExtentReport extends BaseClass{
	
	public ExtentReports report=new ExtentReports();
	public ExtentSparkReporter spark;
	public ExtentTest test;
	@Test
	public void createContactTestWithORG()
	{
		
	   BaseClass.sdriver.get("http://localhost:8888");
	   
	   TakesScreenshot tscreen=(TakesScreenshot)BaseClass.sdriver;
	   String src=tscreen.getScreenshotAs(OutputType.BASE64);
		
		//Create test
		
		
		
		 test= report.createTest("Crete Contact Test");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact");
		test.log(Status.INFO,"Create contact");
		
		if("HDFC".equals("HDfFC"))
		{
			test.log(Status.PASS,"contact is created with org");
		}
		else
		{
			test.addScreenCaptureFromBase64String(src,"ErrorFile");
			
		}

}

}
