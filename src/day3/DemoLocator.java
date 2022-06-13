package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoLocator {

	public static void main(String[] args) throws InterruptedException {

		
		 System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.get("https://opensource-demo.orangehrmlive.com/");
            wd.manage().window().maximize();
            System.out.println("Webpage Title---> " + wd.getTitle());
            
            wd.findElement(By.id("txtUsername")).sendKeys("admin");//id Locator
            wd.findElement(By.name("txtPassword")).sendKeys("admin123");//name Locator
            wd.findElement(By.className("button")).click();//className Locator
            wd.findElement(By.partialLinkText("Welcome")).click();//PartialLinkText Locator
            Thread.sleep(2000);
            wd.findElement(By.linkText("Logout")).click();
	}
	
	}

