package Test_Amazon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core_Amazon.ItemInfo_Page;
import Core_Amazon.RateItems;
import Core_Amazon.SearchItem_Page;
import Core_Amazon.SearchResult_Page;
import Core_Pack.ReadCsvFile;
import Core_Pack.WriteCsvFile;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class TestRating extends BaseTest {

	private List<String[]> data ;

	@BeforeClass
	public void setup() throws InterruptedException {
		super.setup();
		String[] headers = { "Product Name", "Assumed Rating", "Actual Rating", "Check" };
		WriteCsvFile.writeDataLineByLine("RatingOutput.csv", headers);
	}


	@DataProvider
	public Object[][] getTestData() throws Exception {
		return getData("SearchRating.csv");
	}

	@Test(dataProvider = "getTestData")
	public void searchSubjects(String product) throws InterruptedException, IOException {
		SearchItem_Page searchItem = new SearchItem_Page(driver);
		SearchResult_Page searchResult = new SearchResult_Page(driver);
		RateItems rating = new RateItems(driver);

		waitForElementToBeClickable(searchItem.getSearchBar());
		searchItem.searchElement(product);
		waitForElementToBeClickable(searchItem.getSearchBtn());
		searchItem.searchClick();

		waitForElementToBeClickable(rating.getRating());
		rating.clickRating();
		List<String> itemNames = new ArrayList<String>();
		List<WebElement> searchResults = driver.findElements(searchResult.getItemName());
		
		for (int i = 0; i < Math.min(searchResults.size(), 3); i++) {
		    itemNames.add(searchResults.get(i).getText());
		}

		data = new ArrayList<String[]>();
		for (int i = 0; i < itemNames.size(); i++) {
		    float actualRating = Float.parseFloat(driver.findElements(searchResult.getRating()).get(i).getText());
		    data.add(new String[] { itemNames.get(i), "4", "" + actualRating + "", String.valueOf(actualRating >= 4) });
		}
		WriteCsvFile.writeDataLineByLine("RatingOutput.csv", data, true);
	}
}
