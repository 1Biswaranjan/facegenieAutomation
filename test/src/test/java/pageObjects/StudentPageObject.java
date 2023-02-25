package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudentPageObject {
	
    WebDriver driver;
	
	public StudentPageObject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void emailid(String email)
	{
		driver.findElement(By.name("email")).sendKeys(email);
	}
	
	public void password(String password)
	{
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	public void click()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void goToManageStudent()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Manage Student']")).click();
	}
	
	public void searchStudentByName(String name)
	{
		driver.findElement(By.name("nameorId")).sendKeys(name);
	}
 
	public void searchStudentByClass()
	{
		driver.findElement(By.xpath("(//div[@id='demo-simple-select-helper'])[1]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='CLASS 5']")).click();
	}
	public void searchStudentByDivison()
	{
		driver.findElement(By.xpath(" (//div[@id='demo-simple-select-helper'])[2]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='A']")).click();
	}
	public void searchStudentByBusNo()
	{
		driver.findElement(By.xpath("(//div[@id='demo-simple-select-helper'])[3]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='BUS NO 43']")).click();
	}
	public void searchStudentByAdimiStat()
	{
		driver.findElement(By.xpath("(//div[@id='demo-simple-select-helper'])[4]")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Studying']")).click();
	}
}
	

