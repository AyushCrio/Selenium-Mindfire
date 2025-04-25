package Selenium_Setup;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSetup 
{
	static WebDriver driver;
	

	public static WebDriver driverInitiliaze()
	{
		System.out.println("Driver Initialization has Started");
		try 
		{
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
	
	public static void driverClose()
	{
		try
		{
			driver.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void driverQuit()
	{
		try
		{
			driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void goToUrl(String url)
	{
		try
		{
			driver.get(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void getScreenshot(String filename)
	{
		try 
		{
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("C:\\Users\\Mindfire\\eclipse-workspace\\Selenium-sample\\src\\test\\java\\Image\\"+filename+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
