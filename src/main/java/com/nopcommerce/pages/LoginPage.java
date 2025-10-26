package com.nopcommerce.pages;

import org.openqa.selenium.By;

import com.nopcommerce.base.Base;

/*
Author: 
Create on: 
Purpose:To access web elements on login page
*/
public class LoginPage extends Base {
	// Declaring web elements like page object model
	By loginpagebanner = By.className("page-title");
	By email = By.id("Email");
	By password = By.id("Password");
	By loginbutton = By.xpath("//button[@class='button-1 login-button']");

	public String getLoginPageBanner(String browser)// Method to get login page title
	{
		if (browser.equalsIgnoreCase("chrome"))
			return crDriver.findElement(loginpagebanner).getText();
		else
			return edDriver.findElement(loginpagebanner).getText();
	}

	public void loginuser(String[] data) // Method to login the user
	{
		log.info("Entering login details and logging in");
		driver.findElement(email).sendKeys(data[2]);// Entering email
		driver.findElement(password).sendKeys(data[3]);// Entering password
		driver.findElement(loginbutton).click();// Click on login button
		log.info("Logged in");
	}
}
