package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {

	@Test
	public void homePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+" Test Start ");
		String expectedpage="Home Page";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		Assert.assertEquals(actTitle,expectedpage);
		
		System.out.println(mtd.getName()+" Test End");
	}
	
	@Test
	public void verifyLogoHomePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+" Test Start");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean logo=driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).isEnabled();
		Assert.assertTrue(logo);
		System.out.println(mtd.getName()+" Test End");
	}
}
