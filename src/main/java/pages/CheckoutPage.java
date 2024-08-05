package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utils.TestUtils;

public class CheckoutPage extends BaseTest {

	public CheckoutPage() throws IOException {
		super();

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	WebElement checkoutpage;

	public void checkoutInformation() {

		TestUtils.waitForElemementToAppear(checkoutpage);

		driver.findElement(By.id("first-name")).sendKeys("Abhishek");
		driver.findElement(By.id("last-name")).sendKeys("Kumar");
		driver.findElement(By.id("postal-code")).sendKeys("273001");

		driver.findElement(By.id("continue")).click();
	}

}
