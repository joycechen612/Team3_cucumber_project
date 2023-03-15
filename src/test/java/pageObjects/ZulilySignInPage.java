package pageObjects;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZulilySignInPage {
	// Local Variable
	private WebDriver driver;
	private static final String expectedPageHeader = "Sign In";
	private static final String newUserpageURL = "https://www.zulily.com/?newUser&signinModal&signinModal";

	// elements
	@FindBy(how = How.XPATH, using = "//h3[text()='Sign In']")
	private WebElement header;
	@FindBy(how = How.ID, using = "signin_email")
	private WebElement emailField;
	@FindBy(how = How.ID, using = "signin_password")
	private WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//button[@value='Login']")
	private WebElement shopNowButton;
	@FindBy(how = How.ID, using = "err-msg-sign-in")
	private WebElement errorMessageField;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'floating_footer')]/a")
	private List<WebElement> linksField;

	// Constructor
	public ZulilySignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action
	public void verifyHeader() {
		assertEquals(expectedPageHeader, header.getText());
	}

	public void enterEmailPw(String email, String password) {
		emailField.sendKeys(email == null ? "" : email);
		passwordField.sendKeys(password == null ? "" : password);
	}

	public void clickShopNow() {
		shopNowButton.click();
	}

	public void validationErroMessage(String message) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errorMessageField));
		assertTrue(errorMessageField.getText().contains(message));
	}

	public void navigateToNewUser() {
		driver.get(newUserpageURL);
	}

	public void clickLinks() {
		String parentWindow = driver.getWindowHandle();
		String[] expectedPageTitles = { "How Zulily Works | Zulily", "Why Zulily?", "Contact Us | Zulily",
				"Investor Relations :: Qurate Retail, Inc. (QRTEA)", "Zulily Careers - Qurate Retail Group Careers",
				"Privacy Practices | Zulily", "Zulily | Go fun Shopping. Save Big." };
		List<String> links = new ArrayList<>();
		List<String> actualPageTitles = new ArrayList<>();
		for (WebElement eachLink : linksField) {
			links.add(eachLink.getAttribute("href"));
		}
		for (String link : links) {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(link);
			actualPageTitles.add(driver.getTitle());
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		int index = 0;
		for (String pgTitle : actualPageTitles) {
			assertTrue(pgTitle.contains(expectedPageTitles[index++]));
		}

	}

}
