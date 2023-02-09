package Core_Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordLogin {
	WebDriver driver;
	
	private By passwordLocator = By.id("ap_password");
	private By submitLocator = By.id("signInSubmit");
	

	public PasswordLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPasswordField() {
		return driver.findElement(passwordLocator);
	}
	
	public WebElement getSubmitBtn() {
		return driver.findElement(submitLocator);
	}
	
	public void fillPassword(String txt) {
		 driver.findElement(By.id("ap_password")).sendKeys(txt);
	}

	public void logIn() {
		driver.findElement(By.id("signInSubmit")).click();
	}
}
