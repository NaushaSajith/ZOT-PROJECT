package com.Script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Generic.BaseTest;
import com.Generic.FWUtils;
import com.pages.LoginPage;

public class TestLoginPage extends BaseTest
	{	

		@Test(priority=1)
		public void test_validLoginPage() throws InterruptedException
		{	
			String un = FWUtils.read_Xl_Data(XL_DATA_PATH,"ValidLoginPage",1,0);
			String pw = FWUtils.read_Xl_Data(XL_DATA_PATH,"ValidLoginPage",1,1);
			String expectedTitle = FWUtils.read_Xl_Data(XL_DATA_PATH,"ValidLoginPage",1,2);
				
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(un);
			lp.setPassWord(pw);
			lp.clickOnLgnBTN();
			Thread.sleep(2000);
			FWUtils.verifyPage(driver,expectedTitle);
		}
		@Test(priority=0)
		public void  test_InvalidLoginPage() throws InterruptedException
		{
			int rc = FWUtils.xl_Row_Count(XL_DATA_PATH,"InvalidLoginPage");
			Reporter.log("The Number of DataRow count is--->"+rc,true);
			
			LoginPage lp=new LoginPage(driver);
			for(int i=1;i<=rc;i++)
			{
				String un = FWUtils.read_Xl_Data(XL_DATA_PATH,"InvalidLoginPage",i,0);
				String pw=FWUtils.read_Xl_Data(XL_DATA_PATH,"InvalidLoginPage",i,1);
				
				lp.setUserName(un);
				lp.setPassWord(pw);
				lp.clickOnLgnBTN();
				Thread.sleep(2000);
				lp.verifyERRMSG();
			}
		}

	}


