package day9TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class TwoApp {
	WebDriver wd;
	@BeforeSuite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Squad Selenium\\Driver\\chromedriver.exe");
		 wd = new ChromeDriver();
	}
	@Test
	public void orange() {
		wd.get("https://opensource-demo.orangehrmlive.com/");
		wd.manage().window().maximize();
		wd.findElement(By.id("txtUsername")).sendKeys("Admin");// id Locator
		wd.findElement(By.name("txtPassword")).sendKeys("admin123");// name Locator
		wd.findElement(By.className("button")).click();// className Locator
		wd.findElement(By.partialLinkText("Welcome")).click();// PartialLinkText Locator

		wd.findElement(By.linkText("Logout")).click();

	}

	@Test
	public void blazeDemo()
	{
	wd.get("https://blazedemo.com");

	}
	@AfterSuite
	public void closeBrowser(){

		wd.close();

		
	}
}
