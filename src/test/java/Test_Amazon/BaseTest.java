package Test_Amazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Core_Pack.OpenBrowsers;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;

	@BeforeClass
	public void setup() throws InterruptedException {
		driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");
		Thread.sleep(3000);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	protected void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
