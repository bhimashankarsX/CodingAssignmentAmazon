package com.cts.testrunner;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.cts.genericUtils.ExtentReports.ExtentTestManager;
import com.cts.pageObjects.*;
import com.cts.programUtils.*;
import com.cts.programUtils.GeneralFunctions.swipeType;
import com.cts.programUtils.GeneralFunctions;
import com.relevantcodes.extentreports.LogStatus;

public class DeviceControls extends TestRunner {
	
	static TestScenarioObjects loginPage = new TestScenarioObjects(driver);
	
	@SuppressWarnings("static-access")
	public static void AllowPermission() throws InterruptedException, DOMException, SAXException, IOException, ParserConfigurationException {
		allowPermission();
	}	
	
	
	@SuppressWarnings("static-access")
	public static void swipeTillAddToCart() throws InterruptedException, DOMException, SAXException, IOException, ParserConfigurationException {
		GeneralFunctions.swipe(driver, swipeType.UP, 1);
		GeneralFunctions.swipe(driver, swipeType.UP, 1);
	}	
	
}
