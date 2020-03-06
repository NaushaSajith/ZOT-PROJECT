package com.Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FWUtils extends BaseTest
{
		
		public static void verifyPage(WebDriver driver,String expectedTitle)
		{		
		
			String actualTitle=driver.getTitle();
			if(actualTitle.equals(expectedTitle))
			{
				System.out.println("The Expected Page Title is Displayed-->"+expectedTitle);
			}
			else
			{
					System.out.println("The Actual page Title is not Displayed-->"+actualTitle);
			}
		}
		
		
//		/**
//		 * This Method Use To Read The Data From The Excel
//		 * @param path
//		 * @param sheet
//		 * @param row
//		 * @param cell
//		 * @return
//		 * @throws EncryptedDocumentException
//		 * @throws FileNotFoundException
//		 * @throws IOException
//		 */
		public static String read_Xl_Data(String path,String sheet,int row,int cell) 
		{
			String data="";
			try
			{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			 data= wb.getSheet(sheet).getRow(row).getCell(cell).toString();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return data;
		}
		/**
//		 * This Method Is Used to Write Data Into XL File
//		 * @param path
//		 * @param sheet
//		 * @param row
//		 * @param cell
//		 * @return
//		 */
		public static String write_DataInto_Xl(String path,String sheet,int row,int cell) 
		{
			String data="";
			try {
				Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			    wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
			    
			    wb.write(new FileOutputStream(path));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return data;
		
		}
//		    
//		     * @param path
//	         * @param sheet
//  		 * @return
//	         */
		public static int xl_Row_Count(String path,String sheet)
		{
			int rc=0;
			try
			{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rc;
		}
//		/**
//		 * This Method is Used to TakesScreenShot If the testcase gets Faile
//		 * @param driver
//		 * @param path
//		 */
		
		
		public static void takesSreeenShots(WebDriver driver,String path) 
		{
			try
			{		
			     TakesScreenshot ts = (TakesScreenshot)driver;
			     File src = ts.getScreenshotAs(OutputType.FILE);
			     File des=new File(path);
			     FileUtils.copyFile(src, des);
			}
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
//		
//		/**
//		 * This Method is Created For Specifying ExplicitWaiting Conditions
//		 * @param wait
//		 * @return
//		 */
//		
		public static WebDriverWait waitingCondition(WebDriverWait wait)
		{
			return new WebDriverWait(driver,ETO);
		}

	}


