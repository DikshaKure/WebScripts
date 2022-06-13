package Day7POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Operation_LogoutPage {
 
	WebDriver wd;
	public Operation_LogoutPage(WebDriver wd)
	{
		this.wd=wd;
	}
   	//repository Webelement
	By wcome = By.id("welcome");
	By lout =By.linkText("Logout");
	
	//Method
	public void welcome()
	{
		wd.findElement(wcome).click();
	}
	public void logout()
	{
		wd.findElement(lout).click();
	}
	public void LogoutProcess()
	{
		welcome();
		logout();
		
	}
}
