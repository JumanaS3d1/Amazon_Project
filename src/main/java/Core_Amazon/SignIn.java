package Core_Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
	WebDriver driver;
	private By signInLocator = By.id("nav-link-accountList");
	
	public SignIn(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignIn() {
		driver.findElement(signInLocator).click();
	}
	
	public WebElement getSignInBtn() {
		return driver.findElement(signInLocator);
	}

}
