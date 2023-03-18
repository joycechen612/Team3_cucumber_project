package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YipingNavbarPage {

	// Local Variable
	private WebDriver driver;

	// Elements
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Already a Member?')]")
	private WebElement loginLink;

	// Constructor
	public YipingNavbarPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToLoginPage() {
		loginLink.click();
	}

}

