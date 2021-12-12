package test_Cases;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import base.TestConfiguration;
import junit.framework.Assert;
import utils.Excel_Util;
import utils.Locator_Util;



@RunWith(Parameterized.class)
public class StudentRegistrationTest 
{
	static JavascriptExecutor js;
	String firstname,lastname,email,gender,mobile,hobby,address;
	int rownum;
	
	public StudentRegistrationTest(Object firstname,Object lastname,Object email,Object gender,Object mobile,Object hobby,Object address, Object result,Object rownum)
	{
		System.out.println("test object creation");
		this.firstname=firstname.toString();
		this.lastname=lastname.toString();
		this.email=email.toString();
		this.gender=gender.toString();
		this.mobile=mobile.toString();
		this.hobby=hobby.toString();
		this.address=address.toString();
		this.rownum=(int)rownum;
		
	}
	
	@BeforeClass
	public static void setUp() throws InterruptedException, IOException
	{
		System.out.println("beforeclass");
		TestConfiguration.setUpDriver();
		TestConfiguration.driver.manage().window().maximize();
		js=(JavascriptExecutor) TestConfiguration.driver;
	}
	
	
	
	@Test
	public void toolsqa_form() throws InterruptedException, IOException
	{
		TestConfiguration.driver.get(TestConfiguration.getConfigProperty("url"));				
	    Locator_Util.findelement(TestConfiguration.getObjectProperty("firstname")).clear();
	    Locator_Util.findelement(TestConfiguration.getObjectProperty("firstname")).sendKeys(firstname);
	    
	    Locator_Util.findelement(TestConfiguration.getObjectProperty("lastname")).clear();
	    Locator_Util.findelement(TestConfiguration.getObjectProperty("lastname")).sendKeys(lastname);
	    
	    Locator_Util.findelement(TestConfiguration.getObjectProperty("email")).clear();
	    Locator_Util.findelement(TestConfiguration.getObjectProperty("email")).sendKeys(email);
	    
	    switch(Excel_Util.getCellValue(rownum, 3))
	    {
	    	case "male":
	    		Locator_Util.findelement(TestConfiguration.getObjectProperty("male")).click();
	    		break;
	    	case "female":
	    		Locator_Util.findelement(TestConfiguration.getObjectProperty("female")).click();
	    		break;
	    	case "others":
	    		Locator_Util.findelement(TestConfiguration.getObjectProperty("others")).click();
	    		break;
	    }
	    
	    
	    Locator_Util.findelement(TestConfiguration.getObjectProperty("mobile")).clear();;
	    Locator_Util.findelement(TestConfiguration.getObjectProperty("mobile")).sendKeys(mobile);
	   
	 
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	   
	    switch(Excel_Util.getCellValue(rownum, 5))
	    {
	    	case "music":
	    		Locator_Util.findelement(TestConfiguration.getObjectProperty("music")).click();
	    		break;
	    	case "sports":
	    		Locator_Util.findelement(TestConfiguration.getObjectProperty("sports")).click();
	    		break;
	    	case "reading":
	    		Locator_Util.findelement(TestConfiguration.getObjectProperty("reading")).click();
	    		break;
	    }

	 
	    Locator_Util.findelement(TestConfiguration.getObjectProperty("address")).sendKeys(address);

	   Locator_Util.findelement(TestConfiguration.getObjectProperty("submit")).click();
	  	Thread.sleep(1000);
	  	
	  	try {
	  	if(Locator_Util.findelement("css:#example-modal-sizes-title-lg").isDisplayed())
	  	{
	  		Excel_Util.setCellValue(rownum,7,"pass");
	  	}
	  	}
	  	catch(Exception e)
	  	{
	  	Excel_Util.setCellValue(rownum,7,"fail");
	  	}
		
	}
	
		
	@Parameters
	public static List<Object[]> testdata() throws IOException
	{
		System.out.println("parameters loading");
		TestConfiguration.setUp();
		Excel_Util.setup_testdata();
		Excel_Util.printexcel();
		Object[][] exceldata=new Object[Excel_Util.getRowCount()-1][Excel_Util.getColCount()+1];
		int index=0;
		for(int row=1;row<Excel_Util.getRowCount();row++)
		{
			for(int col=0;col<Excel_Util.getColCount();col++)
			{
				exceldata[index][col]=Excel_Util.getCellValue(row, col);
			}
			exceldata[index][exceldata[0].length-1]=index+1;
			index++;
		}
		return Arrays.asList(exceldata);
	}
    
	@AfterClass
	public static void close()
	{
		Excel_Util.printexcel();
		TestConfiguration.teardown();
	}


    
}