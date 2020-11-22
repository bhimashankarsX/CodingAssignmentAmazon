package com.cts.driverengine;

import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends BrowserFactory {

	@Override
	protected void startBrowserService() {
		
		
	}

	@Override
	protected void stopBrowserService() {
		
		
	}

	@Override
	protected void createDriverInstance() {
		driverInstance = new SafariDriver();
		
	}

}
