package com.cts.driverengine;

import org.openqa.selenium.WebDriver;

public abstract class BrowserFactory {

	protected WebDriver driverInstance;
	
	protected abstract void startBrowserService();
	protected abstract void stopBrowserService();
	protected abstract void createDriverInstance();
	
	/*
	 *	method getBrowserInstance returns driverInstance if there is no driver currently running 
	 */
	
	public WebDriver getBrowserInstance() {
		if(driverInstance == null) {
			startBrowserService();
			createDriverInstance();
		}
		return driverInstance;
			
	}
	
	/*
	 *	method quitBrowserInstance kills the driverInstance if there is a driver currently running 
	 */
	
	public void quitBrowserInstance() {
		if(driverInstance != null) {
			driverInstance.quit();
			driverInstance = null;
		}
	}
	
	
	
	
}
