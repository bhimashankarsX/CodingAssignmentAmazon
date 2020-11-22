package com.cts.driverengine;


import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class FirefoxDriverManager extends BrowserFactory {

	private GeckoDriverService firefoxInstance;
	
	@Override
	protected void startBrowserService() {
		if(firefoxInstance == null) {
			try {
				firefoxInstance = new GeckoDriverService.Builder()
						.usingDriverExecutable(new File("driver.exe"))
						.usingAnyFreePort()
						.build();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected void stopBrowserService() {
		if(firefoxInstance != null && firefoxInstance.isRunning()) {
			firefoxInstance.stop();
		}
		
	}

	@Override
	protected void createDriverInstance() {
		driverInstance = new FirefoxDriver();
		
	}

}
