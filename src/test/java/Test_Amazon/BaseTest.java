package Test_Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import Core_Pack.OpenBrowsers;
import Core_Pack.ReadCsvFile;

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
	
	@DataProvider
    protected Object[][] getData(String fileName) throws Exception {
        List<String[]> lines = ReadCsvFile.readAllLines(fileName);
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for (String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }
	
	@AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
	}

}
