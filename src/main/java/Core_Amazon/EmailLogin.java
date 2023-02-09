package Core_Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailLogin {
	WebDriver driver;
	
	private By emailLocator = By.id("ap_email");
	private By continueBtnLocator = By.id("continue");

	public EmailLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmailField() {
		return driver.findElement(emailLocator);
	}
	
	public WebElement getContinueBtn() {
		return driver.findElement(continueBtnLocator);
	}
	
	public void fillEmail(String txt) {
		getEmailField().sendKeys(txt);
	}
	
	public void continueClick() {
		getContinueBtn().click();
	}
}
