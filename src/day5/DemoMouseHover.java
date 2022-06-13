package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoMouseHover {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.get("https://opensource-demo.orangehrmlive.com/");
            wd.manage().window().maximize();
   
         
        wd.findElement(By.id("txtUsername")).sendKeys("admin");//id Locator
     wd.findElement(By.name("txtPassword")).sendKeys("admin123");//name Locator
    wd.findElement(By.className("button")).click();//className Locator
	
   Actions act = new Actions(wd);
  // act.moveToElement(wd.findElement(By.className("firstLevelMenu"))).perform();
   act.moveToElement(wd.findElement(By.id("menu__Performance"))).perform();
   
	
	
	}

}
