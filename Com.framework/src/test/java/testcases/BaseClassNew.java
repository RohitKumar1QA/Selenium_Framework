package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassNew
{
	public WebDriver driver;
	public Login login;


	public WebDriver IntializeDriver() throws IOException
	{
		//Properties class for making a global//
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//config.properties");
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		


		// ChromeBrowser//
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}


		else if ((browserName.equalsIgnoreCase("firefox")))
		{

			//firefox Browser//
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}


		else if ((browserName.equalsIgnoreCase("edge")))
		{
			//edge Browser//
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}


	public Login LaunchApplication() throws IOException
	{
		driver =IntializeDriver();
		Login login=new Login();
		return login;
	}

	
	public void launchWebsite() throws IOException
	{
		//Properties class for making a global//
		Properties prop1 =new Properties();
		FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//config.properties");
		prop1.load(fis1);
		String Url =prop1.getProperty("AppURL");
		System.out.println(Url);
		driver.get(Url);
	}
	
	

	public String getScreenshot(WebDriver driver) throws IOException
	{
		File srcfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinaitionfilepath=new File(System.getProperty("user.dir")+"//ScreenshotReport" +System.currentTimeMillis()+" .png");
		String absolutepath =destinaitionfilepath.getAbsolutePath();
		FileUtils.copyFile(srcfile, destinaitionfilepath);
		return absolutepath;
		
		
		
		
		
		/*
		 * TakesScreenshot ts = (TakesScreenshot)driver; File source =
		 * ts.getScreenshotAs(OutputType.FILE); File file = new
		 * File(System.getProperty("user.dir") + "//ExtentReports//26Dec2022.png");
		 * FileUtils.copyFile(source, file); return System.getProperty("user.dir") +
		 * "//ExtentReports//26Dec2022.png";
		 */
		
	}
	


}

