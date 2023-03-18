package uiStepDefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.PageManager;


public class YipingLoginPageSteps {
	

	private PageManager pages = PageManager.getInstance();

	@When("user enters username and password")
	public void userEntersUsernameAndPassword(DataTable dataTable) {

		Map<String, String> data = dataTable.asMap();
		String username = data.get("username");
		String password = data.get("password");
		pages.yipingLoginPage().userEntersUsernameAndPassword(username, password);
	}

	@When("user clicks on the login button")
	public void userClicksOnTheLoginButton() {
		pages.yipingLoginPage().userClicksOnTheLoginButton();

	}
//
//	@Then("user should be see pagetext on the page")
//	public void VerifyLoginPageLoad() {
//		pages.loginPage().VerifyLoginPageLoad();

//	}

	@Then("user should see an error alert with the message - {string}")
	public void validateError(String expectedErrorMessage) {
		pages.yipingLoginPage().validateSingleErrorMessage(expectedErrorMessage);
	}

}
