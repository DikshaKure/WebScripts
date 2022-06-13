package Day7POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Pomddf {

	public static void main(String[] args) throws Exception {
		  System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
	      WebDriver wd = new ChromeDriver();
		  wd.get("https://opensource-demo.orangehrmlive.com/");
		  
		  wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	      Operation_LoginPage lp = new Operation_LoginPage(wd);
	      Operation_LogoutPage lg = new Operation_LogoutPage(wd);
	      
			 
	      FileInputStream fis = new FileInputStream("C:\\Squad Selenium\\ExcelData.xlsx");
	      
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
	      XSSFSheet sh = wb.getSheet("OHMWrite");
	      
	      for(int i=1;i<=sh.getLastRowNum();i++)
	    	  
	      {
	      XSSFRow rw = sh.getRow(i);
	      XSSFCell un = rw.getCell(0);
	      XSSFCell pw = rw.getCell(1);
	      XSSFCell res = rw.createCell(2);//it will create cell at specified index
	      System.out.println("Username===> " + un + " password====> " +pw);
	      
	      //wd.findElement(By.id("txtUsername")).sendKeys(un.toString());//id Locator
	     // wd.findElement(By.name("txtPassword")).sendKeys(pw.toString());//name Locator
	      //wd.findElement(By.className("button")).click();//className Locator
	  
	      lp.loginProcess(un.toString(), pw.toString());
	     
	      try {
	//  wd.findElement(By.partialLinkText("Welcome")).click();//PartialLinkText Locator 
	  //wd.findElement(By.linkText("Logout")).click();
	  
	  lg.LogoutProcess();
		 System.out.println("Valid");
	  res.setCellValue("Valid");
			
		} catch (Exception e)
	      {
			System.out.println("Invalid");
			res.setCellValue("Invalid");
			
		TakesScreenshot ts = (TakesScreenshot)wd;
		FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("./" + un + ".png "));
	      
	      } 
		}

	fis.close();
	
	   
	FileOutputStream fos = new FileOutputStream("‪C:\\Squad Selenium\\ExcelData.xlsx");
    wb.write(fos);
}



	}


