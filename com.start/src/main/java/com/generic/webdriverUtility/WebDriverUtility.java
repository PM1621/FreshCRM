package com.generic.webdriverUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
    
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void switchToTabUsingUrl(WebDriver driver,String partialurl)
	{
		Set<String> set=driver.getWindowHandles();
		for(String wid:set)
		{
			driver.switchTo().window(wid);
			String url=driver.getCurrentUrl();
			if(url.contains(partialurl))
			{
				break;
			}
		}
		
	}
	
	public void switchToTabUsingTitle(WebDriver driver,String title)
	{
		Set<String> set=driver.getWindowHandles();
		for(String wid:set)
		{
			driver.switchTo().window(wid);
			String page_title=driver.getTitle();
			if(page_title.contains(title))
			{
				break;
			}
		}
		
	}
	
	public void switchToFrameUsingIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameUsingNameID(WebDriver driver,String nameId)
	{
		driver.switchTo().frame(nameId);
		
	}
	
	public void switchToFrameUsingWebElement(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void mouseActionsForMoveToSpecificElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void mouseActionsForDoubleClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void mouseActionsForClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.click(element).perform();
	}
	
	public void selectByIndex(WebElement element,int index)
	{
		Select select =new Select(element) ;
		select.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element,String value)
	{
		Select select= new Select(element);
		select.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
}
