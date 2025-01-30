package com.crm.ObjectRepositoryUtility;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.baseTest.BaseClass;



public class HomePage extends BaseClass{
	
	

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
     
	@FindBy(linkText="Contacts")
	private WebElement contactlink;

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	@FindBy(xpath="//img [@src='themes/softed/images/user.PNG']")
	private WebElement LogoutIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement Signout;

	public WebElement getLogoutIcon() {
		return LogoutIcon;
	}

	public WebElement getSignout() {
		return Signout;
	}
	
	@FindBy(linkText="Products")
	private WebElement Productlink;
	
	public WebElement getProductlink() {
		return Productlink;
	}

	public void logout()
	{
		Actions action= new  Actions(driver);
		action.moveToElement(LogoutIcon).perform();
		action.click(Signout).perform();
		
	}
	
}
