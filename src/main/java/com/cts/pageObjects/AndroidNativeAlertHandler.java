package com.cts.pageObjects;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.cts.driverengine.InstantiateAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidNativeAlertHandler {

	public AndroidNativeAlertHandler(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
	}
	
	/**************************************************************************
	 * 		Initializing Page Objects for AndroidNativeAlertHandler
	 * 
	 * ************************************************************************/
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_message")
	public static WebElement permissionMessage;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public static WebElement permissionAllowButton;
	
	/**************************************************************************
	 * 		Methods for AndroidNativeAlertHandler
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws DOMException 
	 * 
	 * ************************************************************************/
	
	   public void TAP_ON_ELEMENT(WebElement element) throws InterruptedException, DOMException, SAXException, IOException, ParserConfigurationException{ 
	        try{
	            WebDriverWait wait = new WebDriverWait(InstantiateAppium.InitializeDriver(), 20);
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	        	element.click();
	        }
	        catch (NoSuchElementException e){
	            if (AndroidNativeAlertHandler.permissionMessage.isDisplayed()){ 
	            	permissionAllowButton.click();
	            }
	                element.click();
	            }
	        }
	
	
}
