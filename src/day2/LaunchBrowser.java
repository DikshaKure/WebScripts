package day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver" ,"C:\\squad selenium\\selenium Grid\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.google.com/");
		String title = wd.getTitle();
		System.out.println("Title of webpage----> " + title);
		
		wd.close();

	}

}
