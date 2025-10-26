package com.nopcommerce.base;

import java.io.File;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dataprovider.DataProviderClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends DataProviderClass {
	/*
	 * Author: Create on: Purpose: Main functionalities that are used in the project
	 */
	public static WebDriver driver = null;
	public static WebDriver crDriver = null;
	public static WebDriver edDriver = null;
	public static ExtentSparkReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	public static Logger log = Logger.getLogger("nopcommerce");
	public static SoftAssert a = new SoftAssert();

	// Main functionalities
	public void edgesetup()// To setup edge
	{
		PropertyConfigurator.configure("src/test/resources/logs/log4j.properties");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		edDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info(" Browser Initialized");
	}

	public void chromesetup()// To setup chrome browser
	{
		PropertyConfigurator.configure("src/test/resources/logs/log4j.properties");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		crDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Browser Initialized");
	}

	public void openurl()// To open Url
	{
		driver.get(prop.getProperty("url"));
		log.info("Url Opened");
	}

	public void takescreenshot(String fname) throws Exception// For taking screenshot
	{
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_") + fname + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshots = prop.getProperty("screens");
		FileUtils.copyFile(screenshot, new File(screenshots + FileName));
		log.info("Taking screenshot");
	}

	public void teardown()// Browser close
	{
		driver.quit();
		if (crDriver != null)
			crDriver.quit();
		if (edDriver != null)
			edDriver.quit();
		log.info("Closing browser");
	}

	@AfterSuite
	public void saveReport()// Saving reports
	{
		report.flush();
		log.info("Saving reports");
	}

}
