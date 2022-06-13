package Assignment;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class FaReadData {

	public static void main(String[] args) throws Exception {
 
		 System.setProperty("webdriver.chrome.driver" ,"./chromedriver.exe");
		    WebDriver wd = new ChromeDriver();
			wd.get("http://frontaccounting.squadinfotech.in");
			
			wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wd.manage().window().maximize();
			
			FileInputStream fis = new FileInputStream("C:\\Squad Selenium\\FAReadData.xls");
			
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh = wb.getSheet("FARead");
			
			for(int i=1;i<=sh.getLastRowNum();i++)
			{
				HSSFRow rw= sh.getRow(i);
				HSSFCell un = rw.getCell(0);
				HSSFCell pw= rw.getCell(1);
				HSSFCell cp = rw.getCell(2);
				
				System.out.println("Username===> " + un + " password====> " + pw + "company====> " + cp);
			
			wd.findElement(By.name("user_name_entry_field")).sendKeys(un.toString());
			wd.findElement(By.name("password")).sendKeys(pw.toString());
			Select s = new Select(wd.findElement(By.name("company_login_name")));
			s.selectByVisibleText("MT_OL_51");
			wd.findElement(By.name("SubmitUser")).click();
			
		
			wd.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
			wd.findElement(By.xpath("//*[contains(text(),'Click here to Login Again')]")).click();
			
			
			
			}
	}
}
		
			
			
	


