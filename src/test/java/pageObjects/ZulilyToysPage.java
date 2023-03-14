package pageObjects;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZulilyToysPage {
	// Local Variable
	private WebDriver driver;

	// Elements
	@FindBy(how = How.XPATH, using = "//img[@alt='Toys & Games']")
	private WebElement toysGameField;
	@FindBy(how = How.XPATH, using = "//strong[text()='All prices']")
	private WebElement allPriceTag;
	@FindBy(how = How.XPATH, using = "//div[@class='price-boxConfig  ']/div[@class='special-price']")
	private List<WebElement> searchResultPrices;
	@FindBy(how = How.XPATH, using = "//ul[@class='pagination']/li")
	private List<WebElement> pagesNumbers;
	@FindBy(how = How.XPATH, using = "//a[@class='next_page_on']")
	private WebElement nextPageButton;

	// Constructor
	public ZulilyToysPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void clickToysGameField() {
		toysGameField.click();
	}

	public void choosePirceRange(int priceLow, int priceHigh) {
		allPriceTag.click();
		String xpath = "//label[text()='$" + priceLow + " - $" + priceHigh + "']/../input";
		driver.findElement(By.xpath(xpath)).click();
	}

	public void validateResultPrice(int priceLow, int priceHigh) {
		for (int i = 1; i < pagesNumbers.size(); i++) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.numberOfElementsToBe(
					By.xpath("//div[@class='price-boxConfig  ']//span[text()='new price']"),
					searchResultPrices.size()));
			for (WebElement price : searchResultPrices) {
				if (price.getText().contains("See Price In Basket")) {
					continue;
				} else {
					String text = price.getText();
					String newPrice = text.replace("new price", "").replace("\n", "").replace("$", "");
					if (newPrice.length() > 0) {
						double finalPrice = Double.parseDouble(newPrice);
						assertTrue(finalPrice >= priceLow && finalPrice <= priceHigh);
					}
				}
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			utilities.Util.wait(3);
			js.executeScript("arguments[0].click()", nextPageButton);
		}
	}

}
