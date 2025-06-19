package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import base.BaseTest;


public class SuiteListener extends BaseTest implements ITestListener, IAnnotationTransformer {
	WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onTestFailure(ITestResult result) {
//		extent = new ExtentReports();
//		logger = extent.;
////		logger = extent.createTest("My Test");
////		ExtentTest extentTest = new ExtentTest(extent, null, null);
//		String destination = CommonMethods.getScreenShot(driver, result.getMethod().getMethodName());
//		System.out.println("destination--> "+destination);
////		logger.addScreenCaptureFromPath(destination);
////		ExtentTest logger = null;
////		logger.log(Status.FAIL, logger.addScreenCaptureFromPath(destination));
////		logger.log(Status.FAIL, (Markup)logger.addScreenCaptureFromPath(destination));
//		
//		 MediaEntityBuilder mediaEntity = MediaEntityBuilder.createScreenCaptureFromPath(destination);
//         logger.log(Status.FAIL,mediaEntity.build());
//
////		String filename= System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
////		
////		File f1= ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
////		try {
////		FileUtils.copyFile(f1, new File(filename+ ".png"));
////		} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////		}
	}
	
	public void transform(
			ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
			annotation.setRetryAnalyzer(RetryAnalyzer.class);
			}
	
}
