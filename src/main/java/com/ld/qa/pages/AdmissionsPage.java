package com.ld.qa.pages;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ld.qa.base.TestBase;

public class AdmissionsPage extends TestBase{
	
	@FindBy(xpath="//div[@class='span6 span12-tablet margin-small']")
	List<WebElement> undergraduateAdmissions;
	
	@FindBy(xpath="//a[text()='Undergraduate Programs >']")
	WebElement undergraduatePrograms;

	public AdmissionsPage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
		
	}
	
	//Verify the title of the current page
	public String verifyPageTitle()
	{

		return driver.getTitle();
	}
	
	public ProgramsPage clickUndergraduatePrograms() throws Exception {
		
		undergraduatePrograms.click();
		
		return new ProgramsPage();
	}
	

}
