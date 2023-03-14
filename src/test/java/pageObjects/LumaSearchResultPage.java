package pageObjects;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LumaSearchResultPage {
	// Local Variable
	private WebDriver driver;
	// Elements
	@FindBy(how = How.XPATH, using = "//span[@class='base']")
	private WebElement searchResult;

	// Constructor
	public LumaSearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validate(String expectedSearchInformaion) {
		assertTrue(searchResult.getText().contains(expectedSearchInformaion), "the serch information is not contains");
	}

}
