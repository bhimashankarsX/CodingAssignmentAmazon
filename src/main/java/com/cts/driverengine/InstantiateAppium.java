package com.cts.driverengine;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.cts.genericUtils.XMLReader;
import com.cts.genericUtils.XMLReader.readerCases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class InstantiateAppium {
	static AppiumDriver appiumDriverInstance;
	static AppiumDriverLocalService appiumService;
	static String appiumServiceURL;
	
		public static void startAppiumService() {
			AppiumServiceBuilder builder = new AppiumServiceBuilder()
					.withAppiumJS(new File("C:/Users/Jayashree/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"));
		
			appiumService = builder.build();
			appiumService.start();
			
			appiumServiceURL = appiumService.getUrl().toString();
			
			System.out.println("Appium running at :- " + appiumServiceURL);
		}
		
		public static String appiumURL() {
			appiumServiceURL = appiumService.getUrl().toString();
			return appiumServiceURL;
		}
		
		public static AppiumDriver InitializeDriver() throws DOMException, SAXException, IOException, ParserConfigurationException, InterruptedException {
			DesiredCapabilities appiumCapabilities = new DesiredCapabilities();
			
			Element elementDC = XMLReader.reader(readerCases.DESIRED_CAPABILITIES);
			
			
			File AppDir = new File(XMLReader.readFromXML(elementDC, "appDir"));
		    File App = new File(AppDir,XMLReader.readFromXML(elementDC, "apk"));
			appiumCapabilities.setCapability("deviceName", XMLReader.readFromXML(elementDC, "deviceName"));
			appiumCapabilities.setCapability("platformName", XMLReader.readFromXML(elementDC, "platformName"));
			appiumCapabilities.setCapability("platformVersion", XMLReader.readFromXML(elementDC, "platformVersion"));
			appiumCapabilities.setCapability("appPackage", XMLReader.readFromXML(elementDC, "appPackage"));
			appiumCapabilities.setCapability("appActivity", XMLReader.readFromXML(elementDC, "appActivity"));
			appiumCapabilities.setCapability("automationName", XMLReader.readFromXML(elementDC, "automationName"));
			appiumCapabilities.setCapability(MobileCapabilityType.APP,App.getAbsolutePath());
			appiumCapabilities.setCapability("noReset", false);
			startAppiumService();
			appiumDriverInstance = new AppiumDriver(new URL(appiumURL()), appiumCapabilities);
			appiumDriverInstance.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			return appiumDriverInstance;
		}
		
		
	
	public static void stopAppiumDriverController() {
		appiumService.stop();
	}
	
}
