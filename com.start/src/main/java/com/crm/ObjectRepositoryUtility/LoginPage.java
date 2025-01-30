package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.baseTest.BaseClass;

public class LoginPage extends BaseClass { 
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement LoginButtton;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginButtton() {
		return LoginButtton;
	}

	public void loginpage(String url,String username,String password)
	{
		webdriverlib.waitForPageLoad(driver);
		driver.get(url);
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		LoginButtton.click();
	}
}
