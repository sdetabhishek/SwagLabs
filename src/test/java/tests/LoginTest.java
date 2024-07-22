package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage loginPage;

	public LoginTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();

		loginPage = new LoginPage();
	}

	@Test
	public void pageLogoTest() {
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
	}

	@Test
	public void loginPageTest() {

		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
