package pageEvents;

import java.math.BigDecimal;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.NiftyFiftyPageElements;
import pageObjects.StockPageElements;
import utils.CommonMethods;
import utils.ElementFetch;
import utils.PageConstants;

public class StockPageEvents {
	
	ElementFetch elementFetch = new ElementFetch();
	WebDriver driver;
	
	public void verifyStockURLUrl(String StockName) {
		String currentNiftFiftyUrl = CommonMethods.getCurrentUrl();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		Assert.assertEquals(currentNiftFiftyUrl, PageConstants.StockURL+StockName);
	}
	
	public void getFiftyTwoWeekHighValue(String StockName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PageConstants.timunitsValue));
		WebElement FiftyTwoWeekHigh_ele = elementFetch.getWebElement("CSS", StockPageElements.FiftyTwoWeekHigh_css);
		Assert.assertEquals(FiftyTwoWeekHigh_ele.getText(), PageConstants.FiftTwoHighTXT);
		WebElement FiftyTwoWeekHighDate_ele = elementFetch.getWebElement("CSS", StockPageElements.FiftyTwoWeekHighDate_css);
		wait.until(ExpectedConditions.visibilityOf(FiftyTwoWeekHighDate_ele));
		String FiftyTwoWeekHigh_txt = FiftyTwoWeekHigh_ele.getText()+FiftyTwoWeekHighDate_ele.getText();
		System.out.println("Text of Fifty two week high of stock '"+StockName+"' "+": -> "+FiftyTwoWeekHigh_txt);
		WebElement FiftyTwoWeekHighvalue_ele = elementFetch.getWebElement("CSS", StockPageElements.FiftyTwoWeekHighValue_css);
		System.out.println("The value of fifty two high '"+StockName+"': "+FiftyTwoWeekHighvalue_ele.getText());
	}
	
	public void getFiftyTwoWeekLowValue(String StockName) {
		WebElement FiftyTwoWeekLow_ele = elementFetch.getWebElement("CSS", StockPageElements.FiftyTwoWeekLow_css);
		Assert.assertEquals(FiftyTwoWeekLow_ele.getText(), PageConstants.FiftTwoLowTXT);
		WebElement FiftyTwoWeekLowDate_ele = elementFetch.getWebElement("CSS", StockPageElements.FiftyTwoWeekLowDate_css);
		String FiftyTwoWeekLow_txt = FiftyTwoWeekLow_ele.getText()+FiftyTwoWeekLowDate_ele.getText();
		System.out.println("The text of fifty two week low '"+StockName+"': -> "+FiftyTwoWeekLow_txt);
		WebElement FiftyTwoWeekLowValue_ele = elementFetch.getWebElement("CSS", StockPageElements.FiftyTwoWeekLowValue_css);
		System.out.println("The value of fifty two week low: '"+StockName+"': "+FiftyTwoWeekLowValue_ele.getText());
	}
	
	public void verifyLossAndProfitValueOfTheStockListedUnderNiftyFifty(String stockname) {
		WebElement prvDayValue_ele = elementFetch.getWebElement("XPATH", StockPageElements.PrvDayClose_xpath);
		BigDecimal prvDayValue = new BigDecimal(prvDayValue_ele.getText().replace(",","" ));
		System.out.println("prvDayValue: "+prvDayValue);
		WebElement todayDayValue_ele = elementFetch.getWebElement("XPATH", StockPageElements.CurrentValue_xpath);
//		float todayDayValue = Float.parseFloat(todayDayValue_ele.getText());
		BigDecimal todayDayValue = new BigDecimal(todayDayValue_ele.getText().replace(",","" ));
		System.out.println("todayDayValue: "+todayDayValue);
		WebElement differenceValue_ele = elementFetch.getWebElement("XPATH", StockPageElements.diffrence_xpath);
//		float differenceValue = Float.parseFloat(differenceValue_ele.getText());
		BigDecimal differenceValue = new BigDecimal(differenceValue_ele.getText().replace(",","" ));
		System.out.println("differenceValue: "+differenceValue);
		BigDecimal difference = todayDayValue.subtract(prvDayValue);
		System.out.println("The difference is: "+difference);
		Assert.assertEquals(differenceValue, difference);
	}

}
