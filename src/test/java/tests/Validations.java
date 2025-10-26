package tests;

import java.io.File;
import java.io.FileWriter;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.Base;
import com.nopcommerce.pages.ComputersPage;
import com.nopcommerce.pages.DesktopsPage;
import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoggedinPage;
import com.nopcommerce.pages.LoginPage;
import com.nopcommerce.pages.MyAccountPage;
import com.nopcommerce.pages.ProductPage;
import com.nopcommerce.pages.RegistrationPage;
import com.nopcommerce.pages.RegistrationSuccesPage;
import com.nopcommerce.pages.ShoppingCart;

/*
Author: 
Create on: 
Purpose:Validations for all test cases
*/
public class Validations extends Base {
	// Creating objects for all the page classes
	Base base = new Base();
	HomePage homepage = new HomePage();
	RegistrationPage registartionpage = new RegistrationPage();
	RegistrationSuccesPage registrationsuccess = new RegistrationSuccesPage();
	LoginPage loginpage = new LoginPage();
	LoggedinPage loggedinpage = new LoggedinPage();
	MyAccountPage myaccountpage = new MyAccountPage();
	DesktopsPage desktopspage = new DesktopsPage();
	ProductPage productpage = new ProductPage();
	ComputersPage computerspage = new ComputersPage();
	ShoppingCart shoppingcart = new ShoppingCart();

	public void verifyHomepage(String browser)// To verify Nopcommerce portal
	{
		test = report.createTest("Verify to display nopcommerce portal on " + browser);
		try {
			a.assertEquals(homepage.getHomePageTitle(browser).contains("nopCommerce"), true);
			test.log(Status.PASS, "nopCommerce portal is displayed on " + browser);
		} catch (Exception e) {
			test.log(Status.FAIL, "nopCommerce portal is not displayed on " + browser);
		}
		log.info("Verifying nopcommerce portal homepage");
	}

	public void verifyRegistrationPage(String browser)// To verify registration page
	{
		log.info("Verifying to display registerpage");
		test = report.createTest("Verify to display registerpage  on " + browser);
		try {
			Assert.assertEquals(registartionpage.getRegistartionPageTitle(browser), "Register");
			test.log(Status.PASS, "Registartion page is displayed on " + browser);
		} catch (Exception e) {
			test.log(Status.FAIL, "Registration page is not displayed on " + browser);
		}

	}

	public void verifyRegistrationStatus(String browser) throws Exception// To verify registration status
	{
		log.info("Verifying registration status");
		test = report.createTest("Registration Acknowledgement on " + browser);
		try {
			String message1 = registrationsuccess.getRegistrationStatus(browser);// To get registration acknowledgement
			File output = new File(prop.getProperty("TestCase1TxtFilePath"));
			FileWriter writer = new FileWriter(output);
			writer.write(message1);
			writer.flush();
			writer.close();
			String actualmessage = "Your registration completed";
			if (message1.equals(actualmessage))
				test.log(Status.PASS, "Successfully registered on " + browser);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to register  on " + browser);
		}

	}

	public void verifyLoginpage(String browser)// Verify to display login page
	{
		test = report.createTest("Verify to display loginpage on "+browser);
		try {
			Assert.assertEquals(loginpage.getLoginPageBanner(browser), "Welcome, Please Sign In!");
			test.log(Status.PASS, "Login Page is displayed on "+browser);
		} catch (Exception e) {
			test.log(Status.FAIL, "Login page is not displayed "+browser);
		}
		log.info("Verify to display loginpage");
	}

	public void verifyLoginStatus(String browser)// To verify login status
	{
		test = report.createTest("Verify user logged in status on " + browser);
		try {
			Assert.assertEquals(loggedinpage.getLoginStatus(), "My account");
			test.log(Status.PASS, "User loggedin succesfully on " + browser);
		} catch (Exception e) {
			test.log(Status.FAIL, "Login failed on " + browser);
		}
		log.info("Verifying login status");
	}

