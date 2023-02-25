package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPageObject {

    WebDriver driver;
	
	public LogoutPageObject(WebDriver driver)
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

	public void dashBoard()
	{
		driver.findElement(By.xpath("(//span[normalize-space()='Log Out'])[1]")).click();
	}
	
	public void logOut()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
	}
	
	
	
}
