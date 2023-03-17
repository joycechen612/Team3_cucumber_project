package pageObjects;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class KaTomHomePage {

	private WebDriver driver;
	// local varibale
	public static final String URL = "https://www.katom.com/";
	private String firstNameVerify;
	// Elements
	@FindBy(how = How.XPATH, using = "//span[@class='align-middle d-none d-lg-inline']")
	private WebElement signinField;
	@FindBy(how = How.XPATH, using = "//a[@title='Create an Account']")
	private WebElement creatAccountButton;
	@FindBy(how = How.NAME, using = "first_name")
	private WebElement firstNameField;
	@FindBy(how = How.NAME, using = "last_name")
	private WebElement lastNameField;
	@FindBy(how = How.ID, using = "create_email")
	private WebElement emailField;
	@FindBy(how = How.ID, using = "create_password")
	private WebElement passwordField;
	@FindBy(how = How.XPATH, using = "(//button[text()='Create Account'])[2]")
	private WebElement creatAccountSubmitButton;
	@FindBy(how = How.CSS, using = "h1.account_management_title")
	private WebElement verifyName;

	// Constructor
	public KaTomHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Action
	public void navigate() {
		driver.get(URL);
	}

	public void clickSignInbutton() {
		signinField.click();
	}

	public void clickCreatAccountButton() {
		creatAccountButton.click();
	}

	public void fillIninfo(String firstName, String lastName, String email, String password) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		firstNameVerify = firstName;

	}

	public void clickfinalCreat() {
		creatAccountSubmitButton.click();
	}

	public void verifyNameText() {
		assertTrue(verifyName.getText().contains(firstNameVerify));
	}

}
