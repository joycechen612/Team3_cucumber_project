package uiStepDefinitions;

import java.util.Map;

import POJO.SearchFilter;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DataManager;
import utilities.PageManager;

public class Search {
	private PageManager pages = PageManager.getInstance();
	private Map<String, String> data;
	private DataManager dataManager = DataManager.getInstance();

	@Given("user come to Zulily homepage")
	public void userNavigateToHomepage() {
		pages.homePage().navigate();
	}

	@Then("user enter {string} in the searchBox")
	public void user_enter_in_the_search_box(String content) {
		pages.homePage().enterSearchContent(content);
	}

	@Then("user should verify all the drop down options contains keyword {string}")
	public void user_show_verify_all_the_drop_down_options_contains_keyword(String content) {
		pages.homePage().verifySearchResults(content);
	}

	@Then("user choose brand name {string}")
	public void user_choose(String content) {
		pages.homePage().clickChooseOption(content);
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
		SearchFilter zulilySearchFilter = new SearchFilter(dataManager.getProductName(),
				data.get("brandName"), data.get("departmentName"), data.get("subcategories"), data.get("priceRange"),
				data.get("size"));
		dataManager.setzulilySearchFilter(zulilySearchFilter);

	}

	@Then("verify the result items meet the requirements")
	public void verifyTheResultItemsMeetTheRequirements() {
		pages.searchResultPage().verifyfilterSearchResult(dataManager.getProductName(), data.get("brandName"),
				data.get("priceRange"), data.get("departmentName"));

	}
}
