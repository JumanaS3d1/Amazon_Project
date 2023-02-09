package Core_Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

	WebDriver driver;
	WebElement signInBtn;
	WebElement userMail;
	WebElement continueBtn;
	WebElement userPass;
	WebElement login;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		//signInBtn = driver.findElement(By.id("nav-link-accountList"));
		//userMail = driver.findElement(By.id("ap_email"));
		//continueBtn = driver.findElement(By.id("continue"));
		//userPass = driver.findElement(By.id("ap_password"));
		//login = driver.findElement(By.id("signInSubmit"));
	}
	
	public void clickSignIn() {
		driver.findElement(By.id("nav-link-accountList")).click();
	}

	public void fillEmail(String txt) {
		driver.findElement(By.id("ap_email")).sendKeys(txt);
	}
	
	public void continueClick() {
		driver.findElement(By.id("continue")).click();
	}

	public void fillPassword(String txt) {
		 driver.findElement(By.id("ap_password")).sendKeys(txt);
	}

	public void logIn() {
		driver.findElement(By.id("signInSubmit")).click();
	}
}
