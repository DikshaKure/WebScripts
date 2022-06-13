package Assignment;
	
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Fa_LoginPage {

	WebDriver wd;
	  public  Fa_LoginPage (WebDriver wd) 
	  {
		  this.wd=wd;
		   }
	  //Repository of webelement
	  
	  By uname =By.name("user_name_entry_field");
	  By pword = By.name("password");
	  By cpany = By.name("company_login_name");
	  By lgin = By.name("SubmitUser");
	  
	  // repository for methods
	  
	  public void url()
	  {
		  wd.get("http://frontaccounting.squadinfotech.in");
	  }
	  public void username(String un) {
		  wd.findElement(uname).sendKeys(un);
	  }
	  public void password(String pw) {
		  wd.findElement(pword).sendKeys(pw);
	  }
	  public void company(String cp) {
		  Select s = new Select(wd.findElement(cpany));
		  s.selectByVisibleText(cp);
		   }
	  public void login() {
		  wd.findElement(lgin).click();
	  }
	  public void loginProcess(String un,String pw,String cp)
	  {
		  username(un);
		  password(pw);
		  company(cp);
		  login();
		 
	  }
	  }
