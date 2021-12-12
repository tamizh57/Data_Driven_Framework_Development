package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.TestConfiguration;

public class Locator_Util {
	private static WebElement element;
	public static WebElement findelement(String data)
	{
		String[] splitdata=data.split(":");
		switch(splitdata[0])
		{
		case "id":
			element=TestConfiguration.driver.findElement(By.id(splitdata[1]));
			break;
		case "css":
			element=TestConfiguration.driver.findElement(By.cssSelector(splitdata[1]));
			break;
		case "class":
			element=TestConfiguration.driver.findElement(By.className(splitdata[1]));
			break;
		case "name":
			element=TestConfiguration.driver.findElement(By.name(splitdata[1]));
			break;


		}
	
		return element;
	}
	

	
}