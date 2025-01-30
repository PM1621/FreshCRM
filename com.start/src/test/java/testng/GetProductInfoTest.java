package testng;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.FileUtility.ExcelUtility;

public class GetProductInfoTest {
	
	@Test(dataProvider="getData")
	
	public void getProductInfoTest(String BrandName,String ProductName) throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		
		System.out.println("Brand Name : "+BrandName);
		System.out.println("Product Name : "+ProductName);
		//SEARCH PRODUCT
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName,Keys.ENTER);
		Thread.sleep(2000);
		
		//CAPTURE PRODUCT INFO
		String price=driver.findElement(By.xpath("//span[text()='"+ProductName+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']")).getText();
	    System.out.println(price);
	    
	    driver.quit();
	}

	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility excellib=new ExcelUtility();
		int totalrow=excellib.getLastRowNum("Product");
		
		Object[][]objArr=new Object[totalrow][2];
		
		for(int i=0;i<totalrow;i++)
		{
			objArr[i][0]=excellib.getDataFromExcel("Product",i+1,0);
			objArr[i][1]=excellib.getDataFromExcel("Product",i+1,1);
		}
		
		
		return objArr;
	}
}
