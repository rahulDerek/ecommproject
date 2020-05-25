package com.ld.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ld.qa.base.TestBase;
import com.ld.qa.pages.AdmissionsPage;
import com.ld.qa.pages.HomePage;

public class AdmissionsPageTest extends TestBase {
	
	AdmissionsPage admissionsPage;
	HomePage homePage;
	
	public AdmissionsPageTest() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		homePage = new HomePage();
		admissionsPage = homePage.clickAdmissionsLink();
		
	}
	
	@Test(priority=1)
	public void validatePageTitle() throws Exception
	{
		
		String pageTitle = admissionsPage.verifyPageTitle();
		
		System.out.println("The page title is "+pageTitle);
		
		Assert.assertEquals(pageTitle, "Admissions | The University of British Columbia","The actual and expected page title is not correct");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}

	
}
