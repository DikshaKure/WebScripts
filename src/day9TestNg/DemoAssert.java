package day9TestNg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAssert {

//Assertion----> it is to verify that actual result & expected result
	// are matching or not

	@Test
	public void googleAssert() {
		System.setProperty("webdriver.chrome.driver", "C:\\Squad Selenium\\Driver\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.google.com/");

		// String expectedTitle = "Gogle"; //If there is no matching result then test
		// will fail
		String expectedTitle = "Google"; // If there is matching result then test will fail
		String actualTitle = wd.getTitle();

		assertEquals(actualTitle, expectedTitle);

		System.out.println("Actual Title of Webpage---> " + actualTitle);

	}
}
