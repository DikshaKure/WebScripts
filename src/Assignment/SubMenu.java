package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SubMenu {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver" ,"./chromedriver.exe");
			WebDriver wd = new ChromeDriver();
		wd.get("http://frontaccounting.squadinfotech.in");
		wd.manage().window().maximize();
		wd.findElement(By.name("user_name_entry_field")).sendKeys("fauser13");
		wd.findElement(By.name("password")).sendKeys("fauser13");
		
		Select s = new Select(wd.findElement(By.name("company_login_name")));//DropDown Handles
		s.selectByValue("3");
		wd.findElement(By.name("SubmitUser")).click();
		
		Actions act = new Actions(wd);//MOUSEHOVER HANDLE
		

		
		act.moveToElement(wd.findElement(By.className("selected"))).perform();//FOR SALES
		
		List<WebElement>subMenu=wd.findElements(By.className("menu_option"));//SUBMENU OF SALES
		
		System.out.println("Size of subMenu---> " + subMenu.size());
		
		for(int i=0;i<subMenu.size();i++)

	{
			System.out.println(subMenu.get(i).getText());//to print text of all the element on console.
			act.moveToElement(subMenu.get(i)).perform();//to perform mousehover on all elements of menu
			
			}
	}

}
