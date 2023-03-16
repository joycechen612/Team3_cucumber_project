package uiStepDefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.PageManager;

public class ZulilySearch {
	private PageManager pages = PageManager.getInstance();
	private Map<String, String> data;

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

	@Then("user choose brand name {string}")
	public void user_choose(String content) {
		pages.zulilyHomePage().clickChooseOption(content);
	}

	@Then("verify {string} should on the each search result on first page")
	public void verify_should_on_the_page_head(String content) {
		pages.searchResultPage().verifySearchTitle(content);

	}

	@Then("on the search header pick some filter")
	public void onTheSearchHeaderPickSomeFilter(DataTable dataTable) {
		data = dataTable.asMaps().get(0);
		pages.searchResultPage().pickFilter(data.get("brandName"), data.get("departmentName"),
				data.get("subcategories"), data.get("priceRange"), data.get("size"));

	}

	@Then("verify the result items meet the requirements")
	public void verifyTheResultItemsMeetTheRequirements() {
		pages.searchResultPage().verifyfilterSearchResult(data.get("brandName"), data.get("priceRange"),
				data.get("departmentName"));

	}
}
