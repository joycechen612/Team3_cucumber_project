package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.LumaHomePage;
import pageObjects.LumaSearchResultPage;
import pageObjects.ZuliluAddressPage;
import pageObjects.ZulilyGiftCardPage;
import pageObjects.HomeDepotHomePage;
import pageObjects.LumaCreateNewAccountPage;
import pageObjects.ZulilySearchResultPage;
import pageObjects.ZulilySignInPage;
import pageObjects.ZulilyToysPage;
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
<<<<<<< HEAD
	private ZuliluAddressPage zuliluAddressPage;

=======
	private LumaCreateNewAccountPage lumaCreateNewAccountPage;
>>>>>>> 9768ec8 (create new account)
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
	public LumaCreateNewAccountPage lumaCreateNewAccountPage() {
		if (lumaCreateNewAccountPage == null) {
			lumaCreateNewAccountPage = new LumaCreateNewAccountPage(driver);
		}
		return lumaCreateNewAccountPage;
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

	public ZuliluAddressPage zuliluAddressPage() {
		if (zuliluAddressPage == null) {
			zuliluAddressPage = new ZuliluAddressPage(driver);
		}
		return zuliluAddressPage;
	}

}
