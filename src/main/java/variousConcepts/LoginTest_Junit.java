package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {

	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");

	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}

	@Before
	public void init() {
		System.out.println("Before");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() throws InterruptedException {
		try {
		System.out.println("Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	// @Test
	public void negloginTest() throws InterruptedException {
		System.out.println("negTest");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		// testing Git to push code
		//pushing code after creating a new branch

	}

	@After
	public void tearDown() {
		System.out.println("After");
		driver.close();
		// Difference between close and quit
		// close() it will close only active webDriver instance but
		// quit() will close all webDriver
		//driver.quit();

	}
}
