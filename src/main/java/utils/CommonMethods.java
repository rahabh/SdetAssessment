package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import pageObjects.NiftyFiftyPageElements;

public class CommonMethods extends BaseTest{
	public ElementFetch elementFetch;

	public static String getScreenShot(WebDriver driver, String screenshotName) {
		//		String filename= System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
		String dateTime = getCurrentDateTime();
		File source= ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName+"_" + dateTime+".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
	
	private static String getCurrentDateTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
//		System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
		String formattedDate = myDateObj.format(myFormatObj);
		System.out.println("After formatting: " + formattedDate);
		return formattedDate;
	}
	
	public static void switchWindow() {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}

		}
	}
	
	public static String getTitle() {
		return driver.getTitle();
	}
	
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
//	public void scrollDownToElement(WebElement element) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		System.out.println("2");
////		element= elementFetch.getWebElement("CSS", NiftyFiftyPageElements.HeatMapTxt_css);
//		try {
//		js.executeScript("arguments[0].scrollIntoView();", element);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
