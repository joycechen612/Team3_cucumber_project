package uiStepDefinitions;


import io.cucumber.java.en.*;
import utilities.PageManager;

public class lumaSearchFunction {
	private PageManager pages=PageManager.getInstance();
	@Given("Navigate to Luma Homepage")
	public void navigate_to_luma_homepage() {
	    pages.lumaHomePage().navigate();
	   
	}
	@Then("user Enter search information {string}")
	public void user_enter_search_information(String searchInformation) {
		 pages.lumaHomePage().enterSearchInformation(searchInformation);
		 
	}
	
	@Then("click the search button")
	public void click_the_search_button() {
	    pages.lumaHomePage().clickSearchButton();
	}
	@Then("the search reasult {string} should be on the page")
	public void the_search_reasult_should_be_on_the_page(String expectedSearchInformaion ) {
	    pages.lumaSearchResultPage().validate(expectedSearchInformaion);
	}


}
