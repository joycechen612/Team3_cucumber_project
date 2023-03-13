package uiStepDefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.PageManager;

public class AddToCart {

	private PageManager pages = PageManager.getInstance();

	@Then("user enter one specific product name in the search box")
	public void userEnterOneSpecificProductNameInTheSearchBox(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		pages.zulilyHomePage().enterSearchContentThenSubmit(data.get("productName"));
	}

	@Then("the product should show up then user click it")
	public void theProductShouldShowUpThenUserClickIt() {
		pages.searchResultPage().clickSearchResultItem();
	}

	@Then("user click add to basket button")
	public void userClickAddToBasketButton() {
		pages.searchResultPage().clickAddToBasket();
	}

	@Then("user should see this product on Shopping Basket page")
	public void userShouldSeeThisProductOnShoppingBasketPage(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		pages.searchResultPage().verifyProductName(data.get("productName"));

	}

}
