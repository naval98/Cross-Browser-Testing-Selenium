package com.vts.testing.Cross_BrowserTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_BrowserTesting {

	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			throw new RuntimeException("Browser Not Supported!");
		}
	}

	@Test
	public void Login() {
		driver.get("https://demowebshop.tricentis.com/");
		String actual = driver.getTitle();
		Assert.assertTrue(actual.contains("Demo Web Shop"));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}