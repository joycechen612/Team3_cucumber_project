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

public class YipingsearchresultPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Shop zo skin health')]")
	private WebElement resultMessage;

	// Constructor
	public YipingsearchresultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyresultmessage(String expectedresultMessage) {
		Util.wait(3);
		try {

			String actualresultMessage = resultMessage.getText();
			assertEquals(expectedresultMessage.trim(), actualresultMessage.trim(), "Result message does not match");
		} catch (NoSuchElementException e) {
			assertTrue(false, "Expected an result message");
		}
	}
}

	

