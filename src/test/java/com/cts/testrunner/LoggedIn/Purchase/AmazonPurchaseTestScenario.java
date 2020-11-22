package com.cts.testrunner.LoggedIn.Purchase;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.cts.pageObjects.TestScenarioObjects;
import com.cts.testrunner.DeviceControls;
import com.cts.testrunner.TestRunner;

public class AmazonPurchaseTestScenario extends TestRunner{


		@SuppressWarnings("static-access")
		@Test(priority = 0)
		public static void PURCHASE_65INCH_TV() throws DOMException, SAXException, IOException, ParserConfigurationException, InterruptedException {
			
			/**************************************************************************
			 * 	Initialize all page objects to be used for TestScenarioObjects
			 * 
			 * ************************************************************************/
			
			TestScenarioObjects testscenario = new TestScenarioObjects(driver);
			
			
			/**************************************************************************
			 * 		Methods for TestScenarioObjects
			 * 
			 * ************************************************************************/
			
			testscenario.tapOnAlreadySignInButton();
			testscenario.enterMobileNumberForlogin();
			testscenario.tapOnConitnueButtonForPW();
			testscenario.enterPasswordForlogin();
			testscenario.tapOnLoginButtonForPW();
			testscenario.tapOnTheSearchBar();
			testscenario.enterTheSearchItem();
			testscenario.selectTheItemRequired();
			testscenario.selectCurrectLocationAsAddress();
			//Allowing the location as my current address permission
			DeviceControls.allowPermission();
			DeviceControls.swipeTillAddToCart();
			testscenario.tapOnAddToCart();
			testscenario.tapOnCartButton();
			testscenario.validateTheItemInTheCart();
			testscenario.tapOnProceedButton();
			
				}

}
