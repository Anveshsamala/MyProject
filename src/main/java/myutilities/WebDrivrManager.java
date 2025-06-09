package myutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDrivrManager {

	private static WebDriver driver;

	// Initialize the driver
	public static WebDriver getDriver() {
		if (driver == null) {
			// If WebDriver is not initialized, initialize it
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	// Quit the WebDriver
	public static void quitDriver()
	{
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}
}
