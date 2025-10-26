package com.nopcommerce.pages;



import org.openqa.selenium.By;
import com.nopcommerce.base.Base;
//For accessing web elements on desktop products page
public class DesktopsPage extends Base
{
	//Declaring web elements like page object model
	By product=By.xpath("(//div[@class='picture'])[2]");
	public void clickonProduct()
	{
		driver.findElement(product).click();//To click on the product
		log.info("Clicked on product");
	}
	public String getProductName()
	{
		return driver.findElement(product).getText();
	}
}
