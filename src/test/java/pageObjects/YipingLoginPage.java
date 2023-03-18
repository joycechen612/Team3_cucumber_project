package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Util;

public class YipingLoginPage {
	
	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://www.zulily.com/?irclickid=1Kf2nrQVrxyNWcoyN1RyT3oEUkARstw1RQvdRM0&irgwc=1&tid=33338180_585159_150372_Connexity%20US_9643_zcvp2_Influencers&linkName=Online%20Tracking%20Link&SID=Influencers";
//	private static final String TEXT = "Hi yiping";

	// Elements
	@FindBy(how = How.NAME, using = "login[username]")
	private WebElement emailField;

	@FindBy(how = How.NAME, using = "login[password]")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//button[@value='Login']")
	private WebElement loginButton;

//	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Hi yiping')])[1]")
//	private WebElement pageText;
	
	@FindBy(how = How.ID, using = "err-msg-sign-in")
	private WebElement errorAlert;


	// Constructor
	public YipingLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void navigate() {
		driver.get(URL);
	}

	public void login(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	public void userEntersUsernameAndPassword(String email, String password) {
		emailField.sendKeys(email == null ? "" : email);
		passwordField.sendKeys(password == null ? "" : password);
	
	}

	public void userClicksOnTheLoginButton() {
		loginButton.click();
	}

//	public void VerifyLoginPageLoad() {
//		Util.wait(3);
//		String actualUrl = driver.getCurrentUrl();
//		assertEquals(URL, actualUrl);
//
//		String actualpageText = pageText.getText();
//		assertEquals(TEXT, actualpageText);
//	}


	public void validateSingleErrorMessage(String expectedErrorMessage) {
        Util.wait(6);
		try {
			
			String actualErrorMessage = errorAlert.getText();
			assertEquals(expectedErrorMessage.trim(), actualErrorMessage.trim(), "Error message does not match");
		} catch (NoSuchElementException e) {
			assertTrue(false, "Expected an error alert");

		}
	}
}

	


