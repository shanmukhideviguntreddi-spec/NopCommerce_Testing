package tests;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nopcommerce.base.Base;
import com.nopcommerce.pages.HomePage;

import dataprovider.DataProviderClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
Author: 
Create on: 
Purpose:Step definition file for cucumber
*/
public class Validate_menus_and_count_links extends Base {
//Creating objects for the classes to call their methods
	Base base = new Base();
	HomePage homepage = new HomePage();

	Validations validate = new Validations();
	DataProviderClass data = new DataProviderClass();
	// Declaring web elements like page object model
	By login = By.className("ico-login");
	By email1 = By.id("Email");
	By password1 = By.id("Password");
	By loginbutton = By.xpath("//button[@class='button-1 login-button']");
	By menu = By.xpath("/html/body/div[6]/div[2]/ul[1]/li/a");
	By logout = By.className("ico-logout");
	By logoutR = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
	By title = By.className("page-title");
	By firstname = By.id("FirstName");
	By lastname = By.id("LastName");
	By email = By.id("Email");
	By password = By.id("Password");
	By confirmpasssword = By.id("ConfirmPassword");
	By registerbutton = By.id("register-button");

	@Given("^user should open (.+)$")
	public void user_should_open(String browser) throws Throwable {
		if (browser.matches("chrome"))
			homepage.chromesetup();// Browser configuration
		else
			homepage.edgesetup();
		homepage.initializeProperties();
		reporter = new ExtentSparkReporter(prop.getProperty("ExtentReport4"));
		reporter.config().setDocumentTitle(prop.getProperty("ExtentReport4Title"));
		reporter.config().setReportName(prop.getProperty("ExtentReport4TestName"));
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo(prop.getProperty("ExtentReport4SysInfo1"), prop.getProperty("ExtentReport4SysInfo2"));
	}

	@Given("^count the number of links on the page and store in list and text file on (.+)$")
	public void count_the_number_of_links_on_the_page_and_store_in_list_and_text_file(String browser) throws Throwable {
		if (browser.equalsIgnoreCase("chrome")) {
			List<WebElement> lst = crDriver.findElements(menu);
			File output = new File(prop.getProperty("TestCase4TxtFilePath1"));
			FileWriter writer = new FileWriter(output);
			for (int i = 0; i < lst.size(); i++) {
				writer.write(lst.get(i).getText() + "\n");
				lst = crDriver.findElements(menu);
			}
			writer.write("No.of links on chrome: " + Integer.toString(lst.size()));
			writer.flush();
			writer.close();
			log.info("Counting the number of links on the page and storing in list and text file");
		} else {
			List<WebElement> lst = edDriver.findElements(menu);
			File output = new File(prop.getProperty("TestCase4TxtFilePath1"));
			FileWriter writer = new FileWriter(output);
			for (int i = 0; i < lst.size(); i++) {
				writer.write(lst.get(i).getText() + "\n");
				lst = edDriver.findElements(menu);
			}
			writer.write("No.of links on Edge: " + Integer.toString(lst.size()));
			writer.flush();
			writer.close();
			log.info("Counting the number of links on the page and storing in list and text file");
		}
	}

	@Given("^open each link in list and get screenshot on (.+)$")
	public void open_each_link_in_list_and_get_screenshot(String browser) throws Throwable {
		log.info("Opening each link in list and getting screenshot");
		if (browser.equalsIgnoreCase("chrome")) {
			List<WebElement> lst = crDriver.findElements(menu);
			for (int i = 0; i < lst.size(); i++) {
				String s = lst.get(i).getText();
				lst.get(i).click();
				try {
					Thread.sleep(1500);
				} catch (Exception e) {
				}
				homepage.takescreenshot(" " + browser + " " + s);
				try {
					Thread.sleep(1500);
				} catch (Exception e) {
				}
				lst = crDriver.findElements(menu);
			}
		} else {
			List<WebElement> lst = edDriver.findElements(menu);
			for (int i = 0; i < lst.size(); i++) {
				String s = lst.get(i).getText();
				lst.get(i).click();
				try {
					Thread.sleep(1500);
				} catch (Exception e) {
				}
				homepage.takescreenshot(" " + browser + " " + s);
				try {
					Thread.sleep(1500);
				} catch (Exception e) {
				}
				lst = edDriver.findElements(menu);
			}
		}
	}

	@When("^user enters valid url on (.+)$")
	public void user_enters_valid_url(String browser) throws Throwable {
		if (browser.matches("chrome")) {
			crDriver.get(prop.getProperty("url"));
			log.info("Url Opened on chrome");
		} else {
			edDriver.get(prop.getProperty("url"));
			log.info("Url Opened on edge");
		}
		log.info("Url Opened on chrome");
	}

	@When("^user user clicks on Register on (.+)$")
	public void registerUser(String browser) throws Throwable {
		homepage.openregister(browser);
	}

