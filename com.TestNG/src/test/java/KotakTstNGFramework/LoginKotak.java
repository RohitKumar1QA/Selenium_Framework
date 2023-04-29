package KotakTstNGFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginKotak extends BrowserClass{


	ExtentReports extent = new ExtentReports();



	@Test(dataProvider = "URLData" , dataProviderClass = ExcelDataProvider.class)
	public void TestCase001(String username, String password) throws IOException,Exception
	{
		LaunchApp();
		launchwebsite();

		ExtentTest test=extent.createTest("LoginKotakWebpage").assignAuthor("Rohit Singh").assignCategory("Functional Testing").assignDevice("Chrome");

		driver.findElement(By.xpath("//input[@id='1628856212952135']")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
	

		driver.quit();
		extent.flush();
	}

	@BeforeTest
	public void f1()
	{
		String path= System.getProperty("user.dir")+"\\ExtentReport\\NewLoginTestCaseReport.html";
		ExtentSparkReporter spark1= new ExtentSparkReporter(path);
		extent.attachReporter(spark1);
	}

}
