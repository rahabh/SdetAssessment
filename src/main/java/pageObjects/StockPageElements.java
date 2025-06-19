package pageObjects;

public interface StockPageElements {
	
	String TataMotorsTxt_css = "a[href='#tradeinfo-sbin']";
	String FiftyTwoWeekHigh_css = "span#wkhi";
	String FiftyTwoWeekHighDate_css = "i#week52HighDate";
	String FiftyTwoWeekHighValue_css = "span#week52highVal";
	String FiftyTwoWeekLow_css = "span#wklo";
	String FiftyTwoWeekLowDate_css = "i#week52LowDate";
	String FiftyTwoWeekLowValue_css = "span#week52lowVal";
	String PrvDayClose_xpath = "//*[@id='priceInfoTable']/tbody/tr/td[1]";
	String CurrentValue_xpath = "//*[@id='quoteLtp']";
	String diffrence_xpath = "//*[@id='priceInfoStatus']/span[1]";
	
}
