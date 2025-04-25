package Selenium_Setup;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchWebGetResult extends SeleniumSetup
{
	WebDriver driver;
	
	
	@BeforeClass
	public void driverInitialize()
	{
		try
		{
			driver = SeleniumSetup.driverInitiliaze();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void SearchOnWeb()
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			SeleniumSetup.goToUrl("https://www.mindfiresolutions.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div[1]/i")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"InputToFocus\"]"))));
			
			driver.findElement(By.xpath("//*[@id=\"InputToFocus\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"InputToFocus\"]")).sendKeys("Python");
			driver.findElement(By.xpath("//*[@id=\"search_menu\"]/div/div[2]/form/button")).click();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"page-title-bar\"]/div[2]/div/div/div/div/h1"))));
			
			String textActual = driver.findElement(By.xpath("//*[@id=\"page-title-bar\"]/div[2]/div/div/div/div/h1")).getText();
			String textExpected = "Search results for: \"Python\""; 
			Assert.assertEquals(textActual, textExpected);
			SeleniumSetup.getScreenshot("SearchResult");
			Thread.sleep(2000);
			
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"tm-blog-680b8132433e8\"]/div[1]/div[6]/div/div/h3/a"))).perform();
			
			Thread.sleep(5000);
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SeleniumSetup.driverClose();
			SeleniumSetup.driverQuit();
		}
		
	}

}
