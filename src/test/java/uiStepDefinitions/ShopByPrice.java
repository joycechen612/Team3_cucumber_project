package uiStepDefinitions;

import io.cucumber.java.en.*;
import utilities.DataManager;
import utilities.PageManager;

public class ShopByPrice {

	PageManager pages = PageManager.getInstance();
	DataManager dataManager = DataManager.getInstance();

	@Then("user click Shop By Category on the navi bar")
	public void userClickShopByCategoryOnTheNaviBar() {
		pages.homePage().clickshopByCategory();
	}

	@Then("user click Toys & Games")
	public void userClickToysGames() {
		pages.toysPage().clickToysGameField();
	}

	@Then("user click ALL PRICES button check ${int} - ${int}")
	public void userClickALLPRICESButtonCheck(int lowPrice, int highPrice) {
		pages.toysPage().choosePirceRange(lowPrice, highPrice);
		dataManager.setLowPrice(lowPrice);
		dataManager.setHighPrice(highPrice);
	}

	@Then("verify all the result come out are in the range")
	public void verifyAllTheResultComeOutAreInTheRange() {
		pages.toysPage().validateResultPrice(dataManager.getLowPrice(), dataManager.getHighPrice());
	}

}
