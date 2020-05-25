package com.ld.qa.pages;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ld.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//nav[@id='ubc7-unit-navigation']/ul/li")
	WebElement navMenu;
	
	@FindBy(xpath="//nav[@id='ubc7-audience-navigation']/ul[@class='nav']/li")
	List<WebElement> navAudience;
	
	@FindBy(css="a[id='menu-admissions']")
	WebElement admissions;
	
	public HomePage() throws Exception{
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	
	public String verifyPageTitle()
	{
		return driver.getTitle();

	}
	
	
	public AdmissionsPage clickAdmissionsLink() throws FileNotFoundException
	{
		admissions.click();
		return new AdmissionsPage();
		
		
	}
	public void displayMenu() throws InterruptedException
	{
		List<WebElement> menuItems = driver.findElements(By.xpath("//nav[@id='ubc7-unit-navigation']/ul/li"));
		Thread.sleep(3000);
		System.out.print("The menu Items are ");
		for(WebElement m: menuItems)
		{
			System.out.print(m+ "");
		}
		System.out.println();
		
		
	}

	public void audienceMenu()
	{
		int totalAudience = navAudience.size();
		
		for(int i=0;i < totalAudience;i++)
		{
			
			String aud =driver.findElement(By.xpath("//nav[@id='ubc7-audience-navigation']/ul[@class='nav']/li["+(i+1)+"]/a")).getText();
					
			System.out.println("The audience value is  "+  aud);
		}
	}


	
	
	
	
}
