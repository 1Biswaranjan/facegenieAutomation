package testCase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects.StudentPageObject;

public class SearchStudent {
	
	WebDriver driver;
   
	ExtentHtmlReporter extenthtml;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	void setExtent()
	{
		extenthtml = new ExtentHtmlReporter(".\\ExtentReport\\search student Report.html");
		extenthtml.config().setDocumentTitle("searchstudent automation");
		extenthtml.config().setReportName("student report");
		extenthtml.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(extenthtml);
		extent.setSystemInfo("browser", "chrome");
		extent.setSystemInfo("Tester Name", "Biswaranjan");		
	}
	
	@BeforeMethod
	void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://facegenie-ams-school.web.app/");
		driver.manage().window().maximize();
	}
	
	@Test
	void searchStudent() throws InterruptedException
	{
		test=extent.createTest("searchStudent");
		StudentPageObject sp = new StudentPageObject(driver);
		sp.emailid("testing@gmail.com");
		sp.password("testing@123");
		sp.click();
		Thread.sleep(3000);
		sp.goToManageStudent();
		Thread.sleep(1500);
		sp.searchStudentByName("ram kadam");
		sp.searchStudentByClass();
		sp.searchStudentByDivison();
		sp.searchStudentByBusNo();
		sp.searchStudentByAdimiStat();
		Thread.sleep(3000);
		driver.close();
	}
	@AfterTest
	void closeExtent()
	{
		extent.flush();
	}
	@AfterMethod
	void testresult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "search student test case fail");
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "search student test case pass");
		}
		
	}

}
