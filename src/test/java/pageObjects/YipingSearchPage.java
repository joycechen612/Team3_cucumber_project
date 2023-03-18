package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YipingSearchPage {
	

	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://www.google.com/";

	// Elements
	@FindBy(how = How.XPATH, using = "//input[@title='Search']")
	private WebElement searchlField;

	@FindBy(how = How.XPATH, using = "(//input[@name='btnK'])[1]")
	private WebElement searchbutton;

	// Constructor
	public YipingSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Actions
	public void navigate() {
		driver.get(URL);
	}

	public void searchlField(String Text) {
		searchlField.sendKeys(Text);

	}

	public void searchbutton() {
		searchbutton.click();

	}

}

	


