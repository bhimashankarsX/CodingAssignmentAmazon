package com.cts.genericUtils;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.cts.driverengine.InstantiateAppium;
import com.cts.pageObjects.AndroidNativeAlertHandler;

public class CustomMethods {
	
	   public static void TAP_ON_ELEMENT(WebElement element) throws InterruptedException, DOMException, SAXException, IOException, ParserConfigurationException{ 
	        try{
	            WebDriverWait wait = new WebDriverWait(InstantiateAppium.InitializeDriver(), 20);
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	        	element.click();
	        }
	        catch (NoSuchElementException e){
	            if (AndroidNativeAlertHandler.permissionMessage.isDisplayed()){ 
	            	AndroidNativeAlertHandler.permissionAllowButton.click();;
	            }
	                element.click();
	            }
	        }
}
