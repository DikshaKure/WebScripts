package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fa_LogoutPage {
	
	WebDriver wd;
	public Fa_LogoutPage(WebDriver wd) {
		 
		this.wd=wd;
	}
	//repository of webelements
	
	By lgout = By.xpath("//*[contains(text(),'Logout')]");
	
	//repository for method
	
	public void Logout() {
		wd.findElement(lgout).click();
	}
    public void logoutProcess() {
    	Logout();
    }


}
	


