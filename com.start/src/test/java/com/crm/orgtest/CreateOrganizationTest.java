package com.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseTest.BaseClass;
import com.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.crm.ObjectRepositoryUtility.HomePage;
import com.crm.ObjectRepositoryUtility.OrganizationInformation;
import com.crm.ObjectRepositoryUtility.OrganizationPage;
import com.generic.ListenerUtility.ListenerImp;
import com.generic.webdriverUtility.UtilityClassObject;
@Listeners(ListenerImp.class)
public class CreateOrganizationTest extends BaseClass {

	
@Test(groups="Smoke test")
	public  void createOrganizationTest() throws IOException, InterruptedException {

		// step : navigate to organization module
         UtilityClassObject.getTest().log(Status.INFO,"Navigate to organization module");
		HomePage Hp = new HomePage(driver);
		Hp.getOrganizationlink().click();

		// step :click on create organization button
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to new organization module");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationbutton().click();

		// read excel file and generate random number
		
		int randomInt = javalib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO,"Read Data from excel file");
		String org = excellib.getDataFromExcel("org", 1, 2) + randomInt;

		// step 4:Enter all the detils&create new organization
		UtilityClassObject.getTest().log(Status.INFO,"Enter Data and Create organization");
		CreateNewOrganizationPage creatneworg = new CreateNewOrganizationPage(driver);
		creatneworg.createOrganization(org);

		Thread.sleep(2000);

		// verify header msg expected result
		OrganizationInformation orginfo = new OrganizationInformation(driver);
		String header_data = orginfo.getHeading().getText();

		if (header_data.contains(org)) {
			System.out.println("is pass");
		} else {
			System.out.println("fail");
		}

		// step 5 : logout

		Thread.sleep(2000);

	}

@Test(groups="Regression test")
public void createContactWithIndustry() throws InterruptedException, EncryptedDocumentException, IOException
{
	//step 2: navigate to organization module
    
    HomePage homepage=new HomePage(driver);
    homepage.getOrganizationlink().click();
    
    
    //step 3:click on create organization button
    
    OrganizationPage orgpage=new OrganizationPage(driver);
    orgpage.getCreateOrganizationbutton().click();
  
    
    //Generate random number
    
    
    int randomint=javalib.getRandomNumber();
    
    //read excel file
    
    String org=excellib.getDataFromExcel("org",5,2)+randomint;
    String industry=excellib.getDataFromExcel("org",5,3);
    String type=excellib.getDataFromExcel("org",5,4);
    
    
    // step 4: Enter all details and save it
    
    CreateNewOrganizationPage createneworg=new CreateNewOrganizationPage(driver);
    createneworg.createOrganization(org, industry, type);
  		   	     
    
    
    
    // verify header msg expected result
    
    OrganizationInformation orginfo=new OrganizationInformation(driver);
    String header_data=orginfo.getHeading().getText();
   
    if(header_data.contains(org))
    {
   	 System.out.println("is pass");
    }
    else
    {
   	 System.out.println("fail");
    }
    
   
   
    
    Thread.sleep(2000);
}

@Test(groups="Regression test")

public void createOrgWithPhoneNumber() throws IOException
{
	
    
    
    
    //step 2: navigate to organization module
    
	HomePage home=new HomePage(driver);
	home.getOrganizationlink().click();
    
    
    //step 3:click on create organization button
	
	    OrganizationPage orgpage=new OrganizationPage(driver);
	    orgpage.getCreateOrganizationbutton().click();
    
    
       
    //Generate random number and read excel file
    
	  int randomInt=javalib.getRandomNumber();
	  
    String org=excellib.getDataFromExcel("org",10,2)+randomInt;
    String number =excellib.getDataFromExcel("org",10,3);
       	     
    
    //step 4:Enter all the deatils&create new organization
    
    CreateNewOrganizationPage createorg=new CreateNewOrganizationPage(driver);
    createorg.createOrganization(org, number);
        
       
    //verify if the phone number fetch from excel and insert in phone number textfield
    
   String num= driver.findElement(By.id("dtlview_Phone")).getText();
    if(num.equalsIgnoreCase(number))
    {
   	System.out.println("number is pass"); 
    }
    else
    {
   	 System.out.println("number is fail"); 
    }
    
    
    
    // verify header msg expected result
    
    String header_data=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    if(header_data.contains(org))
    {
   	 System.out.println("number is pass");
    }
    else
    {
   	 System.out.println("number is fail");
    }
   
   
    
    
}
}
