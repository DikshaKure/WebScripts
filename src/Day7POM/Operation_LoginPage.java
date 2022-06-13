package Day7POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Operation_LoginPage {

		WebDriver wd;
		public Operation_LoginPage(WebDriver wd)

	
	{
		this.wd=wd;
		
	}
//repository of webelement

	By uname = By.id("txtUsername");
	By pword = By.id("txtPassword");
    By lgin = By.id("btnLogin");
    
    //repository method
    public void url()
    {
		  wd.get("https://opensource-demo.orangehrmlive.com/");
      }
    public void username(String un) 
    {
    	wd.findElement(uname).sendKeys(un);
    }
	public void password(String pw)
	{
		wd.findElement(pword).sendKeys(pw);
		}
	public void login()
	{
		wd.findElement(lgin).click();
	}
	public void loginProcess(String un, String pw) 
	{
		username(un);
		password(pw);
		login();
	}
	
	}

