package com.cts.programUtils;


import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class GeneralFunctions {
	
	public static enum swipeType{
		UP,
		DOWN,
		LEFT,
		RIGHT;
	}
	
	
	public static void swipe(AppiumDriver driver, swipeType direction, int frequency) throws InterruptedException {
		
		Thread.sleep(2000);
		TouchAction swipeAction = new TouchAction(driver);
		
		Dimension size = driver.manage().window().getSize();
		
		
		for(int swipeCounter = 1; swipeCounter <= frequency; swipeCounter++) {
			
			int startX = 0;
			int endX = 0;
			
			int startY = 0;
			int endY = 0;
			switch(direction) {
			
			
				case UP:
					startX = (int)(size.width*0.50);
					startY = (int)(size.height*0.80);
					endX = 0;
					endY = (int)(size.height*0.20);
					System.out.println("Swiping with: " + startX  + " " + startY +  " " + endX + " " + endY);
					swipeAction.press(startX, startY).waitAction().moveTo(0, endY).release().perform();
					break;
				case DOWN:
					startX = (int)(size.width*0.50);
					startY = (int)(size.height*0.20);
					endX = 0;
					endY = (int)(size.height*0.80);
					System.out.println("Swiping with: " + startX  + " " + startY  + " " + endX+ " " + endY);
					swipeAction.longPress(startX, startY).moveTo(0, endY).release().perform();
					break;
				case LEFT:
					startX = (int)(size.width*0.80);
					startY = (int)(size.height*0.50);
					endX = (int)(size.width*0.10);
					endY = 0;
					System.out.println("Swiping with: " + startX  + " " + startY + " " + endX + " " + endY);
					//The below method is not working for windows android combo instead user longPress.
					//Point to remember is moveTo() is a relative co-ordinate, it does not accept absolute values.
					//swipeAction.press(startX, startY).waitAction().moveTo(endX*-1, 0).release().perform();
					swipeAction.longPress(startX, startY).waitAction().moveTo(endX*-1,0).release().perform();
					break;
				case RIGHT:
					startX = (int)(size.width*0.20);
					startY = (int)(size.height*0.50);
					endX = (int)(size.width*0.80);
					endY = 0;
					System.out.println("Swiping with: " + startX  + " " + startY + " " + endX + " " + endY);
					swipeAction.longPress(startX, startY).waitAction().moveTo(endX, startY).release().perform();
					break;
			default:
				break;
			}
	
		}
		
			
	}
	
	public static void back(AppiumDriver driver){
		driver.navigate().back();
	}
	
	public static void tap() {
		
	}
}
