package pageEvents;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.NiftyFiftyPageElements;
import utils.CommonMethods;
import utils.ElementFetch;
import utils.PageConstants;

public class NiftyFiftyPageEvents {
	ElementFetch elementFetch = new ElementFetch();
	WebDriver driver;
	CommonMethods commonMethods;
	BaseTest bst = new BaseTest();
	Logger log = LogManager.getLogger(NiftyFiftyPageEvents.class);
	//	JavascriptExecutor js;
	

	public void verifyNiftyFiftyUrl() {
		log.info("Url of the page found to be: " +CommonMethods.getCurrentUrl() );
		String currentNiftFiftyUrl = CommonMethods.getCurrentUrl();
		Assert.assertEquals(currentNiftFiftyUrl, PageConstants.NiftyFiftyURL);
	}

	public void verifyNifty50Text() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PageConstants.timunitsValue));
		WebElement nifty50Txt= elementFetch.getWebElement("CSS", NiftyFiftyPageElements.Nifty50Txt_css);
		wait.until(ExpectedConditions.textToBePresentInElement(nifty50Txt, PageConstants.NiftyFiftyTxt));
		log.info("Text of Nifty 50 found to be: "+ nifty50Txt.getText());
		Assert.assertEquals(nifty50Txt.getText(), PageConstants.NiftyFiftyTxt);
	}

	public void clickOnStock(String stockname) {
		scrollDownToHeatMapTiles();
		List<WebElement> stockNames = elementFetch.getWebElements("CSS", NiftyFiftyPageElements.HeatMapTile_css);
		System.out.println("Size of the stock: "+ stockNames.size());
		Assert.assertEquals(stockNames.size(), PageConstants.StockSize);
		for(int i=0;i<stockNames.size();i++) {
			if(stockNames.get(i).getText().equalsIgnoreCase(stockname)) {
				//				stockNames.get(i).click();
				bst.clickUsingJavascriptExecutor(stockNames.get(i));

			}
		}
		CommonMethods.switchWindow();
	}

	public void scrollDownToHeatMapTiles() {
		bst.scrollIntoView();
	}
}
