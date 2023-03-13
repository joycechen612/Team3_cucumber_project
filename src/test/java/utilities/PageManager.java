package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LumaHomePage;
import pageObjects.LumaSearchResultPage;

public class PageManager {

	private static PageManager pageManager;
	private WebDriver driver;
	private HomePage homePage;
	private LumaHomePage lumaHomePage;
	private LumaSearchResultPage lumaSearchResultPage;

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
	
	public HomePage homePage() {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}
		return homePage;
	}
	public LumaHomePage lumaHomePage() {
		if (lumaHomePage == null) {
			lumaHomePage = new LumaHomePage(driver);
		}
		return lumaHomePage;
	}
	public LumaSearchResultPage lumaSearchResultPage() {
		if (lumaSearchResultPage == null) {
			lumaSearchResultPage = new LumaSearchResultPage(driver);
		}
		return lumaSearchResultPage;
	}
}
