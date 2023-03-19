package uiStepDefinitions;

import java.util.Map;
import POJO.AddressInfo;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import utilities.DataManager;
import utilities.PageManager;

public class AddAddress {

	PageManager pages = PageManager.getInstance();
	DataManager data = DataManager.getInstance();

	@DataTableType
	public AddressInfo addressConvert(Map<String, String> data) {
		AddressInfo addressInfo = new AddressInfo(data.get("firstName"), data.get("lastName"),
				data.get("company"), data.get("Address"), data.get("city"), data.get("country"), data.get("state"),
				data.get("zipCode"), data.get("Telephone"), data.get("Password"),
				Boolean.parseBoolean(data.get("save")), Boolean.parseBoolean(data.get("setDefault")));
		return addressInfo;
	}

	@Then("user click my account button")
	public void userClickMyAccountButton() {
		pages.homePage().clickMyAccount();
	}

	@Then("user click account info")
	public void userClickAccountInfo() {
		pages.homePage().clickAccountInfo();
	}

	@Then("user navigate to my account page")
	public void userNavigateToMyAccountPage() {
		pages.addressPage().verifyPageTitle();
	}

	@Then("user click address book button")
	public void userClickAddressBookButton() {
		pages.addressPage().clickAddresBook();
	}

	@Then("user click add an address on Address Book page")
	public void userClickAddAnAddressOnAddressBookPage() {
		pages.addressPage().clickAddAnAddress();
	}

	@Then("user fill in the form then click save button")
	public void userFillInTheFormThenClickSaveButton(AddressInfo addressInfo) {
		pages.addressPage().fillInInfor(addressInfo);
		data.setAddressinfo(addressInfo);
	}

	@Then("the address should be save in the address book page")
	public void theAddressShouldBeSaveInTheAddressBookPage() {
		pages.addressPage().validationAddressInfo(data.getAddressinfo());
	}

}
