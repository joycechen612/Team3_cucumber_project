package uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.PageManager;

public class YipingHomePageSteps {

	private PageManager pages = PageManager.getInstance();

	@Given("user is on the zulily homepage")
	public void userisonthezulilyhomepage() {
		pages.yipingHomePage().navigate();

	}

	@When("user navigates to the login page")
	public void userNavigatesToTheLoginPage() {
		pages.yipingNavbarPage().navigateToLoginPage();

	}
}
