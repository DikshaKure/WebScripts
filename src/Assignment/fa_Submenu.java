package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class fa_Submenu {

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
		
///html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/div/a[1]
///html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/div/a[2]
	
	Actions act = new Actions(wd);
	List<WebElement> menu = wd.findElements(By.xpath("/html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/div/a"));
	for(int i=1; i<=menu.size();i++)
	{
		act.moveToElement(wd.findElement(By.xpath("/html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/div/a["+i+"]"))).perform();
		wd.findElement(By.xpath("/html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/div/a["+i+"]")).click();
		System.out.println(wd.findElement(By.xpath("/html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/div/a["+i+"]")).getText());
		
		///html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/div[2]/table/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/a[1]
		///html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/div[2]/table/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/a[2]
	
	List<WebElement> submenu = wd.findElements(By.xpath("/html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/div[2]/table/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/a"));
	for(int j=1;j<=submenu.size();j++)
	{
		act.moveToElement(wd.findElement(By.xpath("/html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/div[2]/table/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/a["+j+"]"))).perform();
		System.out.println(wd.findElement(By.xpath("/html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/div[2]/table/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/a["+j+"]")).getText());
		
	}
	
}
	
	}

}
