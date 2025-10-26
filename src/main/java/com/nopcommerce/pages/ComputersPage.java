package com.nopcommerce.pages;

import org.openqa.selenium.By;

import com.nopcommerce.base.Base;

/*
	Author: 
	Create on: 
	Purpose: For accessing web elements on computer products page
*/
public class ComputersPage extends Base {
	// Declaring web elements like page object model
	By desktops = By.xpath("(//a[@href='/desktops'])[3]");

	public void clickOnDesktops()// Method to click on desktop products
	{
		driver.findElement(desktops).click();// To click on desktop option
		log.info("Clicked on desktops");
	}
}
