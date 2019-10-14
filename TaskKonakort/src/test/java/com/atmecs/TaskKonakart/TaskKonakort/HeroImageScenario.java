package com.atmecs.TaskKonakart.TaskKonakort;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.TaskKonakart.konakart.pageactions.PageActions;
import com.atmecs.TaskKonakart.konakart.pageactions.SelectLocators;
import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.helpers.SortingDateVerify;
import com.atmecs.TaskKonakart.konakart_automation.helpers.SortingVerification;
import com.atmecs.TaskKonakart.konakart_automation.reports.ExtentReport;
import com.atmecs.TaskKonakart.konakart_automation.reports.LogReport;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.LogStatus;

public class HeroImageScenario extends BrowserInvoke {
	
LogReport log = new LogReport();
static final String locatorprop=FilePath.LOCATORS_FILE;
 
	public void HeroImageValidation() throws IOException, InterruptedException, ParseException {
		SelectLocators selloc = new SelectLocators();
		PageActions pageaction = new PageActions();
	
	
	
		driver.findElement(selloc.selLocators(locatorprop, "loc.heroimage.image")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,800)");
	    
	    driver.findElement(selloc.selLocators(locatorprop,"loc.heroimage.pdtdesc")).isSelected();
	    
		String actual   = driver.findElement(selloc.selLocators(locatorprop,"loc.heroimage.pdtcontent")).getText();

		String text = "1280x800 HD display with polarizing filter and anti-glare technology for rich color and deep contrast from any viewing angle" ;
		
		if(!actual.contains(text)) {
			log.info("Not in the product description page");
		}
		
		Thread.sleep(5000);
		
		driver.findElement(selloc.selLocators(locatorprop, "loc.heroimage.specs")).click();
		
		String actual2= driver.findElement(selloc.selLocators(locatorprop, "loc.heroimage.specscontent")).getText();
		
		String text2 =" product specifications here";
		
		if(!actual2.contains(text2)) {
			log.info("Not in the specification page");
		}
		
		Thread.sleep(3000);
		//selloc.selLocators(FilePath.LOCATORS_FILE, "loc.heroimage.reviews")
		driver.findElement(selloc.selLocators(locatorprop, "loc.heroimage.reviews")).click();
		
		String actual3= driver.findElement(selloc.selLocators(locatorprop,"loc.page.customerreview")).getText();
		
		String text3 ="Average Customer Review:";
		
		
		
		if(!actual3.contains(text3)) {
			log.info("Not in the customer review page");
		}
		SortingVerification sort = new SortingVerification();
		sort.sortingVerify();
		SortingDateVerify sort1 = new SortingDateVerify();
		sort1.sortingDate2();
		sort1.sortingDate();
		
	
		
		
		
		
	}
	
}
