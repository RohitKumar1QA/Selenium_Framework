package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	//PageFactory
	
	/*
	 * @FindBy(id="userEmail") WebElement userEmail;
	 * 
	 * @FindBy(id="userPassword") WebElement passwordEle;
	 * 
	 * @FindBy(id="login") WebElement submit;
	 * 
	 * @FindBy(css="[class*='flyInOut']") WebElement errorMessage;
	 */
	
	@FindBy(id="1628856212952135") WebElement username;
	@FindBy(id="mat-input-1") WebElement password;
	@FindBy(xpath="//span[normalize-space()='Login']") WebElement loginButton;
	
	//document.getElementsByClassName('btn-primary2')
	
	public void logintoKotak(String uname,String pass) 
	{
		try {
		Thread.sleep(2000);
		}catch(InterruptedException e)
		{
			
		}
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
		
	}
	
	
	public void goTo()
	{
		driver.get("https://kotak-ca-uat.vahancloud.com/kotak_CA/#/main/1624606315911655/loginscreen");
	}


	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
