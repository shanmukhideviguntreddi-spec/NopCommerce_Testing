package com.nopcommerce.pages;



import org.openqa.selenium.By;

import com.nopcommerce.base.Base;
/*
Author: 
Create on: 
Purpose:To access web elements on shopping cart page
*/

public class ShoppingCart extends Base
{
	//Declaring web elements like page object model
	By cart=By.className("page-title");
	By banner=By.className("selector");
	By terms=By.id("termsofservice");
	By checkout=By.id("checkout");
	By continuebutton=By.xpath("(//button[@name='save'])[1]");
	By shippingAdress=By.xpath("//label[@for='billing-address-select']");
	By continuebutton1=By.xpath("(//button[text()='Continue'])[3]");
	By continuebutton2=By.xpath("(//button[text()='Continue'])[4]");
	By continuebutton3=By.xpath("(//button[text()='Continue'])[5]");
	By confirm=By.xpath("//button[text()='Confirm']");
	By logout=By.xpath("//a[@class='ico-logout']");
	By thankyou=By.className("page-title");
	public String getShoppinCartPageTitle()
	{
		return driver.findElement(cart).getText();
	}
	public void checkout()//To checkout
	{
		log.info("Checking out");
		driver.findElement(terms).click();//To click radio button
		driver.findElement(checkout).click();//To click on checkout
	}
	public int getCheckoutPage()//Taking check page element height
	{
		return driver.findElement(banner).getSize().getHeight();
	}
	public void clickContinueAndConfirm()//To click on continue buttons
	{
		driver.findElement(continuebutton).click();//To click on continue button
		driver.findElement(continuebutton1).click();//To click on continue button
		driver.findElement(continuebutton2).click();//To click on continue button
		driver.findElement(continuebutton3).click();//To click on continue button
		driver.findElement(confirm).click();//To confirm order
		log.info("Confirming order");
	}
	public String getDeliveryDetails()//To display delivery details
	{
		return driver.findElement(shippingAdress).getText();
	}
	
	public String getOrderStatus()//To get order status message
	{
		return driver.findElement(thankyou).getText();
	}
	public void logout()//To logout
	{
		log.info("Loggingout");
		driver.findElement(logout).click();//To click on logout
		log.info("Loggedout");
	}
}
