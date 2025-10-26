package com.nopcommerce.pages;

import org.openqa.selenium.By;

import com.nopcommerce.base.Base;

/*
Author: 
Create on: 
Purpose:To access web elements on single product page
*/
public class ProductPage extends Base {
	// Declaring web elements like page object model
	By productname = By.className("product-name");
	By productprice = By.id("price-value-2");
	By addtocart = By.id("add-to-cart-button-2");
	By close = By.className("close");
	By shoppingcart = By.className("cart-label");
	By content = By.className("content");

	public String[] getProductNamePrice() {
		String[] productdetails = new String[2];
		productdetails[0] = driver.findElement(productname).getText();// To take product name
		productdetails[1] = driver.findElement(productprice).getText();// To take product price
		return productdetails;
	}

	public void clickAddtoCart()// To add product to cart
	{
		log.info("Adding product to cart");
		driver.findElement(addtocart).click();// To click on add to cart button

	}

	public String getAddedToCartMessage()// To get success message
	{
		return driver.findElement(content).getText();
	}

	public void openShoppingCart()// Method click on shopping cart
	{
		driver.findElement(close).click();// To close pop up bar
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
		}
		driver.findElement(shoppingcart).click();// To open shopping cart
		log.info("Opening shoppingcart");
	}
}
