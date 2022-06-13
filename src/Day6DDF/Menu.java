package Day6DDF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Menu {

	public static void main(String[] args) throws Exception {
		  System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
	      WebDriver wd = new ChromeDriver();
		  wd.get("https://opensource-demo.orangehrmlive.com/");
	      wd.manage().window().maximize();
	      System.out.println("Webpage Title---> " + wd.getTitle());
	      
	      FileInputStream fis = new FileInputStream("C:\\Squad Selenium\\ExcelData.xlsx");
	   
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
	      XSSFSheet sh = wb.getSheet("OHMMenu");
	      
	      wd.findElement(By.id("txtUsername")).sendKeys("admin");//id Locator
          wd.findElement(By.name("txtPassword")).sendKeys("admin123");//name Locator
          wd.findElement(By.className("button")).click();//className Locator
	    
         
         List<WebElement> menu = wd.findElements(By.className("main-menu-first-level-list-item"));
      for(int i=0;i<menu.size();i++)
      {
    	  XSSFRow rw = sh.createRow(i);
    	  XSSFCell res = rw.createCell(2);
    	  System.out.println(menu.get(i).getText());
    	  
    	  res.setCellValue(menu.get(i).getText());
    	   }
      FileOutputStream fos = new FileOutputStream("C:\\Squad Selenium\\ExcelData.xlsx");
      wb.write(fos);
	}
      		
        	 
          
	
	
	
	
	
	
	
	
	}


