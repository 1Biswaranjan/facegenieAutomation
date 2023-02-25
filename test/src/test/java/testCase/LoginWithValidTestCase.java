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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPageObject;

public class LoginWithValidTestCase {
	
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
    		extenthtml = new ExtentHtmlReporter(".\\ExtentReport\\login with valid data.html");
    		extenthtml.config().setDocumentTitle("login with valid data automation");
    		extenthtml.config().setReportName("login with valid data report");
    		extenthtml.config().setTheme(Theme.DARK);
    		
    		extent = new ExtentReports();
    		extent.attachReporter(extenthtml);
    		extent.setSystemInfo("browser", "chrome");
    		extent.setSystemInfo("browser", "firefox");
    		extent.setSystemInfo("browser", "edgebrowser");
    		extent.setSystemInfo("Tester Name", "Biswaranjan");		
    	}
       
	
     @Test(dataProvider="data")
	void chromeLogin(String email , String pass) throws InterruptedException
	{
    	 test=extent.createTest("chromeLogin");
		driver=new ChromeDriver();
		driver.get("https://facegenie-ams-school.web.app/");
		driver.manage().window().maximize();
		LoginPageObject lp = new LoginPageObject(driver);
		lp.emailid(email);
		lp.password(pass);
		lp.click();
		String actualResult=driver.getTitle();
		Assert.assertEquals(actualResult, expectedTitle);
		Thread.sleep(3000);
		driver.close();
	}
     
     @Test(dataProvider="data")
	void fireFoxLogin(String email , String pass) throws InterruptedException
	{
    	 test=extent.createTest("fireFoxLogin");
		driver=new FirefoxDriver();
		driver.get("https://facegenie-ams-school.web.app/");
		driver.manage().window().maximize();
		LoginPageObject lp = new LoginPageObject(driver);
		lp.emailid(email);
		lp.password(pass);
		lp.click();
		String actualResult=driver.getTitle();
		Assert.assertEquals(actualResult, expectedTitle);
		Thread.sleep(3000);
		driver.close();
	}
     
     @Test(dataProvider="data")
	void edgeLogin(String email , String pass) throws InterruptedException
	{
    	 test=extent.createTest("edgeLogin");
		driver=new EdgeDriver();
		driver.get("https://facegenie-ams-school.web.app/");
		driver.manage().window().maximize();
		LoginPageObject lp = new LoginPageObject(driver);
		lp.emailid(email);
		lp.password(pass);
		lp.click();
		String actualResult=driver.getTitle();
		Assert.assertEquals(actualResult, expectedTitle);
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
 			test.log(Status.FAIL, "login with valid data test case fail");
 		}
 		else if (result.getStatus()==ITestResult.SUCCESS)
 		{
 			test.log(Status.PASS, "login with valid data test case pass");
 		}
 		
 	}
	

}
