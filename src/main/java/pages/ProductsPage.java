package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;
import utils.TestUtils;

public class ProductsPage extends BaseTest {

	public ProductsPage() throws IOException {
		super();
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Open Menu']")
	WebElement openmenu;

	@FindBy(xpath = "//div[contains(@class,'inventory_item_description')]")
	List<WebElement> productlist;

	@FindBy(xpath = "//span[text()='Products']")
	WebElement ProductPage;

	@FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
	WebElement cartLink;
	
	@FindBy(xpath = "//span[contains(@class,'active_option')]")
	WebElement filterdropdown;
	
	
	
	public void filterProduct(String filtername) {
		
		WebElement filter = driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]"));
		filter.click();
		Select select = new Select(filter);
	    select.selectByVisibleText(filtername);
		
	}

	public void addProductToCart(String productName) {

		TestUtils.waitForElemementToAppear(ProductPage);

		List<WebElement> products = driver
				.findElements(By.xpath("//div[contains(@class,'inventory_item_description')]"));

		for (int i = 0; i < products.size(); i++) {

			WebElement product = products.get(i);
			String ProductName = product.getText();

			if (ProductName.contentEquals(productName))

				break;

		}
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();

		TestUtils.waitForElemementToAppear(cartLink);
		cartLink.click();

	}

}
