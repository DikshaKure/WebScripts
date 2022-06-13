package day9TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsOrange {
	WebDriver wd;

	@BeforeSuite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Squad Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeClass
	public void loginProcess() {
		wd.get("https://opensource-demo.orangehrmlive.com/");
		wd.manage().window().maximize();
		wd.findElement(By.id("txtUsername")).sendKeys("admin");// id Locator
		wd.findElement(By.name("txtPassword")).sendKeys("admin123");// name Locator
		wd.findElement(By.className("button")).click();// className Locator
	}

	@Test
	public void myInfo() {
		wd.findElement(By.id("menu_pim_viewMyDetails")).click();
	}

	@Test
	public void pim() {
		wd.findElement(By.id("menu_pim_viewPimModule")).click();
	}

	@AfterClass
	public void logoutProcess() {
		wd.findElement(By.partialLinkText("Welcome")).click();// PartialLinkText Locator
		wd.findElement(By.linkText("Logout")).click();
	}

	@AfterSuite
	public void closeBrowse() {
		wd.quit();
	}
}
