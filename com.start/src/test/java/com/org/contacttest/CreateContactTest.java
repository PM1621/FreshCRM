package com.org.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseTest.BaseClass;
import com.crm.ObjectRepositoryUtility.ContactPage;
import com.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.crm.ObjectRepositoryUtility.HomePage;
import com.crm.ObjectRepositoryUtility.OrganizationPage;
import com.generic.FileUtility.ExcelUtility;
import com.generic.webdriverUtility.JavaUtility;
import com.generic.webdriverUtility.WebDriverUtility;

public class CreateContactTest extends BaseClass{
	

	 @Test(groups="Smoke test")
	 
	public  void createContactTest() throws IOException, InterruptedException 
	{
	
		
	     
		int randomInt=javalib.getRandomNumber();
	     
	     	          
	     // fetch data from excel 

		 String lastname=excellib.getDataFromExcel("contact",1,2)+randomInt;
		 String number=excellib.getDataFromExcel("contact",1,3);
	         
	     
	     //step 2: navigate to  contact page;
		 
	     
		 HomePage home=new HomePage(driver);
		 home.getContactlink().click();
		 
		 ContactPage contact=new ContactPage(driver);
		 contact.getCreatecontactButton().click();
		 
	    	     
	     //Enter mandatory data with phone number and save it
	     
		 CreateNewContactPage createNewContact=new CreateNewContactPage(driver);
		 createNewContact.createContact(lastname, number);
	     
	     
	     
	     //verify data fetch and enter data is valid or not
	     
	    String act_info= contact.getHeaderinfo().getText();
	    boolean status=act_info.contains(lastname);
	    Assert.assertTrue(status);
	     
	    String act_latname=contact.getActual_LastName().getText();
	    SoftAssert soft_assert_obj=new SoftAssert();
	     soft_assert_obj.assertEquals(act_latname,lastname);
	    	    
		
	}
	 @Test(groups="Regression test")
	 
	 public void createContactWtithOrgTest() throws InterruptedException, EncryptedDocumentException, IOException
	 {
		 int randomInt= javalib.getRandomNumber();
	     
          
	     // fetch data from excel 
         
         String lastname = excellib.getDataFromExcel("contact",10,2)+randomInt;
         String contact = excellib.getDataFromExcel("contact",10,4);
         String org = excellib.getDataFromExcel("contact",10,3)+randomInt;
	     
	     
	     //step 1.1: navigate to organization module
	     
         HomePage home=new HomePage(driver);
         home.getOrganizationlink().click();
         
         
        
         
         
         
	     
	     
	     //step 1.2:click on create organization button
	     
         OrganizationPage orgpage=new OrganizationPage(driver);
         orgpage.getCreateOrganizationbutton().click();
         
         
         
         
        
	     
	     
	   //step 1.3:Enter all the deatils&create new organization
	     
	     CreateNewOrganizationPage create_new_org=new CreateNewOrganizationPage(driver);
	     create_new_org.createOrganization(org);
	     
	     
	    
	     
	     
	     
	     //step 2: navigate to contact module
	     Thread.sleep(2000);
	     
	     home.getContactlink().click();
	     Thread.sleep(2000);
	     
	     ContactPage contactpage=new ContactPage(driver);
	     
         contactpage.getCreatecontactButton().click();
         Thread.sleep(2000);
         
        //Enter mandatory data with phone number and save it
	     
         CreateNewContactPage create_new_contact=new CreateNewContactPage(driver);
         
         String partialurl="module=Accounts";
         String title=" Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
         
         create_new_contact.createContact(lastname,contact,partialurl,org,title);
         
	
	     //verify data fetch and enter data is valid or not
	     
	    String data= driver.findElement(By.className("dvHeaderText")).getText();
	    
	    if(data.contains(lastname))
	    {
	    	System.out.println("========pass=======");
	    }
	    else
	    {
	    	System.out.println("==========fail============");
	    }
	     
	     
	 
	 }
	 
	 @Test(groups="Regression test")
	 
	 public void createContactWithSupportdate() throws EncryptedDocumentException, IOException, InterruptedException
	 {
		 //Random
	     
		 
	        
	     	int randomnumber=javalib.getRandomNumber();
	     	         
	     // fetch data from excel 
	     	
       
       String lastname = excellib.getDataFromExcel("contact",1,2)+randomnumber;
        String number=excellib.getDataFromExcel("contact",1,3);
	     
	     
	     
	     //date 
       String startdate =javalib.getSystemDateYYYYMMDD();
       String enddate =javalib.getRequiredBeforeAfterDate(30);
	     
	     
	     
	     //step 2: navigate to contact module
	     HomePage home=new HomePage(driver);
	     home.getContactlink().click();
	     
	     ContactPage contact=new ContactPage(driver);
	     contact.getCreatecontactButton().click();
	     
	     
	          
	     
	     //Enter mandatory data with phone number and save it
	     
	     CreateNewContactPage create_new_contact=new CreateNewContactPage(driver);
	     
	     create_new_contact.createContact(lastname, number, startdate, enddate);
	     
	     
	     
	    
	     
	     //verify data fetch and enter data is valid or not
	     
	    String data= driver.findElement(By.className("dvHeaderText")).getText();
	    
	    if(data.contains(lastname))
	    {
	    	System.out.println("========pass=======");
	    }
	    else
	    {
	    	System.out.println("==========fail============");
	    }
	     
	     
	     
	 }

}

