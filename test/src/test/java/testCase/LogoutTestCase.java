package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects.LogoutPageObject;

public class LogoutTestCase {

	WebDriver driver;
	String expectedTitle="Rai-Test-Bams"; 
    @DataProvider(name="data")
    Object[][] getData()
    {
 	   Object[][] data = {{"testing@gmail.com","testing@123"}};
 	   return data;
    }
    ExtentHtmlReporter extenthtml;
 	ExtentReports extent;
 	ExtentTest test;
 	
 	@BeforeTest
 	void setExtent()
 	{
 		extenthtml = new ExtentHtmlReporter(".\\ExtentReport\\logout.html");
 		extenthtml.config().setDocumentTitle("logout automation");
 		extenthtml.config().setReportName("logout test");
 		extenthtml.config().setTheme(Theme.DARK);
 		
 		extent = new ExtentReports();
 		extent.attachReporter(extenthtml);
 		extent.setSystemInfo("browser", "chrome");
 		extent.setSystemInfo("browser", "firefox");
 		extent.setSystemInfo("browser", "edgebrowser");
 		extent.setSystemInfo("Tester Name", "Biswaranjan");		
 	}
 	
 	@Test(dataProvider="data")
 	void logoutChromebrowser(String email ,String password) throws InterruptedException
 	{
 		driver=new ChromeDriver();
		driver.get("https://facegenie-ams-school.web.app/");
		driver.manage().window().maximize();
 		test=extent.createTest("logoutChromebrowser");
 		LogoutPageObject lp = new LogoutPageObject(driver);
 		lp.emailid(email);
 		lp.password(password);
 		lp.click();
 		Thread.sleep(3000);
 		lp.dashBoard();
 		lp.logOut();
 		String actualTitle=driver.getTitle();
 		Assert.assertEquals(actualTitle, expectedTitle);
 		Thread.sleep(3000);
 		driver.close();
 	}
 	@Test(dataProvider="data")
 	void logoutfirefoxbrowser(String email ,String password) throws InterruptedException
 	{
 		driver=new FirefoxDriver();
		driver.get("https://facegenie-ams-school.web.app/");
		driver.manage().window().maximize();
 		test=extent.createTest("logoutfirefoxbrowser");
 		LogoutPageObject lp = new LogoutPageObject(driver);
 		lp.emailid(email);
 		lp.password(password);
 		lp.click();
 		Thread.sleep(4000);
 		lp.dashBoard();
 		lp.logOut();
 		String actualTitle=driver.getTitle();
 		Assert.assertEquals(actualTitle, expectedTitle);
 		Thread.sleep(3000);
 		driver.close();

 	}
 	@Test(dataProvider="data")
 	void logoutedgebrowser(String email ,String password) throws InterruptedException
 	{
 		driver=new EdgeDriver();
		driver.get("https://facegenie-ams-school.web.app/");
		driver.manage().window().maximize();
 		test=extent.createTest("logoutedgebrowser");
 		LogoutPageObject lp = new LogoutPageObject(driver);
 		lp.emailid(email);
 		lp.password(password);
 		lp.click();
 		Thread.sleep(4000);
 		lp.dashBoard();
 		lp.logOut();
 		String actualTitle=driver.getTitle();
 		Assert.assertEquals(actualTitle, expectedTitle);
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
 			test.log(Status.FAIL, "logout test case fail");
 		}
 		else if (result.getStatus()==ITestResult.SUCCESS)
 		{
 			test.log(Status.PASS, "logout test case pass");
 		}
 		
 	}
}
