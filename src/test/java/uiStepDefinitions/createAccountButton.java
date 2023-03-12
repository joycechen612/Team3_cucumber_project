package uiStepDefinitions;

import io.cucumber.java.en.*;
import utilities.PageManager;

public class createAccountButton {

	private PageManager pages = PageManager.getInstance();

	@Given("user come to HomeDepot homepage")
	public void userComeToTotalwineHomepage() {
		pages.homePage().navigate();
	}

	@Then("user click My Account then click Create an Account button")
	public void userClickCreateAccountButton() {
		pages.homePage().clickCreateAccountButton();
	}

	@Then("user should see Create an Online Account page")
	public void userShouldSeeCreateAnOnlineAccountPage() {
		pages.homePage().verifyCreateAccountPageLoad();

	}

}
