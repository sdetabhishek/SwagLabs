package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class YourCartTest extends BaseTest {

	public LoginPage loginPage;
	public ProductsPage productPage;
	public YourCartPage yourCartPage;

	public YourCartTest() throws IOException {
		super();

	}


	@BeforeMethod
	public void setUp() throws IOException {

		initialization();
		loginPage = new LoginPage();
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(dataProvider = "getData")
	public void validateProductOnCartPage(String productName) throws IOException {

		productPage = new ProductsPage();
		productPage.addProductToCart(productName);
		YourCartPage yourCartPage = new YourCartPage();
		yourCartPage.verifyProductOnCartPage(productName);
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "Sauce Labs Backpack" }};
	}
}
