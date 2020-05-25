package com.ld.qa.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ld.qa.base.TestBase;
import com.ld.qa.pages.AdmissionsPage;
import com.ld.qa.pages.HomePage;
import com.ld.qa.pages.ProgramsPage;
import com.ld.qa.util.TestUtil;

public class ProgramsPageTest extends TestBase{
	
	HomePage homePage;
	
	AdmissionsPage admissionsPage;
	
	ProgramsPage programsPage;
	String sheetName1 ="course";
	
	String sheetName2 ="sample";

	public ProgramsPageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		homePage = new HomePage();
		admissionsPage = new AdmissionsPage();
		homePage.clickAdmissionsLink();
		programsPage =admissionsPage.clickUndergraduatePrograms();
		
		
	}
		
	@Test(priority=1)
	public void displayCourses() throws Exception
	{
		programsPage.selectCampus();
		Thread.sleep(1000);
		programsPage.displayCourseOptions();
		
	}
	
	@DataProvider
	public Object[][] getCourseData()
	{
		Object[][] data =TestUtil.getTestData(sheetName1); 
		return data;
		
		
		
	}
	@Test(priority=2,dataProvider="getCourseData")
	public void selectCourse(String courseName)
 throws Exception
	{
		programsPage.selectCampus();
		Thread.sleep(1000);
		
		programsPage.courseSelection(courseName);
		
		
		
	}
	
	@DataProvider
	public Object[][] getSampleData()
	{
		Object[][] data =TestUtil.getTestData(sheetName2); 
		return data;
	
	}

	
	@Test(priority=3,dataProvider="getSampleData")
	public void sampleTest(String firstname,String lastname,String company,String dateofhire)throws Exception
	{
		System.out.println("The firstname is "+firstname+"lastname is "+lastname+" company is "+company+"date of hire is"+dateofhire);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}

}
