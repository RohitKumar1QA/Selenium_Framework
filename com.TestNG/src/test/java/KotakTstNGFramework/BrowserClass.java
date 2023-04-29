package KotakTstNGFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserClass {

	public WebDriver driver;

	public WebDriver intializedriver() throws IOException
	{
		Properties pro= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+".//src//main//java//propertiesFile//GlobalData.properties");
		pro.load(fis);
		String browsername = pro.getProperty("browser");
		System.out.println(browsername);
		

		//chromeBrowser//
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		//FireFoxBrowser//
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}


		//EdgeBrowser//
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	

	public LoginKotak LaunchApp() throws IOException
	{
		driver= intializedriver();
		LoginKotak logkotak= new LoginKotak();
		return logkotak;
	}
	
	

	public void launchwebsite() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+".//src//main//java//propertiesFile//GlobalData.properties");
		prop.load(fis);
		String Url = prop.getProperty("URL");
		System.out.println(Url);
		driver.get(Url);
	}
	

}
