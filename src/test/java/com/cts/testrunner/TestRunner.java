package com.cts.testrunner;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.ITestAnnotation;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.cts.driverengine.InstantiateAppium;
import com.cts.genericUtils.ExtentReports.ExtentTestManager;
import com.cts.pageObjects.AndroidNativeAlertHandler;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestRunner {
	
	public static AppiumDriver driver;
	public static SoftAssert softAssert;
	
	public static void allowPermission() throws InterruptedException {
		Thread.sleep(2000);
		AndroidNativeAlertHandler androidNativeAlertHandler = new AndroidNativeAlertHandler(driver);
		AndroidNativeAlertHandler.permissionAllowButton.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Android - Granted permission");
	}
	
	
	@BeforeSuite
	public static void InstantiateDriver() throws DOMException, SAXException, IOException, ParserConfigurationException, InterruptedException {
		InstantiateAppium.startAppiumService();
		
	}
	
	@BeforeMethod
	public static void setUp() throws DOMException, SAXException, IOException, ParserConfigurationException, InterruptedException {
		Reporter.log("=====Browser Session Started=====", true);
		driver = InstantiateAppium.InitializeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	}

	
	
	@AfterMethod
	public static void tearDown() throws DOMException, SAXException, IOException, ParserConfigurationException, InterruptedException {
		driver.quit();
		InstantiateAppium.stopAppiumDriverController();
		Reporter.log("=====Browser Session End=====", true);
	}
	
	@AfterSuite
	public static void stopServer() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		InstantiateAppium.stopAppiumDriverController();
		Reporter.log("=====Browser Session End=====", true);
	}
	
	


	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		softAssert.assertAll();
	}

	public void onTestStart(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		
	}

	public boolean retry(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		return false;
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
