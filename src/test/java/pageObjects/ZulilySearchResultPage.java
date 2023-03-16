package pageObjects;

import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

public class ZulilySearchResultPage {

	// Local Variable
	private WebDriver driver;
	private static final String searchResultsCss = "div.product_brand_name_v2";

	// Element
	@FindBy(how = How.CSS, using = searchResultsCss)
	private List<WebElement> searchResults;
	@FindBy(how = How.XPATH, using = "//span[text()='add to basket']")
	private WebElement addToBasket;
	@FindBy(how = How.XPATH, using = "(//h3[@class='product-name ']//a)[1]")
	private WebElement productName;
	@FindBy(how = How.XPATH, using = "//li[contains(@class,'zu-trackable-search-result')]")
	private WebElement sigleSearchResultField;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),' edit ')]")
	private WebElement editButton;
	@FindBy(how = How.XPATH, using = "//select[contains(@class,'edit-quantity')]")
	private WebElement selectQty;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'update')]")
	private WebElement updateButton;
	@FindBy(how = How.XPATH, using = "//p[@class='quantity-readonly']")
	private WebElement updatedQtyField;
	@FindBy(how = How.CSS, using = ".summary_detail")
	private WebElement summaryQtyField;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'All Brands')]")
	private WebElement addBrandsField;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'All Departments')]")
	private WebElement addDepartmentsField;
	@FindBy(how = How.XPATH, using = "//span[@data-default='All Subcategories']")
	private WebElement subcategoriesField;
	@FindBy(how = How.XPATH, using = "//span[@data-default='All Prices']")
	private WebElement allPriceField;
	@FindBy(how = How.XPATH, using = "//span[@data-default='All Sizes']")
	private WebElement allSizeField;
	@FindBy(how = How.XPATH, using = "//li[contains(@class,'zu-trackable-search-result')]")
	private List<WebElement> filterRearchResults;

	// Constructor
	public ZulilySearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// action
	public void verifySearchTitle(String content) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(searchResultsCss), searchResults.size()));
		for (WebElement result : searchResults) {
			assertTrue(result.getText().contains(content));
		}
	}

	public void clickSearchResultItem() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.visibilityOf(sigleSearchResultField));
			sigleSearchResultField.click();
		} catch (Exception e) {
			System.out.println("this item is out of stock");
		}
	}

	public void clickAddToBasket() {
		addToBasket.click();
	}

	public void verifyProductName(String expectedProductName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(productName));
		System.out.println(productName.getText());
		assertTrue(productName.getText().contains(expectedProductName));
	}

	public void changOrderQty(String number) {
		editButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(selectQty));
		Select qtySelect = new Select(selectQty);
		qtySelect.selectByValue(number);
		utilities.Util.wait(3);
		updateButton.click();
		utilities.Util.wait(3);
	}

	public void validateOrderQty(String number) {
		assertTrue(updatedQtyField.getText().contains(number));
		assertTrue(summaryQtyField.getText().contains(number));
	}

	public void pickFilter(String brandName, String departmentName, String subcategories, String priceRange,
			String size) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addBrandsField)).click();
		driver.findElement(By.xpath("//a[contains(text(),'" + brandName + "')]")).click();
		utilities.Util.wait(3);
		wait.until(ExpectedConditions.visibilityOf(addDepartmentsField)).click();
		driver.findElement(By.xpath("//li[@data-value='" + departmentName + "']")).click();
		utilities.Util.wait(3);
		wait.until(ExpectedConditions.visibilityOf(subcategoriesField)).click();
		driver.findElement(By.xpath("//a[contains(text(),'" + subcategories + "')]")).click();
		utilities.Util.wait(3);
		wait.until(ExpectedConditions.visibilityOf(allPriceField)).click();
		driver.findElement(By.xpath("//li[@label='" + priceRange + "']")).click();
		utilities.Util.wait(3);
		wait.until(ExpectedConditions.visibilityOf(allSizeField)).click();
		driver.findElement(By.xpath("//li[contains(@label,'" + size + "')]")).click();
		utilities.Util.wait(3);
	}

	public void verifyfilterSearchResult(String ExpectedBrandName, String expectedPriceRange, String departmentName) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfElementsToBe(
				By.xpath("//li[contains(@class,'zu-trackable-search-result')]"), filterRearchResults.size()));
		utilities.Util.wait(5);

		for (int index = 1; index <= filterRearchResults.size(); index++) {
			String parentXpath = "(//li[contains(@class,'zu-trackable-search-result')])[" + index + "]";
			String priceXpath = parentXpath + "//div[@class='product_tile_v2_price_container']/span[1]";
			String brandXpath = parentXpath + "//div[@class='product_brand_name_v2']";
			String productXpath = parentXpath + "//div[@class='product_name_v2']";
			String actualPriceRange = driver.findElement(By.xpath(priceXpath)).getText();
			String actualBrandName = driver.findElement(By.xpath(brandXpath)).getText();
			String actualProductDescription = driver.findElement(By.xpath(productXpath)).getText();
			assertEquals(ExpectedBrandName, actualBrandName);
			assertTrue(actualProductDescription.contains(departmentName));
			System.out.println(actualPriceRange);
			System.out.println(actualBrandName);
			System.out.println(actualProductDescription);
			System.out.println("==========");
			utilities.Util.wait(2);

			String expectedLowPrice = expectedPriceRange.split("-")[0].trim().replace("$", "");
			String expectedHighPrice = expectedPriceRange.split("-")[1].trim().replace("$", "");

			if (actualPriceRange.contains("-")) {
				String actualLowPrice = actualPriceRange.split("-")[0].trim().replace("$", "");
				String actualHighPrice = actualPriceRange.split("-")[1].trim().replace("$", "");
				assertTrue(Double.parseDouble(expectedHighPrice) >= Double.parseDouble(actualHighPrice)
						&& Double.parseDouble(expectedLowPrice) <= Double.parseDouble(actualLowPrice));
			} else {
				String actualPrice = actualPriceRange.trim().replace("$", "");
				assertTrue(Double.parseDouble(expectedLowPrice) <= Double.parseDouble(actualPrice)
						&& Double.parseDouble(actualPrice) >= Double.parseDouble(actualPrice));
			}

		}
	}

}
