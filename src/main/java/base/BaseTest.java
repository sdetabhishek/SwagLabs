package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.TestUtils;

public class BaseTest {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	public BaseTest() throws IOException {
	
	
	 prop = new Properties();

		FileInputStream fis = new FileInputStream("C:\\Users\\1118a\\seleniumprojects\\SwagLabs\\src\\main\\java\\resource\\config.properties");
	    prop.load(fis);
	   
	    
	
	}
	
	
	public void initialization(){
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\1118a\\seleniumprojects\\SwagLabs\\ExeFile\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIME));
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
