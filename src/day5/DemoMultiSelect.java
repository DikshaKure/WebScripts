package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoMultiSelect {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver" , "./chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("C:\\Squad Selenium\\Multi.html");
		
		Select s = new Select(wd.findElement(By.id("car")));
		if(s.isMultiple())
		{
			s.selectByIndex(1);
			s.selectByValue("3");
			s.selectByVisibleText("Mercedez");
			Thread.sleep(2000);
			s.deselectByValue("3");
			s.deselectAll(); 
			
			
		}
	
	}

}
