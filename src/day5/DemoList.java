package day5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoList {

	public static void main(String[] args) {

		
		 System.setProperty("webdriver.chrome.driver" , "./chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.get("https://opensource-demo.orangehrmlive.com/");
			wd.manage().window().maximize();
			
	
			wd.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
			wd.findElement(By.cssSelector("input[type=password]")).sendKeys("admin123");
			wd.findElement(By.cssSelector("input.button")).click();
            
			Actions act = new Actions(wd);
			List<WebElement> menu=wd.findElements(By.className("firstLevelMenu"));
			System.out.println("Size of Menu---> " + menu.size());
			for(int i=0;i<menu.size();i++)
			{
				System.out.println(menu.get(i).getText());
				act.moveToElement(menu.get(i)).perform();
			}
				
			
	
			
			
	}

}
