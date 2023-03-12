package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

public class HomePage {

	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://www.homedepot.com/";
	private static String createAccoutPageTitle = "Create an Account";

	// Elements
	
	@FindBy(how = How.CSS, using = ".headerMyAccountTitle.MyAccount__status.hide.show--sm")
	private WebElement myAccountButton;
	
	@FindBy(how = How.XPATH, using = "(//span[text()='Create an Account'])[2]")
	private WebElement createAccountButton;
	
	@FindBy(how = How.XPATH, using = "//p[@data-automation-id='signInHeader']")
	private WebElement createAccountPageTitle;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void navigate() {
		driver.get(URL);
	}

	public void clickCreateAccountButton() {
		myAccountButton.click();
		createAccountButton.click();
	}

	public void verifyCreateAccountPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(createAccountPageTitle));
		String actualTitle = createAccountPageTitle.getText();
		assertEquals(createAccoutPageTitle, actualTitle, "created account button test failed");
	}

}
