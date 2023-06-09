package uiStepDefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import utilities.PageManager;

public class GiftCard {

	PageManager pages = PageManager.getInstance();

	private Map<String, String> data;

	@Then("user click Send a Gift Card")
	public void userClickSendAGiftCard() {
		pages.homePage().clickGiftCard();

	}

	@Then("gift card page should be load")
	public void giftCardPageShouldBeLoad() {
		pages.giftCardPage().verifyGiftCardPageURL();

	}

	@Then("user click customize button under birthday")
	public void userClickCustomizeButtonUnderBirthday() {
		pages.giftCardPage().clickCustomizedButton();

	}

	@Then("user fill in the information for the gift card and click add to basket button")
	public void userFillInTheInformationForTheGiftCard(DataTable dataTable) {
		data = dataTable.asMaps().get(0);
		pages.giftCardPage().fillInInformation(data.get("amount"), data.get("send date"),
				data.get("recipient name"), data.get("recipient email"), data.get("from"), data.get("message"));
	}

	@Then("verify the gift card info in the shopping basket page")
	public void verifyTheGiftCardInfoInTheShoppingBasketPage() {
		pages.giftCardPage().verifyGiftCardInfo(data.get("amount"), data.get("send date"),
				data.get("recipient name"), data.get("recipient email"), data.get("from"), data.get("message"));
	}
}
