package day9TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo2App {
	@Test(groups = { "FrontAccounting" })
	public void fa() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("http://frontaccounting.squadinfotech.in");
	}

	@Test(groups = { "Orange" })
	public void orange() {
		System.setProperty("webdriver.chrome.driver", "C:\\Squad Selenium\\Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/");
		wd.manage().window().maximize();

		wd.findElement(By.id("txtUsername")).sendKeys("admin");// id Locator
		wd.findElement(By.name("txtPassword")).sendKeys("admin123");// name Locator
		wd.findElement(By.className("button")).click();

	}
}
