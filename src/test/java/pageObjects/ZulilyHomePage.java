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
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

public class ZulilyHomePage {

	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://www.zulily.com/";
	private static final String searchOptionCss = ".autocomplete-list-element";

	// Constructor
	public ZulilyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	}

	// Elements
	@FindBy(how = How.ID, using = "q")
	private WebElement searchBoxField;
	@FindBy(how = How.CSS, using = searchOptionCss)
	private List<WebElement> searchOptions;

	// Actions
	public void navigate() {
		driver.get(URL);
	}

	public void enterSearchContent(String content) {
		searchBoxField.sendKeys(content);
	}

	public void verifySearchResults(String content) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(searchOptionCss), searchOptions.size()));
		for (WebElement searchOption : searchOptions) {
			assertTrue(searchOption.getText().toLowerCase().contains(content));
		}
	}

	public void clickChooseOption(String content) {
		for (WebElement searchOption : searchOptions) {
			if (searchOption.getText().contains(content)) {
				searchOption.click();
			}
		}
	}

}
