package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import myutilities.WebDrivrManager;

public class Hooks {
	
	private WebDriver driver;
	@Before
	public void setUp()
	{
		// Initialize WebDriver before each scenario
		driver=WebDrivrManager.getDriver();
	}
	
	@After
	public void tearDown()
	{
		WebDrivrManager.quitDriver();
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	

}
