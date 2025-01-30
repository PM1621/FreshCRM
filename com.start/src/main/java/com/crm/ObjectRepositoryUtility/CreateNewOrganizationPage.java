package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
WebDriver driver;

public CreateNewOrganizationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}



@FindBy(xpath="//input[@title='Save [Alt+S]']")
 private WebElement SaveButton;



public WebElement getSaveButton() {
	return SaveButton;
}

@FindBy(name="accountname")
private WebElement organizationnameTF;

@FindBy(name="industry")
private WebElement industryDropDown;

@FindBy(name="accounttype")
private WebElement industry_type;

@FindBy(id="phone")
private WebElement phonenumberTF;



public WebElement getOrganizationnameTF() {
	return organizationnameTF;
}




public WebElement getIndustryDropDown() {
	return industryDropDown;
}




public WebElement getIndustry_type() {
	return industry_type;
}




public WebElement getPhonenumberTF() {
	return phonenumberTF;
}




public void createOrganization(String org)
{
	    organizationnameTF.sendKeys(org);
	    SaveButton.click();
}

public void createOrganization(String org,String industry,String type)
{
	organizationnameTF.sendKeys(org);
	Select select=new Select(industryDropDown);
	select.selectByVisibleText(industry);
	Select select1=new Select(industry_type);
	select1.selectByVisibleText(type);
	SaveButton.click();
	
}

public void createOrganization(String org,String phone)
{
	    organizationnameTF.sendKeys(org);
	    phonenumberTF.sendKeys(phone);
	    SaveButton.click();
}





}

