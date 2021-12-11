package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Excel_Util;


public class TestBase {
	public static WebDriver driver;
	private static Properties config_prop,objectrep_prop;
	private static FileInputStream config_fis,objectrep_fis;
	
	
	public static void setUp()
	{
		try {
			System.out.println("testbase resource setup");
			config_fis=new FileInputStream("src\\configuration\\config.properties");
			config_prop=new Properties();
			config_prop.load(config_fis);
			objectrep_fis=new FileInputStream(config_prop.getProperty("objectrep_path"));
			objectrep_prop=new Properties();
			objectrep_prop.load(objectrep_fis);
						}
			catch (Exception e)
			{
		// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
	}
	
	public static String getObjectProperty(String property)
	{
		return objectrep_prop.getProperty(property);
	}
	
	public static String getConfigProperty(String property)
	{
		return config_prop.getProperty(property);
	}
	public static void setUpTestData(String sheetname) throws IOException
	{
		System.out.println("excel setup");
		Excel_Util.setExcelFile(sheetname);
		
	}
	
	public static void setUpDriver(String browser)
	{
		System.out.println("driver setup");
		switch(browser)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", config_prop.getProperty("chrome_path"));
			driver=new ChromeDriver();
			break;
		}
	}
	
	public static void teardown() 
	{
		System.out.println("teardown");
		try {
			config_fis.close();
			objectrep_fis.close();
			Excel_Util.workbook.close();
			driver.quit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
