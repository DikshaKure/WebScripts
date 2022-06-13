package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoExplicitWait {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.get("https://opensource-demo.orangehrmlive.com/");
			
			WebDriverWait wt = new WebDriverWait(wd,Duration.ofSeconds(10));
		 wd.manage().window().maximize();
      System.out.println("Webpage Title---> " + wd.getTitle());
      
      wd.findElement(By.id("txtUsername")).sendKeys("admin");//id Locator
      wd.findElement(By.name("txtPassword")).sendKeys("admin123");//name Locator
      wd.findElement(By.className("button")).click();//className Locator
      wd.findElement(By.partialLinkText("Welcome")).click();//PartialLinkText Locator
      
      wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
     
      wd.findElement(By.linkText("Logout")).click();
	}
	
	}


