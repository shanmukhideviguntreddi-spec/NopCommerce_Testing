package com.nopcommerce.pages;

import org.openqa.selenium.By;

import com.nopcommerce.base.Base;

/*
Author: 
Create on: 
Purpose:To access web elements on after registration page
*/
public class RegistrationSuccesPage extends Base {
	// Declaring web elements like page object model
	By message = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]");
	By login = By.className("ico-login");
	By logout = By.className("ico-logout");

	public String getRegistrationStatus(String browser)// To get registration page title
	{
		if (browser.equalsIgnoreCase("chrome"))
			return crDriver.findElement(message).getText();
		else
			return edDriver.findElement(message).getText();
	}

	public void clickLogout() {
		driver.findElement(logout).click();
	}

	public int getLogoutStatus()// To verify login status
	{
		return driver.findElement(login).getSize().getHeight();
	}
}
