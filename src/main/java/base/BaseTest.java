package base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org. apache.logging.log4j.LogManager;
import org.apache.logging.log4j. Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CommonMethods;
import utils.PageConstants;

public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public JavascriptExecutor js;

	@BeforeTest
	public void mainBeforeTestMethod () {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter(System.getProperty ("user.dir") + File.separator+"reports"+File.separator+"NSEInidaAutomationExtentReport.html");
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme. DARK) ;
		extent.setSystemInfo("HostName", "Rahul Abhishek");
		extent. setSystemInfo("UserName", "root");
		sparkReporter.config().setDocumentTitle("Automation Report on NSE India");
		sparkReporter.config().setReportName("NSE INDIA Automation Tests Results");
	}

	//	@BeforeTest
	public void reportLog(String message) {    
		logger.log(Status.INFO, message);//For extentTest HTML report
		logger.info(message);
		Reporter.log(message);

	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(String browser, Method testMethod)
	{
		logger= extent.createTest(testMethod.getName());
		setupDriver(browser);
	}

	@AfterMethod
	public void afterMethod(ITestResult result){
		//		String dateTime = getCurrentDateTime();
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String destination = CommonMethods.getScreenShot(driver, result.getMethod().getMethodName());
			logger.log(Status.FAIL, (Markup) logger.addScreenCaptureFromPath(destination));
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case PASS", ExtentColor.GREEN)); }
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		extent.flush();
		driver.quit();
	}

	public void setupDriver(String browser) {
		//		log= LogManager.getLogger(BaseTest.class);
		logger.info("The browser is: "+browser);
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();}
		else if (browser. equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager. edgedriver() .setup();
			driver= new EdgeDriver() ; }
		else if (browser.equalsIgnoreCase("headless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}
		else {
			logger.fail("Entered browser name '"+browser+"' is not valid");
		}
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(PageConstants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PageConstants.timunitsValue));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PageConstants.timunitsValue));
	}

	public void scrollIntoView() {
		js = (JavascriptExecutor) driver;
		Long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight");
		long middlePoint = scrollHeight / 2;
		js.executeScript("window.scrollTo(0, " + middlePoint + ");");
	}

	public void clickUsingJavascriptExecutor(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
}