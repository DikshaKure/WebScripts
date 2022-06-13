package day9TestNg;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DemoDataProvder {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println(n + " " + s);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	
    	//return type in DataProvider is mandatory
    	//first array represents a data set
    	//second array contains the parameter values
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
      new Object[] { 3, "c" },
    };
  }
}
