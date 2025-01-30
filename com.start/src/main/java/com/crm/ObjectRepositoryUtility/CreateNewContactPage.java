package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.baseTest.BaseClass;

public class CreateNewContactPage extends BaseClass {

	public CreateNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameTF;
	
	@FindBy(id="mobile")
	private WebElement mobileTF;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orgnameAddButton;
	
	@FindBy(name="support_start_date")
	private WebElement startDateTF;
	
	@FindBy(name="support_end_date")
	private WebElement endDateTF;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	
	@FindBy(id="search_txt")
	private WebElement searchboxTF;
	
	
	
	

	public WebElement getSearchboxTF() {
		return searchboxTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getLastnameTF() {
		return lastnameTF;
	}

	public WebElement getMobileTF() {
		return mobileTF;
	}

	public WebElement getOrgnameAddButton() {
		return orgnameAddButton;
	}

	public WebElement getStartDateTF() {
		return startDateTF;
	}

	public WebElement getEndDateTF() {
		return endDateTF;
	}
	
	
	
	public void createContact(String lastname,String mobile)
	{
		lastnameTF.sendKeys(lastname);
		mobileTF.sendKeys(mobile);
		saveButton.click();
	}
	
	public void createContact(String lastname,String mobile,String partialurl,String org,String title) throws InterruptedException
	{   
		lastnameTF.sendKeys(lastname);
		mobileTF.sendKeys(mobile);
		orgnameAddButton.click();
		
		webdriverlib.switchToTabUsingUrl(driver,partialurl);
		Thread.sleep(2000);
		searchboxTF.sendKeys(org,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.linkText(org)).click();
		Thread.sleep(2000);
		webdriverlib.switchToTabUsingTitle(driver, title);
		saveButton.click();
	}
	
	public void createContact(String lastname,String mobile,String startDate,String endDate) throws InterruptedException
	{
		lastnameTF.sendKeys(lastname);
		mobileTF.sendKeys(mobile);
		
		Thread.sleep(2000);
		startDateTF.clear();
		startDateTF.sendKeys(startDate);
		
		Thread.sleep(2000);
		endDateTF.clear();
		endDateTF.sendKeys(endDate);
		saveButton.click();
		
	}
	
	
}
