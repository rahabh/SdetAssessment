package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.NiftyFiftyPageEvents;
import pageEvents.StockPageEvents;
import utils.ElementFetch;
import utils.PageConstants;

public class testcase1 extends BaseTest{
	
	HomePageEvents homePageEvents = new HomePageEvents();
	NiftyFiftyPageEvents niftyFiftyPageEvents = new NiftyFiftyPageEvents();
	StockPageEvents stockPageEvents = new StockPageEvents();
	ElementFetch elementFetch= new ElementFetch();
	
  @Test(alwaysRun=true)
  public void verifyTheValueofHighAndLowInLast52WeeksForStockTataMotors() {
	  logger.info("Verify Title of the Page: "+PageConstants.NSEtitle);
	  homePageEvents.verifyTitle(PageConstants.NSEtitle);
	  logger.info("I click on the nifty fifty icon on home page");
	  homePageEvents.clickOnNiftyFifty();
	  logger.info("I verify the url of nifty 50");
	  niftyFiftyPageEvents.verifyNiftyFiftyUrl();
	  logger.info("I verify the text on nifty 50 page");
	  niftyFiftyPageEvents.verifyNifty50Text();
	  logger.info("I click on stock '"+PageConstants.Stockname+"'");
	  niftyFiftyPageEvents.clickOnStock(PageConstants.Stockname);
	  logger.info("I verify the url of the stock: "+PageConstants.StockURL+PageConstants.Stockname);
	  logger.info("I verify the url of tata motors");
	  stockPageEvents.verifyStockURLUrl(PageConstants.Stockname);
	  logger.info("I verify and retrieve the value of last 52 week high");
	  stockPageEvents.getFiftyTwoWeekHighValue(PageConstants.Stockname);
	  logger.info("I verify and retrieve the value of last 52 week low");
	  stockPageEvents.getFiftyTwoWeekLowValue(PageConstants.Stockname);
	  logger.info("verify the total loss and profit for the stock '"+PageConstants.Stockname+"'");
	  stockPageEvents.verifyLossAndProfitValueOfTheStockListedUnderNiftyFifty(PageConstants.Stockname);
  }
  
  @Test(alwaysRun=true)
  public void verifyTheValueofHighAndLowInLast52WeeksForRelianceCom() {
	  logger.info("Verify Title of the Page: "+PageConstants.NSEtitle);
	  homePageEvents.verifyTitle(PageConstants.NSEtitle);
	  logger.info("I click on the nifty fifty icon on home page");
	  homePageEvents.clickOnNiftyFifty();
	  logger.info("I verify the url of nifty 50");
	  niftyFiftyPageEvents.verifyNiftyFiftyUrl();
	  logger.info("I verify the text on nifty 50 page");
	  niftyFiftyPageEvents.verifyNifty50Text();
	  logger.info("I click on stock '"+PageConstants.Stockname_rcom+"'");
	  niftyFiftyPageEvents.clickOnStock(PageConstants.Stockname_rcom);
	  logger.info("I verify the url of the stock: "+PageConstants.StockURL+PageConstants.Stockname_rcom);
	  logger.info("I verify the url of "+PageConstants.Stockname_rcom);
	  stockPageEvents.verifyStockURLUrl(PageConstants.Stockname_rcom);
	  logger.info("I verify and retrieve the value of last 52 week high");
	  stockPageEvents.getFiftyTwoWeekHighValue(PageConstants.Stockname_rcom);
	  logger.info("I verify and retrieve the value of last 52 week low");
	  stockPageEvents.getFiftyTwoWeekLowValue(PageConstants.Stockname_rcom);
	  logger.info("verify the total loss and profit for the stock '"+PageConstants.Stockname_rcom+"'");
	  stockPageEvents.verifyLossAndProfitValueOfTheStockListedUnderNiftyFifty(PageConstants.Stockname_rcom);
  }
  
  @Test(alwaysRun=true)
  public void verifyTheValueofHighAndLowInLast52WeeksForAnyStocksOfNiftyFifty() {
	  logger.info("Verify Title of the Page: "+PageConstants.NSEtitle);
	  homePageEvents.verifyTitle(PageConstants.NSEtitle);
	  logger.info("I click on the nifty fifty icon on home page");
	  homePageEvents.clickOnNiftyFifty();
	  logger.info("I verify the url of nifty 50");
	  niftyFiftyPageEvents.verifyNiftyFiftyUrl();
	  logger.info("I verify the text on nifty 50 page");
	  niftyFiftyPageEvents.verifyNifty50Text();
	  logger.info("I click on stock 'TITAN'");
	  niftyFiftyPageEvents.clickOnStock("TITAN");
	  logger.info("I verify the url of the stock: "+PageConstants.StockURL+"TITAN");
	  logger.info("I verify the url of "+"TITAN");
	  stockPageEvents.verifyStockURLUrl("TITAN");
	  logger.info("I verify and retrieve the value of last 52 week high");
	  stockPageEvents.getFiftyTwoWeekHighValue("TITAN");
	  logger.info("I verify and retrieve the value of last 52 week low");
	  stockPageEvents.getFiftyTwoWeekLowValue("TITAN");
	  logger.info("verify the total loss and profit for the stock 'TITAN'");
	  stockPageEvents.verifyLossAndProfitValueOfTheStockListedUnderNiftyFifty("TITAN");
  }
}
