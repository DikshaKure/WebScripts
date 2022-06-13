package day9TestNg;

import org.testng.annotations.Test;

import Day7POM.Operation_LoginPage;
import Day7POM.Operation_LogoutPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataProviderOrange {
	WebDriver wd;

	@BeforeTest
	public void launchB() {
		System.setProperty("webdriver.chrome.driver", "C:\\Squad Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
	}

	@Test(dataProvider = "dp")
	public void f(String u, String p) {
		wd.get("https://opensource-demo.orangehrmlive.com/");
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Operation_LoginPage lp = new Operation_LoginPage(wd);
		Operation_LogoutPage lo = new Operation_LogoutPage(wd);

		lp.loginProcess(u, p);
		try {
			lo.LogoutProcess();
			System.out.println("PASS");

		} catch (Exception e) {
			System.out.println("FAIL");
		}
	}

	@AfterTest
	public void CloseB() {
		wd.quit();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "admin", "admin123" }, new Object[] { 2, "b" }, };
	}
}
