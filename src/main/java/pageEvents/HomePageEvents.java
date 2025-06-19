package pageEvents;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.HomePageElements;
import utils.CommonMethods;
import utils.ElementFetch;
import utils.PageConstants;

public class HomePageEvents extends BaseTest{

	ElementFetch ele = new ElementFetch();
	BaseTest bst= new BaseTest();
	Logger log = LogManager.getLogger(HomePageEvents.class);
	WebDriver driver;
	
	public void clickOnNiftyFifty() {
		log.info("Navigate to nifty 50 from nse india");
		WebElement nifty50 = ele.getWebElement("XPATH", HomePageElements.niftyFifty);
		nifty50.click();
		CommonMethods.switchWindow();
	}
	
	public void verifyTitle(String title) {
		log.info("Title of the page found to be: " +CommonMethods.getTitle() );
		Assert.assertEquals(CommonMethods.getTitle(), title);
	}
}
