package com.nopcommerce.pages;

import org.openqa.selenium.By;

import com.nopcommerce.base.Base;

/*
Author: 
Create on: 
Purpose:To access web elements on logged in page
*/
//To access web elements on logged in page
public class LoggedinPage extends Base {
	// Declaring web elements like page object model
	By myaccount = By.className("ico-account");
	By computers = By.xpath("(//a[@href='/computers'])[1]");
	By menu = By.xpath("/html/body/div[6]/div[2]/ul[1]/li/a");

	public void openMyaccount() {
		driver.findElement(myaccount).click();// To click on My Account option
		log.info("Opening my account");
	}

	public void clickoncomputers()// Method open computers page
	{
		driver.findElement(computers).click();// To click on computers option
		log.info("Clicking on computers");
	}

	public String getLoginStatus()// Method to get login status
	{
		return driver.findElement(myaccount).getText();// To get text written in web element
	}

}
