package com.capitalfm;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.capitalfm.Constants.*;

public class TestBase {
	
	public static WebDriver driver;
	public Properties testdata, OR;
	public WebDriverWait wait;
	

	public void openBrowser(String browser) throws InterruptedException {
		
		if (FIREFOX_BROWSER.equalsIgnoreCase(browser)) {
			System.setProperty(WEBDRIVER_GECKO, DRIVER_LOC);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/nareshbandaru/downloads/chromedriver");
			driver = new ChromeDriver();		
		}
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	public void navigateUrl() {
		driver.get(CAPITAL_URL);
	} 
	
	public WebElement getObject(String xpathkey) {
		return driver.findElement(By.xpath(OR.getProperty(xpathkey)));
	}

	public void waittime(WebElement element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void checktittle(String ExpectedResults) {
		String pagetittle = driver.getTitle();
		System.out.println(pagetittle);
		if (pagetittle.equalsIgnoreCase(ExpectedResults)) {
			System.out.println("Application launching correctly");
		} else {
			System.err.println("Not launching correctly");
		}
	}

	public void jsclick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

}