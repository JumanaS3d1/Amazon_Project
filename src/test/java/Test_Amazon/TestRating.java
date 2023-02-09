package Test_Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Core_Amazon.RateItems;
import Core_Amazon.SearchItem_Page;
import Core_Pack.OpenBrowsers;

public class TestRating extends BaseTest {

	@Test
	public void TestFourStars() {
		String searchTerm = "SheaMoisture";
		RateItems rating = new RateItems(driver);
		waitForElementToBeClickable(rating.getSearchBar());
		rating.searchElement(searchTerm);
		waitForElementToBeClickable(rating.getSearchBtn());
		rating.searchClick();
		waitForElementToBeClickable(rating.getRating());
		rating.clickRating();

		String actualRating = driver.findElements(By.xpath("//*[@class=\"a-icon-alt\"]")).get(0).getText();
		Assert.assertTrue(actualRating.contains("4.3 out of 5 stars")|| actualRating.contains("4.5 out of 5 stars"),"Rating does not meet the 4 star requirement");
	}
}
