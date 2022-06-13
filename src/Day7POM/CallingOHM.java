package Day7POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CallingOHM {
	
	public static void main (String[]args) {
		
		System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/");
		
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Operation_LoginPage lp = new Operation_LoginPage(wd);
		
		//lp.username("admin");lp.password("admin123");lp.login();
		Operation_LogoutPage lo= new Operation_LogoutPage(wd);
		
		lp.loginProcess("admin", "admin123");
		lo.LogoutProcess();
	  }
	}
		
	
	
