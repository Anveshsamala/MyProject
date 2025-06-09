package myutilities;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {
	
	private WebDriver driver;
	 // Constructor to initialize driver
	public Registration(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterdata(Map<String, String> fielddata) {
		for(Map.Entry<String, String> entry : fielddata.entrySet()) {
			String fieldName=entry.getKey();
			String value=entry.getValue();
			try {
				WebElement inputField=driver.findElement(By.xpath("//input[@name='"+fieldName+"']"));
				inputField.clear();
				inputField.sendKeys(value);
				
			}catch (Exception e) {
				 System.out.println("Could not find or fill input with name='" + fieldName + "'");
	                throw e;
			}
		}
			
	}
	// Click the checkbox
	public void clickOnCheckBox() {
		WebElement chckBx=driver.findElement(By.xpath("//input[@type='checkbox']"));
		if(!chckBx.isSelected()) {
			chckBx.click();
			}
				}
	
	// Click Create Account button
	public void clickCreateAccount() {
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();		
	}
	
	

}
