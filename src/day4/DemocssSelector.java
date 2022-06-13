package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemocssSelector {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver" , "./chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.get("https://opensource-demo.orangehrmlive.com/");
			wd.manage().window().maximize();
			
			//Tag and id--->css-->tag#id--->tagname#value of id
			wd.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
			//tag and attribute-->css-->tagname[attribute=value of attribute]
			wd.findElement(By.cssSelector("input[type=password]")).sendKeys("admin123");
			
			//tag and classname--->css-->tag.classname--->tagname.value of classname
			wd.findElement(By.cssSelector("input.button")).click();

	}

}
