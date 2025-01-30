package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.baseTest.BaseClass;

public class ProductPage extends BaseClass{

	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement ProductAddButton;

	public WebElement getProductAddButton() {
		return ProductAddButton;
	}
	
	
}
