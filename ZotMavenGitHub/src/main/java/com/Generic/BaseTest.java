package com.Generic;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;



	abstract public class BaseTest implements IAutoConstant
		{
			static
			{
				System.setProperty(CHROM_KEY,CHROM_VALUE);
				System.setProperty(GECKO_KEY,GECKO_VALUE);
			}
			
			
			
			public static WebDriver driver;
			
			
			@BeforeTest
		
			public void openBrowser() 
			{
				driver=new ChromeDriver();
				
			}
			
			@BeforeMethod
			public void openApplication()
			{
				driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get("http://localhost/user/submit_tt.do");
			}
			
		
		@AfterTest
		public void closeApplication()
		{

				driver.close();
		}

		}



		





