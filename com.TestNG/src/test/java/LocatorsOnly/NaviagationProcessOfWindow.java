package LocatorsOnly;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/* What is difference between driver.get and driver.navigate method.
 * ans : - Driver.get (1.It is responsible for loading the page and waits until the page has finished loading.). 2.	It cannot track the history of the browser.
 *         Driver.navigate.to() (when page is loaded or not it goto next step) 2. It tracks the browser history and can perform back and forth in the browser.
 */

public class NaviagationProcessOfWindow {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://google.com/");
		
		driver.navigate().to("https://facebook.com");
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		
	}

}
