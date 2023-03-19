package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.AddressPage;
import pageObjects.GiftCardPage;
import pageObjects.SearchResultPage;
import pageObjects.SignInPage;
import pageObjects.ToysPage;
import pageObjects.HomePage;

public class PageManager {

	private static PageManager pageManager;
	private WebDriver driver;
	private HomePage homePage;
	private SearchResultPage resultPage;
	private ToysPage toysPage;
	private SignInPage signInPage;
	private GiftCardPage giftCardPage;
	private AddressPage addressPage;

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

	public SearchResultPage searchResultPage() {
		if (resultPage == null) {
			resultPage = new SearchResultPage(driver);
		}
		return resultPage;
	}

	public ToysPage toysPage() {
		if (toysPage == null) {
			toysPage = new ToysPage(driver);
		}
		return toysPage;
	}

	public SignInPage signInPage() {
		if (signInPage == null) {
			signInPage = new SignInPage(driver);
		}
		return signInPage;
	}

	public GiftCardPage giftCardPage() {
		if (giftCardPage == null) {
			giftCardPage = new GiftCardPage(driver);
		}
		return giftCardPage;
	}

	public AddressPage addressPage() {
		if (addressPage == null) {
			addressPage = new AddressPage(driver);
		}
		return addressPage;
	}

}
