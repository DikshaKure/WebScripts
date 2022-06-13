package day5;

import java.io.File;
import java.nio.channels.FileLock;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DemoSreenShort {

	public static void main(String[] args) throws Exception {
		 System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.get("https://opensource-demo.orangehrmlive.com/");
         wd.manage().window().maximize();
         System.out.println("Webpage Title---> " + wd.getTitle());
         
         wd.findElement(By.id("txtUsername")).sendKeys("admin");//id Locator
         wd.findElement(By.name("txtPassword")).sendKeys("admin123");//name Locator
         wd.findElement(By.className("button")).click();//className Locator
	   
         TakesScreenshot ts = (TakesScreenshot)wd;
         FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),new File("./screenshot.png"));
         
	
	
	}

}
