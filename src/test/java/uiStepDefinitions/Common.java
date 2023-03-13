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
		pages.zulilyHomePage().navigate();
		pages.zulilyHomePage().clickSignInButton();
		pages.zulilyHomePage().enterEmailAndPW(data.get("username"), data.get("password"));
	}

}
