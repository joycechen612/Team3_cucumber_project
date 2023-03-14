package uiStepDefinitions;

import io.cucumber.java.en.*;
import utilities.PageManager;

public class ZulilySignIn {

	PageManager pages = PageManager.getInstance();

	@When("user click Sign in button")
	public void userClickSignInButton() {
		pages.zulilyHomePage().clickSignInButton();
	}

	@Then("user should see a Sign In page pop out")
	public void userShouldSeeASignInPagePopOut() {
		pages.zulilySignInPage().verifyHeader();
	}

	@When("user enter invalid {string} and {string}")
	public void userEnterInvalidAnd(String email, String password) {
		pages.zulilySignInPage().enterEmailPw(email, password);
	}

	@Then("user click shop now button")
	public void userClickShopNowButton() {
		pages.zulilySignInPage().clickShopNow();
	}

	@Then("user should see {string} pop out")
	public void userShouldSeePopOut(String errorMessage) {
		pages.zulilySignInPage().validationErroMessage(errorMessage);

	}

}
