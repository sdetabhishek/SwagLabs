package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utils.TestUtils;

public class CheckoutCompletePage extends BaseTest {

	public CheckoutCompletePage() throws IOException {
		super();


		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Checkout: Complete!']")
	WebElement checkoutcompletepage;

	public void validateOrderConfirmation(String orderMessage) {
		TestUtils.waitForElemementToAppear(checkoutcompletepage);

		WebElement confirmationMessageElement = driver
				.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
		String confirmationMessage = confirmationMessageElement.getText();

		if (orderMessage.contains(confirmationMessage))
			System.out.println("Order placed Successfully");

	}

}
