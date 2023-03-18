package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.LumaHomePage;
import pageObjects.LumaSearchResultPage;
import pageObjects.YipingHomePage;
import pageObjects.YipingLoginPage;
import pageObjects.YipingNavbarPage;
import pageObjects.YipingSearchPage;
import pageObjects.YipingsearchresultPage;
import pageObjects.ZulilyGiftCardPage;
import pageObjects.HomeDepotHomePage;
import pageObjects.ZulilySearchResultPage;
import pageObjects.ZulilySignInPage;
import pageObjects.ZulilyToysPage;
import uiStepDefinitions.YipingsearchPageSteps;
import pageObjects.ZulilyHomePage;

public class PageManager {

	private static PageManager pageManager;
	private WebDriver driver;
	private LumaHomePage lumaHomePage;
	private LumaSearchResultPage lumaSearchResultPage;
	private HomeDepotHomePage homePage;
	private ZulilyHomePage zulilyHomePage;
	private ZulilySearchResultPage searchResultPage;
	private ZulilyToysPage zulilyToysPage;
	private ZulilySignInPage zulilySignInPage;
	private ZulilyGiftCardPage zulilyGiftCardPage;
	private YipingHomePage yipingHomePage;
	private YipingLoginPage yipingLoginPage;
	private YipingNavbarPage yipingNavbarPage;
	private YipingSearchPage yipingSearchPage;
	private YipingsearchresultPage yipingsearchresultPage;

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

	public ZulilyToysPage zulilyToysPage() {
		if (zulilyToysPage == null) {
			zulilyToysPage = new ZulilyToysPage(driver);
		}
		return zulilyToysPage;
	}

	public ZulilySignInPage zulilySignInPage() {
		if (zulilySignInPage == null) {
			zulilySignInPage = new ZulilySignInPage(driver);
		}
		return zulilySignInPage;
	}

	public ZulilyGiftCardPage zulilyGiftCardPage() {
		if (zulilyGiftCardPage == null) {
			zulilyGiftCardPage = new ZulilyGiftCardPage(driver);
		}
		return zulilyGiftCardPage;
	}

	public YipingHomePage yipingHomePage() {
		if (yipingHomePage == null) {
			yipingHomePage = new YipingHomePage(driver);
		}
		return yipingHomePage;
	}

	public YipingLoginPage yipingLoginPage() {
		if (yipingLoginPage == null) {
			yipingLoginPage = new YipingLoginPage(driver);
		}
		return yipingLoginPage;
	}

	public YipingNavbarPage yipingNavbarPage() {
		if (yipingNavbarPage == null) {
			yipingNavbarPage = new YipingNavbarPage(driver);
		}
		return yipingNavbarPage;

	}

	public YipingSearchPage yipingSearchPage() {
		if (yipingSearchPage == null) {
			yipingSearchPage = new YipingSearchPage(driver);
		}
		return yipingSearchPage;
	}

	public YipingsearchresultPage yipingsearchresultPage() {
		if (yipingsearchresultPage == null) {
			yipingsearchresultPage = new YipingsearchresultPage(driver);
		}
		return yipingsearchresultPage;
	}
}
