package uiStepDefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import utilities.PageManager;

public class Common {
	
	private PageManager pages = PageManager.getInstance();

	
	@Given("user login zulily account")
	public void userLoginZulilyAccount(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		pages.homePage().navigate();
		pages.homePage().clickSignInButton();
		pages.homePage().enterEmailAndPW(data.get("username"), data.get("password"));
	}

}
