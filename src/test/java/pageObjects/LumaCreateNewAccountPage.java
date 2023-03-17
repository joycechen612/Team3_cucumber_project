package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pojo.LumaAccountInfor;
import utilities.Util;


public class LumaCreateNewAccountPage {
	// Local Variable
	private WebDriver driver;
	private static final String expectedUrl = "https://magento2.algolia.com/customer/account/create/";
	// Elements
	@FindBy(how = How.XPATH, using = "//span[@class='base']")
	private WebElement pageTitleField;
	@FindBy(how = How.ID, using = "firstname")
	private WebElement firstnameField;
	@FindBy(how = How.ID, using = "lastname")
	private WebElement lastnameField;
	@FindBy(how = How.ID, using = "is_subscribed")
	private WebElement subscribedBoxFiedld;
	@FindBy(how = How.ID, using = "assistance_allowed_checkbox")
	private WebElement assistanceCheckboxFiedled;
	@FindBy(how = How.ID, using = "email_address")
	private WebElement emailFiedled;
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordFiedled;
	@FindBy(how = How.ID, using = "password-confirmation")
	private WebElement passwordconfirmationFiedled;
	@FindBy(how = How.ID, using = "show-password")
	private WebElement showpasswordFiedled;
	@FindBy(how = How.CLASS_NAME, using = "action submit primary")
	private WebElement submitButtonFiedled;
	
	// Constructor
	public LumaCreateNewAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validateUrl() {

		String acturlUrl = driver.getCurrentUrl();
		if (!acturlUrl.equals(expectedUrl)) {
			System.out.println("you are not in creat an accout page");
		}

	}

	public void enterAccountinformation(LumaAccountInfor LumaAccountInfor) {
		Util.wait(3);
		firstnameField.sendKeys(LumaAccountInfor.firstname);
		lastnameField.sendKeys(LumaAccountInfor.lastname);
		if (LumaAccountInfor.subscribed) {
			subscribedBoxFiedld.click();
		}
		if (LumaAccountInfor.assistance) {
			assistanceCheckboxFiedled.click();
		}
		emailFiedled.sendKeys(LumaAccountInfor.email);
		passwordFiedled.sendKeys(LumaAccountInfor.password);
		passwordconfirmationFiedled.sendKeys(LumaAccountInfor.passwordconfimation);
		if (LumaAccountInfor.showPassword) {
			showpasswordFiedled.click();
		}
		submitButtonFiedled.click();
	}
	
	
}