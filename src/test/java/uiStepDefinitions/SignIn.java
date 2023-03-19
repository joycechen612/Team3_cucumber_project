package uiStepDefinitions;

import io.cucumber.java.en.*;
import utilities.PageManager;

public class SignIn {

	PageManager pages = PageManager.getInstance();

	@When("user click Sign in button")
	public void userClickSignInButton() {
		pages.homePage().clickSignInButton();
	}

	@Then("user should see a Sign In page pop out")
	public void userShouldSeeASignInPagePopOut() {
		pages.signInPage().verifyHeader();
	}

	@When("user enter invalid {string} and {string}")
	public void userEnterInvalidAnd(String email, String password) {
		pages.signInPage().enterEmailPw(email, password);
	}

	@Then("user click shop now button")
	public void userClickShopNowButton() {
		pages.signInPage().clickShopNow();
	}

	@Then("user should see {string} pop out")
	public void userShouldSeePopOut(String errorMessage) {
		pages.signInPage().validationErroMessage(errorMessage);

	}

}
