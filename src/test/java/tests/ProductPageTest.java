package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductPageTest extends BaseTest {

	public LoginPage loginPage;
	public ProductsPage productPage;

	public ProductPageTest() throws IOException {
		super();

	}

	
	@BeforeMethod
	public void setUp() throws IOException {

		initialization();
		loginPage = new LoginPage();
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(dataProvider = "getFilterData")
	public void filter(String filtername) throws IOException {
		
		productPage = new ProductsPage();
		
		productPage.filterProduct(filtername);
	}
	
	@Test(dataProvider = "getData")
	public void addProductToCart(String productName) throws IOException {

		productPage = new ProductsPage();
		productPage.addProductToCart(productName);
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { {"Sauce Labs Backpack"} };
	}
	
	@DataProvider
	public Object[][] getFilterData() {

		return new Object[][] { {"Name (A to Z)"}, {"Name (Z to A)"}, {"Price (low to high)"}, {"Price (high to low)"}};
	}

}
