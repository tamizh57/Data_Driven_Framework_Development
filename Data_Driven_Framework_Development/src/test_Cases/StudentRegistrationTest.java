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
import org.openqa.selenium.interactions.Actions;

import base.TestBase;
import utils.Excel_Util;
import utils.Locator_Util;



@RunWith(Parameterized.class)
public class StudentRegistrationTest 
{
	static JavascriptExecutor js;
	String firstname,lastname,email,gender,mobile,hobby,address,result;
	
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
		
	}
	
	@Before
	public void setUp() throws InterruptedException, IOException
	{
		System.out.println("before");
		TestBase.driver.get(TestBase.getConfigProperty("url"));
				
	}
	
	
	
	@Test
	public void toolsqa_form() throws InterruptedException
	{
		
	    Locator_Util.findelement(TestBase.getObjectProperty("firstname")).clear();
	    Locator_Util.findelement(TestBase.getObjectProperty("firstname")).sendKeys(firstname);
	    
	    Locator_Util.findelement(TestBase.getObjectProperty("lastname")).clear();
	    Locator_Util.findelement(TestBase.getObjectProperty("lastname")).sendKeys(lastname);
	    
	    Locator_Util.findelement(TestBase.getObjectProperty("email")).clear();
	    Locator_Util.findelement(TestBase.getObjectProperty("email")).sendKeys(email);
	    
	    
	    Locator_Util.findelement(TestBase.getObjectProperty("female")).click();
	    Locator_Util.findelement(TestBase.getObjectProperty("mobile")).clear();;
	    Locator_Util.findelement(TestBase.getObjectProperty("mobile")).sendKeys(mobile);
	   
	 
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	   
	    Locator_Util.findelement(TestBase.getObjectProperty("music")).click();
	 
	    Locator_Util.findelement(TestBase.getObjectProperty("address")).sendKeys(address);

	   Locator_Util.findelement(TestBase.getObjectProperty("submit")).click();
	  	 
		
	}
	
		
	@Parameters
	public static List<Object[]> testdata() throws IOException
	{
		System.out.println("parameters loading");
		TestBase.setUp();
		TestBase.setUpTestData("Sheet1");
		Excel_Util.printexcel();
		TestBase.setUpDriver("chrome");
		TestBase.driver.manage().window().maximize();
		js=(JavascriptExecutor) TestBase.driver;

		Object[][] exceldata=new Object[Excel_Util.getRowCount()-1][Excel_Util.getColCount()+1];
		int index=0;
		for(int row=1;row<Excel_Util.getRowCount();row++)
		{
			for(int col=0;col<Excel_Util.getColCount();col++)
			{
				exceldata[index][col]=Excel_Util.getCellValue(row, col);
			}			
			index++;
		}
		return Arrays.asList(exceldata);
	}
    
	@AfterClass
	public static void close()
	{
		TestBase.teardown();
	}


    
}