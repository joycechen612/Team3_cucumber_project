package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.HomeDepotHomePage;
import pageObjects.ZulilySearchResultPage;
import pageObjects.ZulilyHomePage;

public class PageManager {

	private static PageManager pageManager;
	private WebDriver driver;
	private HomeDepotHomePage homePage;
	private ZulilyHomePage zulilyHomePage;
	private ZulilySearchResultPage searchResultPage;

	private PageManager(WebDriver driver) {
		this.driver = driver;
	}
	

	public static PageManager getInstance() {
		if (pageManager == null) {
			pageManager = new PageManager(DriverManager.getInstance());
		}
		return pageManager;
	}

	public static void cleanup() {
		if (pageManager != null) {
			pageManager = null;
		}
	}
	
	public HomeDepotHomePage homePage() {
		if (homePage == null) {
			homePage = new HomeDepotHomePage(driver);
		}
		return homePage;
	}
	
	public ZulilyHomePage zulilyHomePage() {
		if (zulilyHomePage == null) {
			zulilyHomePage = new ZulilyHomePage(driver);
		}
		return zulilyHomePage;
	}
	
	public ZulilySearchResultPage searchResultPage() {
		if (searchResultPage == null) {
			searchResultPage = new ZulilySearchResultPage(driver);
		}
		return searchResultPage;
	}

}
