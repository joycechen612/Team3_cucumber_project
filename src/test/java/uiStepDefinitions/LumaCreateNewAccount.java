package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pojo.LumaAccountInfor;
import utilities.DriverManager;
import utilities.PageManager;

public class LumaCreateNewAccount {
	private PageManager pages = PageManager.getInstance();
	private WebDriver driver = DriverManager.getInstance();

	@Given("click creat an account button")
	public void click_creat_an_account_button() {
		pages.lumaHomePage().clickCreateAccountButton();
	}

	@When("enter user infor and submits")
	public void enter_user_infor_and_submits(DataTable dataTable1) {
		Map<String, String> data = dataTable1.asMaps().get(0);
		String firstname = data.get("firstname");
		String lastname = data.get("lastname");
		Boolean subscribed = Boolean.valueOf(data.get("subscribed"));
		Boolean assistance = Boolean.valueOf(data.get("assistance"));
		String email = data.get("email");
		String password = data.get("password");
		String passwordconfimation = data.get("passwordconfimation");
		Boolean showPassword = Boolean.valueOf(data.get("showPassword"));
		pages.lumaCreateNewAccountPage().enterAccountinformation(firstname, lastname, subscribed, assistance, email,
				password, passwordconfimation, showPassword);
		pages.lumaCreateNewAccountPage().submitButtonClick();
	}

	@Then("validate the email address shows on the accout page")
	public void validate_the_email_address_shows_on_the_accout_page(DataTable dataTable) {
		String expecedEmailOnPage = dataTable.asMap().get("email");
		try {
			WebElement email = driver.findElement(By.xpath("//p/br[1]"));
			String actulEmail = email.getText();
			assertEquals(actulEmail, expecedEmailOnPage, "Email does not match,account not create success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
