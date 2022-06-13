package day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DemoAlert {

	public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver" ,"./chromedriver.exe");
	WebDriver wd = new ChromeDriver();
	wd.get("http://frontaccounting.squadinfotech.in");
	wd.manage().window().maximize();
	wd.findElement(By.name("user_name_entry_field")).sendKeys("fauser11");
	wd.findElement(By.name("password")).sendKeys("fauser11");
	
	Select s = new Select(wd.findElement(By.name("company_login_name")));//DropDown Handles
	s.selectByValue("3");
	wd.findElement(By.name("SubmitUser")).click();
	
	wd.findElement(By.linkText("Direct Delivery")).click();
	wd.findElement(By.name("CancelOrder")).click();

	Alert alt = wd.switchTo().alert();
	System.out.println("Text of Alert----> " + alt.getText());
	alt.accept();
	
	
	}

}
