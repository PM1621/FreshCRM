package com.comcast.crm.baseTest;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.ObjectRepositoryUtility.HomePage;
import com.crm.ObjectRepositoryUtility.LoginPage;
import com.generic.DatabaseUtility.DatabaseUtility;
import com.generic.FileUtility.ExcelUtility;
import com.generic.FileUtility.FileUtility;
import com.generic.ListenerUtility.ListenerImp;
import com.generic.webdriverUtility.JavaUtility;
import com.generic.webdriverUtility.UtilityClassObject;
import com.generic.webdriverUtility.WebDriverUtility;

public class BaseClass {
	
	
	
	public DatabaseUtility databaselib=new DatabaseUtility();
	public FileUtility filelib=new FileUtility();
	public ExcelUtility excellib=new ExcelUtility();
	public JavaUtility javalib=new JavaUtility();
	public WebDriverUtility webdriverlib=new WebDriverUtility();
	
	
	
	public WebDriver driver;
	static public WebDriver sdriver;
	
	@BeforeSuite(groups= {"Smoke test","Regression test"})
	public void configBeforesuite()
	{
		
		System.out.println("==Connect to DataBase , Report Config==");
		
	}
	
	
	//@Parameters("Browser")
//	@BeforeClass(groups={"Smoke test","Regression test"})
	@BeforeClass
	public void configBeforeClass() throws IOException
	{
		
		System.out.println("==Launch the Browser==");
		
		String browser=filelib.getDataFromPropertyFile("browser");
		//String browser=Browser;
		
		if(browser.equalsIgnoreCase("chrome"))
	     {
	    	 driver=new ChromeDriver();
	    	 
	     }
	     else if(browser.equalsIgnoreCase("edge"))
	     {
	    	 driver=new EdgeDriver();
	    	 
	     }
	     else if(browser.equalsIgnoreCase("firefox"))
	     {
	    	 driver=new FirefoxDriver();
	     }
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		driver.manage().window().maximize();
	}

	//@BeforeMethod(groups={"Smoke test","Regression test"})
	@BeforeMethod
	public void configBeforeMethod() throws IOException
	{
		
		System.out.println("== Login ==");
		String url=filelib.getDataFromPropertyFile("url");
		String username=filelib.getDataFromPropertyFile("username");
		String password=filelib.getDataFromPropertyFile("password");
		LoginPage login=new LoginPage(driver);
		login.loginpage(url,username, password);
		 
		
		
	}
	
	@AfterMethod(groups={"Smoke test","Regression test"})
	public void configAfterMethod()
	{
		System.out.println("== Logout ==");
		
		HomePage homepage=new HomePage(driver);
		
		homepage.logout();
		
	}
	
	@AfterClass(groups={"Smoke test","Regression test"})
	public void configAfterClass()
	{
		System.out.println("== close Browser ==");
		
		driver.close();
	}
	
	@AfterSuite(groups={"Smoke test","Regression test"})
	public void configAfterSuite()
	{
		System.out.println("== close DB Connection,Report Config ==");
		
		
	}
}
