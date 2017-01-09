package com.auto.test;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.auto.base.controller.Assertion;
import com.auto.base.controller.ContextManager;
import com.auto.base.controller.Logging;
import com.auto.base.controller.TestPlan;
import com.auto.base.util.DateUtil;

public class TestPlatform extends TestPlan{
	
	@Test(groups="test")
	public void test() throws Exception{
		
		System.out.println(ContextManager.getThreadContext().getPool());
		
		Logging.log("hello spire");
		
		/*WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
		
		Thread.sleep(500);
		
		driver.close();
		*/
		/*WebUXDriver driver1=new WebUXDriver("chrome","LOCALLY_ON_RC");
		
		driver1.get("http://www.google.com");
		
		Thread.sleep(500);
		
		driver1.close();*/
		
		WebDriver driver2=new FirefoxDriver();
		
		driver2.get("http://www.google.com");
		
		Thread.sleep(500);
		
		driver2.close();
	}
	
	public static void main(String[] args) {
	
		System.out.println(DateUtil.before(new Date(), new Date()));
		
		Logging.log("hello spire");
		
		Assertion.assertEquals(12, 10,"");
		
	}
	
}
