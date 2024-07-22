package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class TestUtils extends BaseTest {

	public static long PAGE_LOAD_TIME = 20;
	public static long IMPLICIT_WAIT = 10;

	public TestUtils() throws IOException {
		super();

	}

	public static void waitForElemementToAppear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
