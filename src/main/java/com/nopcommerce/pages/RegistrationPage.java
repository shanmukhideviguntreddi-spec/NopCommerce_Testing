package com.nopcommerce.pages;

import org.openqa.selenium.By;
import com.nopcommerce.base.Base;
/*
Author: 
Create on: 
Purpose:To access web elements on Registration page
*/
public class RegistrationPage extends Base
{
	//Declaring web elements like page object model
	By title=By.className("page-title");
	By firstname=By.id("FirstName");
	By lastname=By.id("LastName");
	By email=By.id("Email");
	By password=By.id("Password");
	By confirmpasssword=By.id("ConfirmPassword");
	By registerbutton=By.id("register-button");
	public String getRegistartionPageTitle(String browser)//To get registration page title
	{
		if(browser.equalsIgnoreCase("chrome"))
			return crDriver.findElement(title).getText();
		else return edDriver.findElement(title).getText();
	}
	public void registeruser(String data[])//To register new user
	{
		log.info("Registering user");
		driver.findElement(firstname).sendKeys(data[0]);//To enter first name
		driver.findElement(lastname).sendKeys(data[1]);//To enter last name
		driver.findElement(email).sendKeys(data[2]);//To enter email
		driver.findElement(password).sendKeys(data[3]);//To enter confirm password
		driver.findElement(confirmpasssword).sendKeys(data[4]);//To enter password
		driver.findElement(registerbutton).click();//To click on register button
		log.info("User registered");
	}
}


