package testclasses;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AirNavRadar {
	static WebDriver driver;
	static Actions actions;

	public static void registerflow() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='I have an ADS-B/Mode-s receiver']")).click();
		driver.findElement(By.xpath("//a[text()='Create a free account']")).click();
		driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Anirudh");
		driver.findElement(By.xpath("//input[@name='name']//following-sibling::input[@name='email']"))
				.sendKeys("samalaanvesh2@gmail.com");
		driver.findElement(By.xpath("//input[@name='name']//following-sibling::input[@name='password']"))
				.sendKeys("Rahul123@");
		driver.findElement(By.xpath("//input[@name='name']//following-sibling::input[@name='password_confirmation']"))
				.sendKeys("Rahul123@");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		Thread.sleep(2000);
		boolean b = driver.findElement(By.xpath("//p[contains(text(),'A confirmation email has')]")).isDisplayed();
		System.out.println("Registration successfull");

		driver.findElement(By.xpath("//button[text()='Close']")).click();

	}

	public static void loginflow() {
		driver.findElement(By.xpath("//*[text()='I have an ADS-B/Mode-s receiver']")).click();
		driver.findElement(
				By.xpath("//p[text()='Using your email & password:']//following-sibling::input[@name='email']"))
				.sendKeys("samalaanvesh@gmail.com");
		driver.findElement(
				By.xpath("//p[text()='Using your email & password:']//following-sibling::input[@name='password']"))
				.sendKeys("Rahul123@");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		System.out.println("Login Successfull");
	}

	public static void addCoverageflow() throws InterruptedException {
		WebElement coveraggg = driver.findElement(By.xpath("//span[text()='Coverage']"));
		actions = new Actions(driver);
		actions.moveToElement(coveraggg).perform();
		WebElement shadadsbdata = driver.findElement(By.xpath("//span[text()='Share ADS-B Data']"));
		actions.moveToElement(shadadsbdata).perform();
		WebElement addcover = driver.findElement(By.xpath("//a[text()='Add Coverage']"));
		Thread.sleep(1000);
		actions.moveToElement(addcover).click().perform();
	System.out.println("Execution completed");

	}

//	public static void main(String[] args) throws InterruptedException {
	@Test
	public static void runthisclass() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.airnavradar.com/addcoverage");
		driver.findElement(By.xpath("//p[text()='Consent']")).click();
		// registerflow();
		// loginflow();
		addCoverageflow();

	}

}
