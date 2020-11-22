package com.cts.driverengine;

public class BrowserHandler {
	
	public static enum browserType {
		FIREFOX,
		SAFARI,
		CHROME,
		IE;
	}

	public static BrowserFactory initiateDriver(browserType browsertype) {
		BrowserFactory browser = null;
		
		switch(browsertype) {
			case CHROME: 
				browser = new ChromeDriverManager();
			case FIREFOX:
				browser = new FirefoxDriverManager();
			case SAFARI: 
				browser = new SafariDriverManager();
		default:
				browser = new FirefoxDriverManager();
			break;
		}
		
		return browser;
		
	}
}
