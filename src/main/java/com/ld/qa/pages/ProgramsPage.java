package com.ld.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ld.qa.base.TestBase;

public class ProgramsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='upper-ui-filters']//div[@class='filter-toggle-control']/div[@class='filters']/div[@class='campus-filter-control']/div[@class='checkbox-control']/label[@for='vancouver']")
	WebElement filterByCampusVan;
	
	@FindBy(xpath="//header[@class='upper-ui-container context-desktop']//select/option")
	List<WebElement> courseOptions;
	
	
	public ProgramsPage() throws Exception{
		PageFactory.initElements(driver, this);
		
	}
	
	public void selectCampus()
	{
		filterByCampusVan.click();
		
	}
	
	public void displayCourseOptions()
	{
		
		int noOfCourses = courseOptions.size();
		
		
		for(int i =0; i < noOfCourses;i++)
		{
			
			String courseName = driver.findElement(By.xpath("//header[@class='upper-ui-container context-desktop']//select/option["+(i+1)+"]")).getText();
			
			System.out.println("The course name is  "+ courseName);
			
			
		}
		
		
	}
	
	public void courseSelection(String course) throws Exception
	{
		
		WebElement courseName = driver.findElement(By.xpath("//header[@class='upper-ui-container context-desktop']//select"));
		
		Select sel = new Select(courseName);
						
		//sel.selectByVisibleText("Bachelor of Arts");
		
		sel.selectByVisibleText(course);
		
		Thread.sleep(5000);
		
		
	}
	

}
