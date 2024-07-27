package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class YourCartPage extends BaseTest{

	public YourCartPage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//span[text()='Your Cart']" )
	WebElement YourCartPage;
	
//	@FindBy(xpath = "//div[contains(@class,'inventory_item_name')]")
//	WebElement addedProduct;
	
	
	public void verifyProductOnCartPage(String productName) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(YourCartPage));

		

		WebElement addedProduct = driver.findElement(By.xpath("//div[contains(@class,'inventory_item_name')]"));
		String addedproductname = addedProduct.getText();



		if (addedproductname.contentEquals(productName)) {
			System.out.println("Product Successfully added to Cart");

			driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		}

	}

}
