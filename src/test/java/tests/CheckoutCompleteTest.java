package tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutCompletePage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OverviewPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class CheckoutCompleteTest extends BaseTest {

	public LoginPage loginPage;
	public ProductsPage productPage;
	public YourCartPage yourCartPage;
	public OverviewPage overviewPage;
	public CheckoutPage checkoutPage;
	public CheckoutCompletePage checkoutCompletePage;

	public CheckoutCompleteTest() throws IOException {
		super();

	}

	@BeforeMethod

	public void setUp() throws IOException {

		initialization();
		loginPage = new LoginPage();
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(dataProvider = "getData")
	public void checkoutInfoTest(String productName, String orderMessage) throws IOException {

		productPage = new ProductsPage();
		productPage.addProductToCart(productName);
		YourCartPage yourCartPage = new YourCartPage();
		yourCartPage.verifyProductOnCartPage(productName);
		checkoutPage = new CheckoutPage();
		checkoutPage.checkoutInformation();
		overviewPage = new OverviewPage();
		overviewPage.checkoutOverview(productName);
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
		checkoutCompletePage.validateOrderConfirmation(orderMessage);
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Sauce Labs Backpack", "Thank you for your order!" } };
	}

}
