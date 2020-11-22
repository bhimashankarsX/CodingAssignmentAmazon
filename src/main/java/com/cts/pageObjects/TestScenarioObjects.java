package com.cts.pageObjects;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.cts.driverengine.InstantiateAppium;
import com.cts.genericUtils.XMLReader;
import com.cts.genericUtils.ExtentReports.ExtentTestManager;
import com.cts.genericUtils.XMLReader.readerCases;
import com.cts.testrunner.TestRunner;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TestScenarioObjects {
	
	public TestScenarioObjects(AppiumDriver driver)  {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**************************************************************************
	 * 		Initializing Page Objects for LoginPageObjects
	 * 
	 * ************************************************************************/
	
	static String itemText;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
	protected static WebElement singInButton;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/android.widget.EditText")
	protected static WebElement loginEditText;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/continue")
	protected static WebElement loginContinueButton;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/ap_password")
	protected static WebElement apPassword;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	protected static WebElement searchBar;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout")
	protected static WebElement searchTextEnter;
	
	@AndroidFindBy(id = "	com.amazon.mShop.android.shopping:id/loc_ux_update_current_pin_code")
	protected static WebElement useMyCurrentLocation;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/item_title")
	protected static WebElement itemChosen;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/add-to-cart-button")
	protected static WebElement addToCart;
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/a-autoid-0-announce")
	protected static WebElement checkCart;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'TCL 164 cm (65 inches)  AI 4K Ultra HD Certified Android Smart L...']")
	protected static WebElement cartItem;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Proceed to Buy']")
	protected static WebElement proceedToBuy;
	

	
	/**************************************************************************
	 * 		Methods for LoginPageObjects
	 * 
	 * ************************************************************************/
	
	public static void tapOnAlreadySignInButton() {
		singInButton.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on : Already a customer? sign in");
	}
	
	public static void enterMobileNumberForlogin() throws DOMException, SAXException, IOException, ParserConfigurationException {
		loginEditText.click();
		loginEditText.sendKeys(XMLReader.readFromXML(XMLReader.reader(readerCases.TEST_DATA), "contactNumber"));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Entered the mobile Number in the username text field");
	}
	
	public static void tapOnConitnueButtonForPW() {
		loginContinueButton.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on 'Continue' button");
	}
	
	
	public static void enterPasswordForlogin() throws DOMException, SAXException, IOException, ParserConfigurationException {
		apPassword.click();
		apPassword.sendKeys(XMLReader.readFromXML(XMLReader.reader(readerCases.TEST_DATA), "password"));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Entered the mobile Number in the username text field");
	}
	
	public static void tapOnLoginButtonForPW() {
		loginContinueButton.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on 'Continue' button");
	}
	
	public static void tapOnTheSearchBar() {
		searchBar.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on 'Search' bar");
	}
	
	public static void enterTheSearchItem() throws DOMException, SAXException, IOException, ParserConfigurationException {
		searchTextEnter.sendKeys(XMLReader.readFromXML(XMLReader.reader(readerCases.TEST_DATA), "searchItem"));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on 'Search' bar");
	}
	
	public static void selectTheItemRequired() {
		itemText= itemChosen.getText();
		itemChosen.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Clicked on required TV selection");
	}
	
	public static void selectCurrectLocationAsAddress() {
		useMyCurrentLocation.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Selected the current location as the address");
	}
	
	public static void tapOnAddToCart() {
		addToCart.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Added the Item to the cart");
	}
	
	public static void tapOnCartButton() {
		checkCart.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Selected the Cart Button");
	}
	
	public static void validateTheItemInTheCart() {
		TestRunner.softAssert.assertEquals(cartItem.getText(), itemText);		
		ExtentTestManager.getTest().log(LogStatus.PASS, "Validated the item in the cart successfully");
	}
	
	public static void tapOnProceedButton() {
		checkCart.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Selected the Cart Button");
	}
	
}
