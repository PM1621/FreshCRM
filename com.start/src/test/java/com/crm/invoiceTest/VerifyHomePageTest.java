package com.crm.invoiceTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;


public class VerifyHomePageTest extends BaseClass {
	
	
	@Test(retryAnalyzer = com.generic.ListenerUtility.RetryListenerImp.class) 
	
	public void verifyhomepageTitleTest()
	{
	System.out.println("execute verifyhomepage Titlepage");
	String actTitle=driver.getTitle();
	Assert.assertEquals(actTitle,"Login");
	}
	
	@Test
	
	public void verifyCompanyLogo()
	{
		
	}
}
