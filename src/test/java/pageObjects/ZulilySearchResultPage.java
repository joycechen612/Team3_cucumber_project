package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		wait.until(ExpectedConditions.visibilityOf(sigleSearchResultField));
		sigleSearchResultField.click();
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

}
