package Core_Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RateItems extends SearchItem_Page{

	WebDriver driver;
	
	private By ratingLocator = By.xpath("//*[@class=\"a-icon a-icon-star-medium a-star-medium-4\"]");
	
	public RateItems(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public WebElement getRating() {
		return driver.findElement(ratingLocator);
	}
	
	public List<WebElement> getSearchResults(){
		return driver.findElements(By.xpath("//*[@class=\"a-icon-alt\"]"));
	}

	public void clickRating() {
		getRating().click();
	}
	
}
