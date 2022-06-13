package Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WriteData {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver" ,"./chromedriver.exe");
	    WebDriver wd = new ChromeDriver();
		wd.get("http://frontaccounting.squadinfotech.in");
		wd.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream("C:\\Squad Selenium\\FAReadData.xls");
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheet("FAWrite");
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			HSSFRow rw= sh.getRow(i);
			HSSFCell un = rw.getCell(0);
			HSSFCell pw= rw.getCell(1);
			HSSFCell res = rw.createCell(2);
			
			System.out.println("Username===> " + un + " password====> " +pw);
		
		wd.findElement(By.name("user_name_entry_field")).sendKeys(un.toString());
		wd.findElement(By.name("password")).sendKeys(pw.toString());
		Select s = new Select(wd.findElement(By.name("company_login_name")));
		s.selectByVisibleText("MT_OL_51");
		wd.findElement(By.name("SubmitUser")).click();
		
		try {
			
			wd.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
			wd.findElement(By.xpath("//*[contains(text(),'Click here to Login Again')]")).click();
			System.out.println("Valid");
			res.setCellValue("Valid");
			
		} catch (Exception e) 
		{
			wd.findElement(By.xpath("//*[contains(text(),'Try again')]")).click();
			System.out.println("Invalid");
			res.setCellValue("Invalid");
			
			TakesScreenshot ts = (TakesScreenshot)wd;
			FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("./" + un + " .png "));
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream("C:\\Squad Selenium\\FAReadData.xls");
		wb.write(fos);
		
		

	}

}
}
