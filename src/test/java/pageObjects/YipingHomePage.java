package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class YipingHomePage {
   
	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://www.zulily.com/?irclickid=1Kf2nrQVrxyNWcoyN1RyT3oEUkARsr0lRQvdRM0&irgwc=1&tid=33338180_585159_150372_Connexity%20US_9643_zcvp2_Influencers&linkName=Online%20Tracking%20Link&SID=Influencers";

	// Elements
    
	// Constructor
	public YipingHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void navigate() {
		driver.get(URL);
	}

}

	
	
