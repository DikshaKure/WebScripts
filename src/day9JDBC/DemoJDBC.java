package day9JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoJDBC {

	public static void main(String[] args) throws Exception 
	{
        System.setProperty("webdriver.chrome.driver" ,"C:\\Squad Selenium\\Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/");

		wd.manage().window().maximize();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://148.72.215.41:3306/testingdb","testuser","testuser");
	java.sql.Statement st = con.createStatement();
	ResultSet res;
	res = st.executeQuery("select* from Orange51");
	
	String u,p;
	while(res.next()) {
		u = res.getString(1);
		p= res.getString(2);
		System.out.println(u + "  " + p );
		
		 wd.findElement(By.id("txtUsername")).sendKeys("admin");//id Locator
         wd.findElement(By.name("txtPassword")).sendKeys("admin123");//name Locator
         wd.findElement(By.className("button")).click();//className
	}
	
		 }

}