	public void verifyMyaccountpagetitle()// Verify to display my account
	{
		test = report.createTest("Verify to display my acccount");
		try {
			a.assertEquals(myaccountpage.getMyAccountTitle(), true);
			test.log(Status.PASS, "My account page is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "My account page is not displayed");
		}
	}

	public void verifyAddressstatus()// To verify address status
	{
		test = report.createTest("Verify add address");
		try {
			Assert.assertEquals(myaccountpage.getAddressDetailsStatus() > 0, true);
			test.log(Status.PASS, "Address added");
		} catch (Exception e) {
			test.log(Status.FAIL, "Address not added");
		}
		log.info("Verify to add address");
	}

	public void getProductDetails() throws Exception// To get product details
	{
		log.info("Getting product details and saving in text file");
		String[] productdetails = productpage.getProductNamePrice();
		File output = new File(prop.getProperty("TestCase3TxtFilePath"));// To initialize text file
		FileWriter writer = new FileWriter(output);
		writer.write(productdetails[0] + "\n" + productdetails[1]);// To enter values into text file
		writer.flush();// To save text file
		writer.close();

	}

	public void verifyDesktopProducts()// Verifying to display desktop products
	{
		test = report.createTest("Verify to display desktop products");
		try {
			a.assertEquals(desktopspage.getProductName(), ("Digital Storm VANQUISH 3 Custom Performance PC"));
			test.log(Status.PASS, "Desktop products displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Desktop products not displayed");
		}
		log.info("Verifying desktop products");
	}

	public void verifyProductAddedtoCartStatus()// To verify product added to cart
	{
		log.info("Verifying product added to cart status");
		test = report.createTest("Verify product added to cart status");
		try {
			a.assertEquals(productpage.getAddedToCartMessage().contains("The product has been added to your "), true);
			test.log(Status.PASS, productpage.getAddedToCartMessage());
		} catch (Exception e) {
			test.log(Status.FAIL, "Product not added to cart");
		}

	}

	public void verifyToDisplayShoppingCart()// To verify shopping cart
	{
		log.info("Verifying to display shopping cart");
		test = report.createTest("Verify to display shoppingcart");
		try {
			Assert.assertEquals(shoppingcart.getShoppinCartPageTitle(), "Shopping cart");
			test.log(Status.PASS, "Shopping cart is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Shopping cart is not displayed");
		}

	}

	public void verifyToDisplayCheckoutPage()// To verify checkout page
	{
		log.info("Verifying to display checkout page");
		test = report.createTest("Verify to display checkout page");
		try {
			a.assertEquals(shoppingcart.getCheckoutPage() > 0, true);
			test.log(Status.PASS, "Checkout page is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Checkout page is not displayed");
		}

	}

	public void verifyToDisplayDeliveryDetails()// To verify delivery details
	{
		log.info("Verifying delivery details");
		test = report.createTest("Delivery details page status");

		try {
			a.assertEquals(shoppingcart.getDeliveryDetails().contains("billing address"), true);
			test.log(Status.PASS, "Delivery details page is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Delivery details page is not displayed");
		}

	}

	public void verifyOrderStatus() throws Exception// To verify order status
	{
		log.info("Verifying order status");
		test = report.createTest("Verify order status");
		Thread.sleep(1500);
		try {
			Assert.assertEquals(shoppingcart.getOrderStatus().contains("Thank you"), true);
			test.log(Status.PASS, "Order placed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Order not placed");
		}

	}

	public void verifyTYMessage() throws Exception// To verify thank you message
	{
		log.info("Verifying thankyou message");
		test = report.createTest("Verify thank you message");
		Thread.sleep(1500);
		try {
			a.assertEquals(shoppingcart.getOrderStatus(), "Thank you");
			test.log(Status.PASS, "Thank you message is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Thank you message is not displayed");
		}

	}

	public void verifyToLogoutFromRegistrationPage()// To check logout status
	{
		test = report.createTest("Verify to logout from registration page");
		try {
			if (registrationsuccess.getLogoutStatus() > 0)
				test.log(Status.FAIL, "User not logged in when registration completed");
		} catch (Exception e) {
			test.log(Status.PASS, "Loggedout");
		}
		log.info("Verifying logout");

	}

	public void verifyToLogout()// To check logout status
	{
		test = report.createTest("Verify to logout");
		try {
			if (registrationsuccess.getLogoutStatus() > 0)
				test.log(Status.PASS, "Sucessfully loggedout");
		} catch (Exception e) {
			test.log(Status.PASS, "Loggedout");
		}
		log.info("Verifying logout");
	}

}
