package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZulilyGiftCardPage {

	// Local Variable
	private WebDriver driver;
	private static final String expectedURL = "https://www.zulily.com/jump/giftcardshop";

	// Elements
	@FindBy(how = How.XPATH, using = "(//img[@alt='HAPPY BIRTHDAY'])[1]")
	private WebElement customizeField;
	@FindBy(how = How.ID, using = "giftcard_recipientName")
	private WebElement recipientNameField;
	@FindBy(how = How.NAME, using = "product_options[giftcard_recipient_email]")
	private WebElement emailField;
	@FindBy(how = How.ID, using = "giftcard_senderName")
	private WebElement fromField;
	@FindBy(how = How.CSS, using = "div.react-datepicker__current-month")
	private WebElement currentDateField;
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Next Month']")
	private WebElement nextMonthButton;
	@FindBy(how = How.TAG_NAME, using = "textarea")
	private WebElement messageField;
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'ButtonRoot-CartButton')]")
	private WebElement addToCartButton;
	@FindBy(how = How.ID, using = "giftcard_sendDate")
	private WebElement giftCardSendDateField;
	@FindBy(how = How.CSS, using = "span.price ")
	private WebElement shoppingCartGiftCardAmount;
	@FindBy(how = How.XPATH, using = "(//span[@class='option-value'])[1]")
	private WebElement shoppingCardFrom;
	@FindBy(how = How.XPATH, using = "(//span[@class='option-value'])[2]")
	private WebElement shoppingCardRecipientName;
	@FindBy(how = How.XPATH, using = "(//span[@class='option-value'])[3]")
	private WebElement shoppingCardMessage;
	@FindBy(how = How.XPATH, using = "(//span[@class='option-value'])[4]")
	private WebElement shoppingCardDateInfo;

	// Constructor
	public ZulilyGiftCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void verifyGiftCardPageURL() {
		assertTrue(driver.getCurrentUrl().equals(expectedURL));
	}

	public void clickCustomizedButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", customizeField);
	}

	public void fillInInformation(String amount, String dateInfo, String recipientName, String email, String from,
			String message) {
		utilities.Util.wait(5);
		driver.findElement(By.xpath("//label[text()='$" + amount + ".00']")).click();
		giftCardSendDateField.click();
		utilities.Util.wait(3);
		int expectedMonth = Integer.parseInt(dateInfo.split("/")[0].trim());
		int expectedDate = Integer.parseInt(dateInfo.split("/")[1].trim());
		String currentDateText = currentDateField.getText();
		int currentMonth = monthToNumber(currentDateText.split(" ")[0].trim());
		int currentYear = Integer.parseInt(currentDateText.split(" ")[1].trim());
		while (currentMonth != expectedMonth) {
			nextMonthButton.click();
			currentMonth = monthToNumber(currentDateField.getText().split(" ")[0].trim());
		}
		driver.findElement(By.xpath("//div[text()='" + expectedDate + "']")).click();
		recipientNameField.sendKeys(recipientName);
		emailField.sendKeys(email);
		fromField.sendKeys(from);
		messageField.clear();
		messageField.sendKeys(message);
		addToCartButton.click();
	}

	public void verifyGiftCardInfo(String amount, String dateInfo, String recipientName, String email, String from,
			String message) {
		assertTrue(shoppingCartGiftCardAmount.getText().contains(amount));
		if (shoppingCardFrom.getText().contains(from) && shoppingCardRecipientName.getText().contains(recipientName)
				&& shoppingCardMessage.getText().contains(message)
				&& shoppingCardDateInfo.getText().contains(dateInfo)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	public int monthToNumber(String month) {
		Map<String, Integer> months = new HashMap<>();
		months.put("January", 1);
		months.put("February", 2);
		months.put("March", 3);
		months.put("April", 4);
		months.put("May", 5);
		months.put("June", 6);
		months.put("July", 7);
		months.put("August", 8);
		months.put("September", 9);
		months.put("October", 10);
		months.put("November", 11);
		months.put("December", 12);
		return months.get(month);
	}

}
