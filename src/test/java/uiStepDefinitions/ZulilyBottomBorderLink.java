package uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.PageManager;

public class ZulilyBottomBorderLink {

	PageManager pages = PageManager.getInstance();

	@Given("user come to Zulily newUser page")
	public void navigateToNewUserPage() {
		pages.zulilySignInPage().navigateToNewUser();
	}

	@Then("user see some titles on the bottom border then open the links in new Tab one by one")
	public void userSeeSomeTitlesOnTheBottomBorderThenOpenTheLinksInNewTabOneByOne() {
		pages.zulilySignInPage().clickLinks();
	}

	@Then("verify the page title in each new tab")
	public void verifyThePageTitleInEachNewTab() {

	}

}
