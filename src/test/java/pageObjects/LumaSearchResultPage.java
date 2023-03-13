package pageObjects;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Util;

public class LumaSearchResultPage {
// Local Variable
	private WebDriver driver;
//	Elements
@FindBy(how= How.XPATH,using="//span[@class='base']")
private WebElement searchResult;

// Constructor ?
public LumaSearchResultPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

// Actions
public void validate(String expectedSearchInformaion) {
	boolean contains = false;
	if (searchResult.getText().contains(expectedSearchInformaion)) {
		contains=true;
	}
  assertTrue(contains,"the serch information is not contains");
}



}