	@When("^user enters valid (.+),(.+),(.+) and click Register on (.+)$")
	public void registeringUser(String fName, String lName, String pass, String browser) throws Throwable {
		log.info("Registering user");
		if (browser.equalsIgnoreCase("chrome")) {
			DataProviderClass.generateRandomEmail();
			crDriver.findElement(firstname).sendKeys(fName);// To enter first name
			crDriver.findElement(lastname).sendKeys(lName);// To enter last name
			crDriver.findElement(email).sendKeys(randomEmail);// To enter email
			crDriver.findElement(password).sendKeys(pass);// To enter confirm password
			crDriver.findElement(confirmpasssword).sendKeys(pass);// To enter password
			crDriver.findElement(registerbutton).click();// To click on register button
			log.info("Email on chrome: " + randomEmail);
		} else {
			DataProviderClass.generateRandomEmail();
			edDriver.findElement(firstname).sendKeys(fName);// To enter first name
			edDriver.findElement(lastname).sendKeys(lName);// To enter last name
			edDriver.findElement(email).sendKeys(randomEmail);// To enter email
			edDriver.findElement(password).sendKeys(pass);// To enter confirm password
			edDriver.findElement(confirmpasssword).sendKeys(pass);// To enter password
			edDriver.findElement(registerbutton).click();// To click on register button
			log.info("Email on edge: " + randomEmail);
		}
		log.info("User registered");
	}

	@When("^user click on logout after register on (.+)$")
	public void user_click_on_logoutAfterRegister(String browser) throws Throwable {
		if (browser.equalsIgnoreCase("chrome"))
			crDriver.findElement(logoutR).click();
		else
			edDriver.findElement(logout).click();
	}

	@When("^user click on login on (.+)$")
	public void user_click_on_login(String browser) throws Throwable {
		homepage.openlogin(browser);
	}

	@When("^user enters valid (.+) and click login on (.+)$")
	public void user_enters_valid_and_click_login(String password, String browser) throws Throwable {
		if (browser.equalsIgnoreCase("chrome")) {
			crDriver.findElement(email1).sendKeys(randomEmail);
			crDriver.findElement(password1).sendKeys(password);
			crDriver.findElement(loginbutton).click();
			log.info("User enters valid email and password");
		} else {
			edDriver.findElement(email1).sendKeys(randomEmail);
			edDriver.findElement(password1).sendKeys(password);
			edDriver.findElement(loginbutton).click();
			log.info("User enters valid email and password");
		}
	}

	@When("^user click on logout on (.+)$")
	public void user_click_on_logout(String browser) throws Throwable {
		if (browser.equalsIgnoreCase("chrome"))
			crDriver.findElement(logout).click();
		else
			edDriver.findElement(logout).click();
	}

	@Then("^nopcommerce portal should be opened on (.+)$")
	public void nopcommerce_portal_should_be_opened(String browser) throws Throwable {
		validate.verifyHomepage(browser);
	}

	@Then("^Register page should be opened on (.+)$")
	public void registerPageOpened(String browser) throws Throwable {
		validate.verifyRegistrationPage(browser);
	}

	@Then("^user should be registered on (.+)$")
	public void registeredSucess(String browser) throws Throwable {
		validate.verifyRegistrationStatus(browser);
	}

	@Then("^user should be loggedout after register on (.+)$")
	public void user_should_be_loggedoutAfterRegister(String browser) throws Throwable {
		if (browser.equalsIgnoreCase("chrome")) {
			test = report.createTest("Verify to logout after Register on Chrome");
			try {
				if (crDriver.findElement(login).isDisplayed()) {

					File output = new File(prop.getProperty("TestCase4TxtFilePath2"));
					FileWriter writer = new FileWriter(output);
					writer.write("Successfully logged out");
					writer.flush();
					writer.close();
					test.log(Status.PASS, "Logged out succesfully");
				}
			} catch (Exception e) {
				test.log(Status.FAIL, "User not loggedout");
			}
			homepage.saveReport();
		} else {
			test = report.createTest("Verify to logout after Register on Edge");
			try {
				if (edDriver.findElement(login).isDisplayed()) {

					File output = new File(prop.getProperty("TestCase4TxtFilePath2"));
					FileWriter writer = new FileWriter(output);
					writer.write("Successfully logged out");
					writer.flush();
					writer.close();
					test.log(Status.PASS, "Logged out succesfully");
				}
			} catch (Exception e) {
				test.log(Status.FAIL, "User not loggedout");
			}
			homepage.saveReport();
		}
	}

	@Then("^login page should be displayed on (.+)$")
	public void login_page_should_be_displayed(String browser) throws Throwable {
		validate.verifyLoginpage(browser);
	}

	@Then("^user should be logged in on (.+)$")
	public void user_should_be_logged_in(String browser) throws Throwable {
		validate.verifyLoginStatus(browser);
		base.takescreenshot(" UserLoggedin");
	}

	@Then("^user should be loggedout on (.+)$")
	public void user_should_be_loggedout(String browser) throws Throwable {
		if (browser.equalsIgnoreCase("chrome")) {
			test = report.createTest("Verify to logout on " + browser);
			try {
				if (crDriver.findElement(login).isDisplayed()) {

					File output = new File(prop.getProperty("TestCase4TxtFilePath2"));
					FileWriter writer = new FileWriter(output);
					writer.write("Successfully logged out on " + driver);
					writer.flush();
					writer.close();
					test.log(Status.PASS, "Logged out succesfully on " + browser);
				}
			} catch (Exception e) {
				test.log(Status.FAIL, "User not loggedout on " + browser);
			}
			crDriver.quit();
		} else {
			test = report.createTest("Verify to logout on " + browser);
			try {
				if (edDriver.findElement(login).isDisplayed()) {

					File output = new File(prop.getProperty("TestCase4TxtFilePath2"));
					FileWriter writer = new FileWriter(output);
					writer.write("Successfully logged out on " + driver);
					writer.flush();
					writer.close();
					test.log(Status.PASS, "Logged out succesfully on " + browser);
				}
			} catch (Exception e) {
				test.log(Status.FAIL, "User not loggedout on " + browser);
			}
			edDriver.quit();
		}
		homepage.saveReport();
	}

}
