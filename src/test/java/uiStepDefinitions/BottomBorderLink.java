package uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.PageManager;

public class BottomBorderLink {

	PageManager pages = PageManager.getInstance();

	@Given("user come to Zulily newUser page")
	public void navigateToNewUserPage() {
		pages.signInPage().navigateToNewUser();
	}

	@Then("user see some titles on the bottom border then open the links in new Tab one by one and verify the page title in each new tab")
	public void userSeeSomeTitlesOnTheBottomBorderThenOpenTheLinksInNewTabOneByOne() {
		pages.signInPage().clickLinks();
	}
}
