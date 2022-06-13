package Assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class FrontAccounting {

	public static void main(String[] args) throws Exception {
		 System.setProperty("webdriver.chrome.driver" ,"./chromedriver.exe");
	    WebDriver wd = new ChromeDriver();
		wd.get("http://frontaccounting.squadinfotech.in");
		wd.manage().window().maximize();
		wd.findElement(By.name("user_name_entry_field")).sendKeys("fauser13");
		wd.findElement(By.name("password")).sendKeys("fauser13");
		
		Select s = new Select(wd.findElement(By.name("company_login_name")));//DropDown Handles
		s.selectByValue("3");
		wd.findElement(By.name("SubmitUser")).click();
		
		Actions act = new Actions(wd);//mouseHover handles
		
		act.moveToElement(wd.findElement(By.linkText("selected"))).perform();//Select particular menu
			
		List<WebElement>menu=wd.findElements(By.className("menu_tab"));//find multiple elements
		
		System.out.println("Size of Menu---> " + menu.size());
		
		for(int i=0;i<menu.size();i++)//for loop
		{
			System.out.println(menu.get(i).getText());//to print text of all the element on console.
			act.moveToElement(menu.get(i)).perform();//to perform mousehover on all elements of menu
			
		}
         List<WebElement>subMenu=wd.findElements(By.className("menu_option"));//SUBMENU OF SALES
		
		System.out.println("Size of subMenu---> " + subMenu.size());
		
		for(int i=0;i<subMenu.size();i++)

	{
			System.out.println(subMenu.get(i).getText());//to print text of all the element on console.
			act.moveToElement(subMenu.get(i)).perform();//to perform mousehover on all elements of menu
			
	}
			TakesScreenshot ts = (TakesScreenshot)wd;
			FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),new File("./FAscrnshot.png"));
			
			
	
			
			
		
			
			
		
	}

}
