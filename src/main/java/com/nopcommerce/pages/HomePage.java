package com.nopcommerce.pages;

import org.openqa.selenium.By;

import com.nopcommerce.base.Base;

/*
Author: 
Create on: 
Purpose:To access web elements on Home page
*/
public class HomePage extends Base {
	// Declaring web elements like page object model
	By register = By.className("ico-register");
	By login = By.className("ico-login");

	public void openregister(String browser)// To open registration page
	{
		if(browser.equalsIgnoreCase("chrome"))
			crDriver.findElement(register).click();// To click on register button
		else
			edDriver.findElement(register).click();
		log.info("Clicked on register");
	}

	public void openlogin(String browser)// To open login page
	{
		if(browser.equalsIgnoreCase("chrome"))
			crDriver.findElement(login).click();// To click on login button
		else
			edDriver.findElement(login).click();// To click on login button
		log.info("Clicked on login");
	}

	public String getHomePageTitle(String browser)// To get home page title
	{
		if(browser.equalsIgnoreCase("chrome"))
			return crDriver.getTitle();
		else
			return edDriver.getTitle();
	}
}
