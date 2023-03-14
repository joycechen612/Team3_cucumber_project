package pageObjects;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZulilySignInPage {
	// Local Variable
	private WebDriver driver;
	private static final String expectedPageHeader = "Sign In";

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

}
