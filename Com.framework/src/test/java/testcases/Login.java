package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Login extends BaseClassNew
{
	ExtentReports extent = new ExtentReports();



	@Test(dataProvider="LoginData",dataProviderClass =ExcelDataProvider1.class )
	public void Testcase001(String username,String password) throws IOException, Exception
	{
		LaunchApplication();
		launchWebsite();
		getScreenshot(driver);
	

		//	driver.get("https://kotak-ca-uat.vahanacloud.com/kotak_CA/#/main/1624606315911655/loginscreen");

		ExtentTest test=extent.createTest("Login webpage").assignAuthor("Rohit Kumar")
				.assignCategory("FunctionalTesting").assignDevice("Windows");
		test.info("I am try to login mulitple User");


		driver.findElement(By.xpath("//input[@id='1628856212952135']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
		WebElement elemt=driver.findElement(By.xpath("//span[normalize-space()='Login']"));
		elemt.click();
		test.fail("Login Button Continue Button should be Failed : "+ elemt);
		test.pass("Login Button Functionality working fine :" +elemt);
		
		test.addScreenCaptureFromPath(getScreenshot(driver));
	}


	@Test
	public void TestCase002() throws IOException
	{
		ExtentTest test=extent.createTest("Verify the Login Role Functionality").assignAuthor("Rohit Kumar").assignAuthor("Smoke Test")
				.assignDevice("Mac");

		test.info("Naviagte to Login Aprrover Section");
		try 
		{
			driver.findElement(By.xpath("//span[@class='mat-select-placeholder ng-tns-c20-5 ng-star-inserted']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Approver']")).click();
			test.pass("User is selecting the Login Category");
		} catch (Exception e) {
			// TODO: handle exception
			test.fail("Login Role Selection Screen Execution failed :" +e.getMessage());
			test.addScreenCaptureFromPath(getScreenshot(driver));
		}

	}



	@AfterTest
	public void teardown()
	{
		extent.flush();
		driver.close();
	}


	@BeforeTest
	public void f1() 
	{
		String path=System.getProperty("user.dir")+"\\ExtentReports\\NewLogin26Dec22.html";
		ExtentSparkReporter spark1= new ExtentSparkReporter(path);
		extent.attachReporter(spark1);
		spark1.config().setTheme(Theme.STANDARD);

	}
	
	


	/*
	 * String ExpectedTitle= "Login Screen OLD"; String actualTitle=
	 * driver.getTitle();
	 */


}

























/*
 * public String getScreenshot(String testCaseName) throws IOException {
 * TakesScreenshot ts = (TakesScreenshot)driver; File Source
 * =ts.getScreenshotAs(OutputType.FILE); File file= new
 * File(System.getProperty("user.dir")+ "//ScreenshotReport//" + testCaseName
 * +".png"); FileUtils.copyFile(Source, file); return
 * System.getProperty("user.dir")+ "//ScreenshotReport//" + testCaseName
 * +".png"; }
 */

/*public void testChrome()
	{
		System.setProperty("Webdriver.chrome.driver","Browser");
		WebDriver driver=new ChromeDriver();
		driver.get("AppURL");
	}

	public void loginApp() throws InterruptedException
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		//driver=BrowserFactory.startApplication(driver, "Chrome", "https://kotak-ca-uat.vahanacloud.com/kotak_CA/#/main/1624606315911655/loginscreen");
		Thread.sleep(5000);
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.logintoKotak(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		// BrowserFactory.quitBrowser(driver);
	}
 */

