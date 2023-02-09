package Core_Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemInfo_Page {
	WebDriver driver;

	private By priceLocator = By.id("price");
	private By CartBtnLocator = By.id("add-to-cart-button");
	
	public ItemInfo_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPrice() {
		return driver.findElement(priceLocator);
	}
	public WebElement addToCart() {
		return driver.findElement(CartBtnLocator);
	}
	
	public Float getActualPrice() {
		String tempString = getPrice().getText();
		tempString = tempString.replaceAll("\\$", "");
		float price = Float.parseFloat(tempString);

		return price;
	}
}
