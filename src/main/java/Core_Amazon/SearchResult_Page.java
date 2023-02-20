package Core_Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResult_Page {

	WebDriver driver;
	private By linkLocator = By.id("./../../../..");
	private By ratingLocator = By.xpath("//*[@class=\"a-size-base\"]");

	public SearchResult_Page(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getSearchResults() {
		return driver.findElements(By.xpath("//*[@class=\"a-size-mini a-spacing-none a-color-base s-line-clamp-4\"]"));
	}

	public WebElement getBestLink() {
		return driver.findElement(linkLocator);
	}

	public By getResultName() {
		return By.xpath("//*[@class=\"a-size-base-plus a-color-base a-text-normal\"]");
	}

	public By getPrice() {
		return By.xpath("//*[@class=\"a-price-whole\"]");
	}

	public By getItemName() {
		return By.xpath("//*[@class=\"a-size-base-plus a-color-base a-text-normal\"]");
	}

	public WebElement getBestSeller() {
		return driver.findElements(By.xpath("//*[@class=\"a-badge\"]")).get(0);
	}
	
	public By getRating() {
		return ratingLocator;
	}

}
