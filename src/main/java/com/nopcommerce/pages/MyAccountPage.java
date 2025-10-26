package com.nopcommerce.pages;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.nopcommerce.base.Base;

/*
Author: 
Create on: 
Purpose:To access web elements and to do operations on my account page
*/
public class MyAccountPage extends Base {
	// Declaring web elements like page object model
	By banner = By.className("page-title");
	By address = By.xpath("//a[text()='Addresses']");
	By addnew = By.xpath("//button[text()='Add new']");
	By Address_FirstName = By.id("Address_FirstName");
	By Address_LastName = By.id("Address_LastName");
	By Address_Email = By.id("Address_Email");
	By Address_CountryId = By.id("Address_CountryId");
	By Address_City = By.id("Address_City");
	By Address_Address1 = By.id("Address_Address1");
	By Address_ZipPostalCode = By.id("Address_ZipPostalCode");
	By Address_PhoneNumber = By.id("Address_PhoneNumber");
	By save = By.xpath("//button[text()='Save']");
	By logout = By.className("ico-logout");
	By close = By.className("close");
	By login = By.className("ico-login");
	By addresslist = By.className("address-list");
	FileInputStream fin;
	XSSFWorkbook wb;
	XSSFSheet ws;
	Row row;
	Base base = new Base();

	public boolean getMyAccountTitle() {
		return driver.findElement(banner).getText().contains("My account");
	}

	public void addaddressdetails() throws Exception// To add address details
	{
		base.initializeProperties();
		// Excel sheet initialization
		fin = new FileInputStream(prop.getProperty("excelpath"));
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheet(prop.getProperty("sheetname2"));
		for (int i = 1; i <= ws.getLastRowNum(); i++) {
			row = ws.getRow(i);
			driver.findElement(address).click();// To click on address
			driver.findElement(addnew).click();// To click on add new
			driver.findElement(Address_FirstName).sendKeys(row.getCell(0).getStringCellValue());// Entering first name
			driver.findElement(Address_LastName).sendKeys(row.getCell(1).getStringCellValue());// Entering last name
			driver.findElement(Address_Email).sendKeys(row.getCell(2).getStringCellValue());// Entering email
			new Select(driver.findElement(Address_CountryId)).selectByVisibleText(row.getCell(3).getStringCellValue());// Selecting
																														// country
			driver.findElement(Address_City).sendKeys(row.getCell(4).getStringCellValue());// Entering city
			driver.findElement(Address_Address1).sendKeys(row.getCell(5).getStringCellValue());// Entering address1
			driver.findElement(Address_ZipPostalCode).sendKeys(row.getCell(6).getStringCellValue());// Entering pin code
			driver.findElement(Address_PhoneNumber).sendKeys(row.getCell(7).getStringCellValue());// Entering phone
																									// number
			driver.findElement(save).click();
		}
		log.info("Adding adress");
	}

	public int getAddressDetailsStatus()// Accessing address details page
	{
		return driver.findElement(addresslist).getSize().getHeight();
	}

	public void logout()// To logout user
	{
		driver.findElement(close).click();// To close pop up bar on window
		driver.findElement(logout).click();// To click on logout
		log.info("Clicking on logout");
	}

}
