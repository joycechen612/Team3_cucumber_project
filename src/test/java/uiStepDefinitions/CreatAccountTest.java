package uiStepDefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import utilities.PageManager;

public class CreatAccountTest {

	private PageManager pages = PageManager.getInstance();

	@Given("user navigate to KaTom homepage")
	public void user_navigate_to_ka_tom_homepage() {
		pages.katomHomePage().navigate();
	}

	@When("user click on Sign in button and click on Creat Account button")
	public void user_click_on_sign_in_button_and_click_on_creat_account_button() {
		pages.katomHomePage().clickSignInbutton();
		pages.katomHomePage().clickCreatAccountButton();
	}

	@When("enter self info and click Creat Account")
	public void enter_self_info_and_click_creat_account(DataTable dataTable) {
		Map<String, String> data = dataTable.asMaps().get(0);
		pages.katomHomePage().fillIninfo(data.get("First Name"), data.get("Last Name"), data.get("Email"),
				data.get("Password"));
		pages.katomHomePage().clickfinalCreat();
	}

	@Then("the newly created account should be on the page")
	public void the_newly_created_account_should_be_on_the_page() {
		pages.katomHomePage().verifyNameText();
	}

}
