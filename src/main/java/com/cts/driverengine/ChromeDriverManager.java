package com.cts.driverengine;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends BrowserFactory{
	
	private ChromeDriverService chromeInstance;

	@Override
	protected void startBrowserService() {
		if(chromeInstance == null) {
			try {
				chromeInstance = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File("chromedriver.exe"))
						.usingAnyFreePort()
						.build();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected void stopBrowserService() {
		if(chromeInstance != null && chromeInstance.isRunning()) {
			chromeInstance.stop();
		}
		
	}

	@Override
	protected void createDriverInstance() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driverInstance = new ChromeDriver(capabilities);
		
	}

}
