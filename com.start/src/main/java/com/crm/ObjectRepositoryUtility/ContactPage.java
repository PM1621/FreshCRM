package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.baseTest.BaseClass;

public class ContactPage extends BaseClass{

	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//comment
	}
	
	
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontactButton;



	public WebElement getCreatecontactButton() {
		return createcontactButton;
	}

	@FindBy(className="dvHeaderText")
	private WebElement headerinfo;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement Actual_LastName;



	public WebElement getHeaderinfo() {
		return headerinfo;
	}

	public WebElement getActual_LastName() {
		return Actual_LastName;
	}
	
}
