package day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoImplicitWait {

	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.get("https://opensource-demo.orangehrmlive.com/");
			
			wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
         wd.manage().window().maximize();
         System.out.println("Webpage Title---> " + wd.getTitle());
         
         wd.findElement(By.id("txtUsername")).sendKeys("admin");//id Locator
         wd.findElement(By.name("txtPassword")).sendKeys("admin123");//name Locator
         wd.findElement(By.className("button")).click();//className Locator
         wd.findElement(By.partialLinkText("Welcome")).click();//PartialLinkText Locator
         
         wd.findElement(By.linkText("Logout")).click();
	}
	}


