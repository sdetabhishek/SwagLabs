package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utils.TestUtils;

public class LoginPage extends BaseTest {

	public LoginPage() throws IOException {

		super();

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user-name")
	WebElement username;

	@FindBy(name = "password")
	WebElement pwd;

	@FindBy(name = "login-button")
	WebElement login;
	
	@FindBy( className ="login_logo")
	WebElement logo;
	
	@FindBy( xpath ="//button[text()='Open Menu']")
	WebElement openmenu;
	
	
	
	public boolean validateLogo() {
		
		return logo.isDisplayed();
	}




public void validateLogin(String name, String pass) {

	username.sendKeys(name);
	pwd.sendKeys(pass);
	login.click();
	TestUtils.waitForElemementToAppear(openmenu);
	
}
}