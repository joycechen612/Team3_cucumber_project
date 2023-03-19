package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Util;

public class LumaHomePage {
	// local Variable
	private WebDriver driver;
	private static final String URL = "https://magento2.algolia.com/";
	// Elements
	@FindBy(how = How.ID, using = "search")
	private WebElement searchField;
	@FindBy(how = How.ID, using = "algolia-glass")
	private WebElement searchButton;
	@FindBy(how = How.XPATH, using = "//span[@class='base']")
	private WebElement searchResult;
	@FindBy(how = How.LINK_TEXT, using ="Create an Account")
	private WebElement createAccoutButton;


	// Constructor
	public LumaHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action
	public void navigate() {
		driver.get(URL);
	}

	public void enterSearchInformation(String searchInformation) {
		searchField.sendKeys(searchInformation);
	}

	public void clickSearchButton() {
		searchButton.click();
	}
	public void clickCreateAccountButton() {
		Util.wait(3);
		createAccoutButton.click();
	}

}
