package dayHDF;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Day7POM.Operation_LoginPage;
import Day7POM.Operation_LogoutPage;

public class DemoHdf {

	public static void main(String[] args) throws Exception {
		
		  System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
           WebDriver wd = new ChromeDriver();


		  wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	      Operation_LoginPage lp = new Operation_LoginPage(wd);
	      Operation_LogoutPage lg = new Operation_LogoutPage(wd);
	      
			 
	      FileInputStream fis = new FileInputStream("C:\\Squad Selenium\\ExcelData.xlsx");
	      
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
	      XSSFSheet dsh = wb.getSheet("DataHDF");
	      XSSFSheet ksh = wb.getSheet("KeyHDF");
	      
	      for(int i=1; i<=dsh.getLastRowNum();i++)
	      {
	    	  XSSFRow drw = dsh.getRow(i);
	    	  XSSFCell un = drw.getCell(0);
	    	  XSSFCell pw = drw.getCell(1);
	    	  XSSFCell res = drw.createCell(2);
	    	  System.out.println(un + " " + pw);
	    	  
	      try {
	    	  for (int j=1;j<=ksh.getLastRowNum();j++) 
	    	  {
	    		  XSSFRow krw = ksh.getRow(j);
	    		  XSSFCell key = krw.getCell(1);
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
			
	     System.out.println("PASS");
	     res.setCellValue("PASS");
	      }
	      catch (Exception e) 
	      {
	    	  
	    	 System.out.println("FAIL");
	    	 res.setCellValue("FAIL");
	      }
				
			}
	      fis.close();
	      FileOutputStream fos = new FileOutputStream("C:\\Squad Selenium\\ExcelData.xlsx");
		wb.write(fos);
	}


}
