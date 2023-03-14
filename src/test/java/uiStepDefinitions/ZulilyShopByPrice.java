package uiStepDefinitions;

import io.cucumber.java.en.*;
import utilities.DataManager;
import utilities.PageManager;

public class ZulilyShopByPrice {

	PageManager pages = PageManager.getInstance();
	DataManager dataManager = DataManager.getInstance();

	@Then("user click Shop By Category on the navi bar")
	public void userClickShopByCategoryOnTheNaviBar() {
		pages.zulilyHomePage().clickshopByCategory();
	}

	@Then("user click Toys & Games")
	public void userClickToysGames() {
		pages.zulilyToysPage().clickToysGameField();
	}

	@Then("user click ALL PRICES button check ${int} - ${int}")
	public void userClickALLPRICESButtonCheck(int lowPrice, int highPrice) {
		pages.zulilyToysPage().choosePirceRange(lowPrice, highPrice);
		dataManager.setLowPrice(lowPrice);
		dataManager.setHighPrice(highPrice);
	}

	@Then("verify all the result come out are in the range")
	public void verifyAllTheResultComeOutAreInTheRange() {
		pages.zulilyToysPage().validateResultPrice(dataManager.getLowPrice(), dataManager.getHighPrice());
	}

}
