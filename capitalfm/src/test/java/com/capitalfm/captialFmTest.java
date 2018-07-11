/**
 * 
 */
package com.capitalfm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * @author nareshbandaru
 *
 */
public class captialFmTest extends TestBase {

	public void sampleTest(WebDriver driver) {
		this.driver = driver;
	}
	@Test
	public void testTrackPlayingNow() throws InterruptedException {
		openBrowser("chrome");
		navigateUrl();
		WebElement ele = driver.findElement(By.xpath("(//div[@class='artist'])"));
		System.out.println(ele.getText());
		 //Assert.assertTrue("Calvin Harris".equals(ele));
	}
	
	@FindBy (xpath="//a[@class='see_more']")WebElement seemore;
	@FindBy (xpath="(//div[@class='song__text-content'])")WebElement songs;
	@Test
	public void clickseemore() {
		//jsclick(seemore);
		seemore.click();
		int i=0;
		WebElement song= driver.findElement(By.xpath("(//div[@class='song__text-content'])"));
		while(!song.equals("Calvin Harris feat. Dua Lipa")) 
		{
			i++;
		driver.findElement(By.xpath("//div[@class='song__text-content'])")).sendKeys(Keys.DOWN);
		System.out.println(song.getText());
		if(i>10)
			break;
		}
		if(i>10) {
			System.out.println("element found");
		}else {
			System.err.println("element not found");
		}
		}	
		
}
		
	
		
   
	
	
	
   
	



