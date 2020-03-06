package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage
{
	
		
		//Declaration
		
		@FindBy(id="username")
		private WebElement unTB;
		
		@FindBy(name="pwd")
		private WebElement pwTB;
		
		@FindBy(xpath="//div[text()='Login ']")
		private WebElement lgnBTN;
		
		@FindBy(xpath="//span[contains(text(),'invalid.')]")
		private WebElement errMSG;
		
		//initialization of pom class
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions on Elements
		
		public void setUserName(String un)
		{
			unTB.sendKeys(un);
		}
		
		public void setPassWord(String pw)
		{
			pwTB.sendKeys(pw);
		}
		public void clickOnLgnBTN()
		{
			lgnBTN.click();
		}
		
		public void verifyERRMSG()
		{
			Assert.assertTrue(errMSG.isDisplayed());
			Reporter.log("The ErrMsg Is Displayed-->"+errMSG.getText(),true);
		}
	}

