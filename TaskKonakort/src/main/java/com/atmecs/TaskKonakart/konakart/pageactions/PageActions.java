package com.atmecs.TaskKonakart.konakart.pageactions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;

public class PageActions extends BrowserInvoke {
	SelectLocators selloc =new SelectLocators();
	
	public  void click( String path,String locator) throws IOException {
   // selloc.selLocators(path,locator)
		driver.findElement(selloc.selLocators(path,locator)).click();
	}
	
	


	public  void dropdown( String path,String locator, String value) throws IOException {
		
	
		WebElement element = driver.findElement(selloc.selLocators(path,locator));
		Select select = new Select(element);
	
		select.selectByVisibleText(value);

	
	}
	
	
	public  void sendKeys( String path,String locator, String value) throws IOException {
	
		WebElement element = driver.findElement(selloc.selLocators(path,locator));
		element.sendKeys(value);
		

	}
	
}
