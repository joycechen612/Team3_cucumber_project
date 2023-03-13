package uiStepDefinitions;

import io.cucumber.java.en.*;
import utilities.PageManager;

public class Search {
	private PageManager pages = PageManager.getInstance();

	@Given("user come to Zulily homepage")
	public void userNavigateToHomepage() {
		pages.zulilyHomePage().navigate();
	}

	@Then("user enter {string} in the searchBox")
	public void user_enter_in_the_search_box(String content) {
		pages.zulilyHomePage().enterSearchContent(content);
	}

	@Then("user should verify all the drop down options contains keyword {string}")
	public void user_show_verify_all_the_drop_down_options_contains_keyword(String content) {
		pages.zulilyHomePage().verifySearchResults(content);
	}

	@Then("user choose {string}")
	public void user_choose(String content) {
		pages.zulilyHomePage().clickChooseOption(content);
	}

	@Then("verify {string} should on the each search result")
	public void verify_should_on_the_page_head(String content){
		pages.searchResultPage().verifySearchTitle(content);

	}
}
