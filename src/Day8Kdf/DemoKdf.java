package Day8Kdf;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Day7POM.Operation_LoginPage;
import Day7POM.Operation_LogoutPage;

public class DemoKdf {

	public static void main(String[] args) throws Exception {
			  System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
		      WebDriver wd = new ChromeDriver();
			 
			  
			  wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  
		      Operation_LoginPage lp = new Operation_LoginPage(wd);
		      Operation_LogoutPage lg = new Operation_LogoutPage(wd);
		      
				 
		      FileInputStream fis = new FileInputStream("C:\\Squad Selenium\\ExcelData.xlsx");
		      
			  XSSFWorkbook wb = new XSSFWorkbook(fis);
		      XSSFSheet sh = wb.getSheet("KeywordOHM");
		      
		for(int i=1;i<=sh.getLastRowNum();i++) {
			XSSFRow rw = sh.getRow(i);
			XSSFCell key = rw.getCell(1);
			System.out.println(key);
			
			switch (key.toString()) {
			
			case "url":
				lp.url();
				break;
				
			case "username":
				lp.username("admin");
				break;
				
			case "password":
				lp.password("admin123");
				break;
				
			case "login":
				lp.login();
				break;
				
			case "welcome":
				lg.welcome();
				break;
				
			case "logout":
				lg.logout();
				break;

			default:
				System.out.println("Invalid Keyword");
				break;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
	}
