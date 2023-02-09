package Core_Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchItem_Page {

	WebDriver driver;

	private By searchLocator = By.id("twotabsearchtextbox");
	private By searchBtnLocator = By.id("nav-search-submit-button");

	public SearchItem_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSearchBar() {
		return driver.findElement(searchLocator);
	}
	public WebElement getSearchBtn() {
		return driver.findElement(searchBtnLocator);
	}
	
	public void searchElement(String txt) {
		getSearchBar().clear();
		getSearchBar().sendKeys(txt);

	}
	public void searchClick() {
		getSearchBtn().click();
	}

}
