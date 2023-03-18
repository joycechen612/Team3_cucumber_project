package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import POJO.ZulilyAddressInfo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ZuliluAddressPage {

	// Local Variable
	private WebDriver driver;
	private static final String expectedPageTitle = "My Account";

	// Elements
	@FindBy(how = How.XPATH, using = "//div[@id='account-menu']/h2")
	private WebElement myAccoutText;
	@FindBy(how = How.XPATH, using = "//a[text()='Address Book']")
	private WebElement addressBookField;
	@FindBy(how = How.CSS, using = "a.new-address")
	private WebElement addAnAddressButton;
	@FindBy(how = How.NAME, using = "address[firstname]")
	private WebElement firnameField;
	@FindBy(how = How.NAME, using = "address[lastname]")
	private WebElement lastNameField;
	@FindBy(how = How.NAME, using = "address[company]")
	private WebElement companyField;
	@FindBy(how = How.NAME, using = "address[street1]")
	private WebElement addressField;
	@FindBy(how = How.NAME, using = "address[city]")
	private WebElement cityField;
	@FindBy(how = How.NAME, using = "address[country_id]")
	private WebElement countryField;
	@FindBy(how = How.XPATH, using = "//select[@name='address[country_id]']/option[1]")
	private WebElement countrySelectedField;
	@FindBy(how = How.CSS, using = "select[name='address[region_id]'][title='State']")
	private WebElement stateSelectField;
	@FindBy(how = How.NAME, using = "address[postcode]")
	private WebElement zipCodeField;
	@FindBy(how = How.NAME, using = "address[telephone]")
	private WebElement telephoneField;
	@FindBy(how = How.NAME, using = "address[password_check]")
	private WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox'][@name='address[save]']")
	private WebElement saveAddress;
	@FindBy(how = How.NAME, using = "address[default]")
	private WebElement setDefault;
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'address-form-submit')]")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//span[@class='address-firstname']")
	private WebElement addressBookFirstName;
	@FindBy(how = How.XPATH, using = "//span[@class='address-lastname']")
	private WebElement addressBookLastName;


	// Constructor
	public ZuliluAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action
	public void verifyPageTitle() {
		utilities.Util.wait(3);
		assertEquals(expectedPageTitle, myAccoutText.getText());
	}

	public void clickAddresBook() {
		addressBookField.click();
	}

	public void clickAddAnAddress() {
		addAnAddressButton.click();
	}

	public void fillInInfor(ZulilyAddressInfo addressinfo) {
		firnameField.sendKeys(addressinfo.firstName);
		lastNameField.sendKeys(addressinfo.lastName);
		companyField.sendKeys(addressinfo.company);
		addressField.sendKeys(addressinfo.address);
		cityField.sendKeys(addressinfo.city);
		Select countrySelect = new Select(countryField);
		if (!countrySelectedField.getText().contains(addressinfo.country)) {
			countrySelect.selectByVisibleText(addressinfo.country);
		}
		utilities.Util.wait(2);
		List<WebElement> options = stateSelectField.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (option.getText().equals(addressinfo.state)) {
				option.click();
				break;
			}
		}
		utilities.Util.wait(3);
		zipCodeField.sendKeys(addressinfo.zipCode);
		telephoneField.sendKeys(addressinfo.telephone);
		passwordField.sendKeys(addressinfo.password);
		if (addressinfo.notSave) {
			saveAddress.click();
		}
		if (addressinfo.notSetDefault) {
			setDefault.click();
		}
		saveButton.click();
		utilities.Util.wait(8);
	}

	public void validationAddressInfo(ZulilyAddressInfo addressinfo) {
		assertEquals(addressBookFirstName.getText(), addressinfo.firstName);
		assertEquals(addressBookLastName.getText(), addressinfo.lastName);
	}

}
