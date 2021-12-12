package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Excel_Util;


public class TestConfiguration {
	public static WebDriver driver;
	private static Properties config_prop,objectrep_prop;
	private static FileInputStream config_fis,objectrep_fis;
	
	
	public static void setUp()
	{
		try {
			System.out.println("testbase resource setup");
			config_fis=new FileInputStream("src\\test_configuration\\test_config.properties");
			config_prop=new Properties();
			config_prop.load(config_fis);
			objectrep_fis=new FileInputStream(getConfigProperty("objectrep_path"));
			objectrep_prop=new Properties();
			objectrep_prop.load(objectrep_fis);
			}
			catch (Exception e)
			{
		// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
	
	
	public static void setUpDriver()
	{
		System.out.println("driver setup");
		switch(getConfigProperty("browser_name"))
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", getConfigProperty("driver_path"));
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
			Excel_Util.writeexcel();
			Excel_Util.workbook.close();
			driver.quit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
