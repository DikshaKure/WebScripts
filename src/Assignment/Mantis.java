package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Mantis {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.get("http://mantis.squadinfotech.in");
		
			wd.findElement(By.id("username")).sendKeys("tester1");
			wd.findElement(By.cssSelector("input[type=submit]")).click();
			wd.findElement(By.cssSelector("input[type=submit]")).click();
	}

}
