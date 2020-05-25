package com.ld.qa.testcases;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ld.qa.base.TestBase;
import com.ld.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	

	public HomePageTest() throws FileNotFoundException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		homepage = new HomePage();
		
	}
	
	@Test(priority =0)
	public void verifyAbout()
	{
		driver.findElement(By.xpath("//a[contains(text(),'About UBC')]")).click();
	}
	@Test(priority =1)
	public void displayMenuTest() throws Exception {
		
		List<WebElement> menuItems = driver.findElements(By.xpath("//nav[@id='ubc7-unit-navigation']/ul/li"));
		System.out.println("The total number ofo MenuItems are   "+ menuItems.size());
		
		for(int i =0; i < menuItems.size();i++)
		{	
			
			String we = driver.findElement(By.xpath("//nav[@id='ubc7-unit-navigation']/ul/li["+(i+1)+"]/a")).getText();
			
			//String we = driver.findElement(By.cssSelector("nav[id='ubc7-unit-navigation'] ul li:nth-child("+(i+1)+") a")).getText();
			System.out.println(we);
		}
	}
	@Test(priority=2)
	public void displayAudienceMenu() throws InterruptedException {
		
		
		homepage.audienceMenu();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}

}
