package uiStepDefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DataManager;
import utilities.PageManager;

public class ZulilyShoppingBasket {
	private PageManager pages = PageManager.getInstance();
	private DataManager dataManager = DataManager.getInstance();

	@Then("user add one specific product to the shopping basket")
	public void userAddOneSpecificProductToTheShoppingBasket(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		String productName = data.get("productName");
		dataManager.setproductName(productName);
		pages.zulilyHomePage().enterSearchContentThenSubmit(productName);
		pages.searchResultPage().clickSearchResultItem();
		pages.searchResultPage().clickAddToBasket();
		pages.searchResultPage().verifyProductName(productName);
	}

	@Then("user click edit button change the order quantity to {string} then click update")
	public void userClickEditButtonChangeTheOrderQuantityToThenClickUpdate(String quantity) {
		dataManager.setOrderQty(quantity);
		pages.searchResultPage().changOrderQty(quantity);

	}

	@Then("the order quantity should change to updated number")
	public void theOrderQuantityShouldChangeToUpdatedNumber() {
		pages.searchResultPage().validateOrderQty(dataManager.getOrderQty());
	}

}
