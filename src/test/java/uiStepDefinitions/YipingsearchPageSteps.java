package uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.PageManager;

public class YipingsearchPageSteps {

	private PageManager pages = PageManager.getInstance();

	@Given("user is on google search page")
	public void userIsOnGoogleSearchPage() {
		pages.yipingSearchPage().navigate();
	}

	@When("user enters text -{string} in search box")
	public void userenters_extinsearchbox(String Text) {
		pages.yipingSearchPage().searchlField(Text);
	}

	@Then("user clicks searchbutton")
	public void userclickssearchbutton() {

		pages.yipingSearchPage().searchbutton();
	}

	@Then("user should see -{string} search result is on the page")
	public void usershouldseesearchresultisonthepage(String expectedresultMessage) {
		{

			pages.yipingsearchresultPage().verifyresultmessage(expectedresultMessage);
		}

	}
}
