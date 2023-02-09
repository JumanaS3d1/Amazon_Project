package Test_Amazon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core_Amazon.Cart_Page;
import Core_Amazon.ItemInfo_Page;
import Core_Amazon.SearchItem_Page;
import Core_Amazon.SearchResult_Page;
import Core_Pack.ReadCsvFile;
import Core_Pack.WriteCsvFile;

public class BuyABook_Test extends BaseTest {

	List<Float> prices = new ArrayList<Float>();

	@Test(priority = 1)
	public void SearchItemTest() throws IOException, InterruptedException {

		String searchTerm = "Computer Science";
		String[] headers = { "Book Name", "Price" };
		driver.findElement(By.id("nav-search-submit-button")).click();
		SearchItem_Page searchItem = new SearchItem_Page(driver);
		searchItem.searchElement(searchTerm);
		waitForElementToBeClickable(searchItem.getSearchBtn());
		searchItem.searchClick();
		SearchResult_Page searchResult = new SearchResult_Page(driver);
		// Get first page results and write to csv file
		List<WebElement> books = searchResult.getSearchResults();
		List<String[]> data = new ArrayList<String[]>();
		for (int i = 0; i < 15; i++) {
			WebElement book = books.get(i);
			String bookName = book.findElements(searchResult.getResultName()).get(i).getText();
			String price = book.findElements(searchResult.getPrice()).get(i).getText();
			data.add(new String[] { bookName, price });
		}

		WriteCsvFile.writeDataLineByLine("ComputerScienceBooks.csv", data, headers);
	}

	@DataProvider
	public static Object[][] getData() throws Exception {

		List<String[]> lines = ReadCsvFile.readAllLines("Books.csv");
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for (String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}

	@Test(priority = 2, dataProvider = "getData")
	public void searchSubjects(String book) throws InterruptedException, IOException {
		SearchItem_Page searchItem = new SearchItem_Page(driver);
		waitForElementToBeClickable(searchItem.getSearchBar());
		searchItem.searchElement(book);
		waitForElementToBeClickable(searchItem.getSearchBtn());
		searchItem.searchClick();
		SearchResult_Page searchResult = new SearchResult_Page(driver);
		WebElement bestSeller = searchResult.getBestSeller();
		Thread.sleep(2000);
		WebElement openLink = bestSeller.findElement(By.xpath("../../../.."));
		Thread.sleep(2000);
		openLink.click();
		Thread.sleep(2000);
		ItemInfo_Page itemInfo = new ItemInfo_Page(driver);
		itemInfo.getPrice();
		prices.add(itemInfo.getActualPrice());
		waitForElementToBeClickable(itemInfo.addToCart());
		itemInfo.addToCart().click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void CartTest() throws InterruptedException, IOException {

		float sumOfItems = 0.0f;
		for (float price : prices) {
			sumOfItems += price;
		}
		Cart_Page cart = new Cart_Page(driver);
		waitForElementToBeClickable(cart.getCartIcon());
		cart.clickCartBtn();

		waitForElementToBeClickable(cart.getPrice());
		float actualSum = cart.getActualTotal();
		Assert.assertEquals(actualSum, sumOfItems, "Values do not match");
	}

}
