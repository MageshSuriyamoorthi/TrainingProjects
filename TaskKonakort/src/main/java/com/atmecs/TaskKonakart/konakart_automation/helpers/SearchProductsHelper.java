package com.atmecs.TaskKonakart.konakart_automation.helpers;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.TaskKonakart.konakart.pageactions.PageActions;
import com.atmecs.TaskKonakart.konakart.pageactions.SelectLocators;
import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.reports.LogReport;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.TaskKonakart.konakart_automation.utils.ExcelReader;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;
import com.atmecs.TaskKonakart.konakart_automation.utils.TestDataProvider;

public class SearchProductsHelper extends BrowserInvoke{

LogReport log =new LogReport();
static final String locatorprop=FilePath.LOCATORS_FILE;

	@Test(dataProvider="konakart",dataProviderClass=TestDataProvider.class)
	public static  void searchProducts(String searchinput,String specificsearch) throws IOException {
		SelectLocators selloc = new SelectLocators();
	
		PageActions pageactions = new PageActions();
		
		pageactions.dropdown(locatorprop,"loc.search.dropdown", searchinput);
		
		
		WebElement searchbox=driver.findElement(selloc.selLocators(locatorprop,"loc.search.searchbox"));
		searchbox.sendKeys(specificsearch);

		pageactions.click(locatorprop,"loc.search.btn");
		 	
	}
}



