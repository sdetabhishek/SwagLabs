package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utils.TestUtils;

public class OverviewPage extends BaseTest {

	public OverviewPage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='Checkout: Overview']")
	WebElement overviewpage;

	public void checkoutOverview(String productName) {

		TestUtils.waitForElemementToAppear(overviewpage);

		WebElement productOverview = driver.findElement(By.xpath("//div[@class='cart_item']"));
		String productOverviewName = productOverview.getText();

		if (productOverviewName.contentEquals(productName));
			
		    driver.findElement(By.id("finish")).click();

	}

}
