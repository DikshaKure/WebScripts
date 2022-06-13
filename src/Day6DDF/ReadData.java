package Day6DDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadData {

	public static void main(String[] args) throws Exception  {

	  System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
      WebDriver wd = new ChromeDriver();
	  wd.get("https://opensource-demo.orangehrmlive.com/");
      wd.manage().window().maximize();
      System.out.println("Webpage Title---> " + wd.getTitle());
      
      FileInputStream fis = new FileInputStream("C:\\Squad Selenium\\ExcelData.xlsx");
   
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
      XSSFSheet sh = wb.getSheet("OHMRead");
      
      for(int i=1;i<=sh.getLastRowNum();i++)
    	  
      {
      XSSFRow rw = sh.getRow(i);
      XSSFCell un = rw.getCell(0);
      XSSFCell pw = rw.getCell(1);
      System.out.println("Username===> " + un + " password====> " +pw);
      
      wd.findElement(By.id("txtUsername")).sendKeys(un.toString());//id Locator
      wd.findElement(By.name("txtPassword")).sendKeys(pw.toString());//name Locator
      wd.findElement(By.className("button")).click();//className Locator
      } 
	}

}
