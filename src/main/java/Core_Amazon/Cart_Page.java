package Core_Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart_Page {
	WebDriver driver;

	private By CartBtnLocator = By.id("nav-cart");
	private By totalTextLocator = By.xpath("//*[@class=\"a-size-medium a-color-base sc-price sc-white-space-nowrap\"]");

	public Cart_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartIcon() {
		return driver.findElement(CartBtnLocator);
	}
	
	public WebElement getPrice() {
		return driver.findElement(totalTextLocator);
	}
	
	public void clickCartBtn() {
		getCartIcon().click();
	}

	public Float getActualTotal() {
		String tempString = getPrice().getText();
		tempString = tempString.replaceAll("\\$", "");
		float price = Float.parseFloat(tempString);
		return price;
	}

}
