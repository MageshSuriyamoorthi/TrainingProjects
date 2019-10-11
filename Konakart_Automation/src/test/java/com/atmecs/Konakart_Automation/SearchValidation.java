package com.atmecs.Konakart_Automation;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.konakart_automation.helpers.SearchProductsHelper;
import com.atmecs.konakart_automation.helpers.SortingDateVerify;
import com.atmecs.konakart_automation.reports.ExtentReport;
import com.atmecs.konakart_automation.reports.LogReport;
import com.atmecs.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.konakart_automation.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.LogStatus;


public class SearchValidation extends BrowserInvoke{
	LogReport log = new LogReport();
	ExtentReport extrep=new ExtentReport();



	@Test
	public void searchValidation() throws IOException, InterruptedException, ParseException {
		extrep.extentreportStart("searchvalidation");

		extrep.printMessage("started extent Report");
		SearchProductsHelper.searchProducts("Games", "The Wheel Of Time");
		String elem=driver.findElement(By.xpath(PropertiesFileReader.getData("loc.games"))).getText();
		if(elem.contains("The Wheel Of Time")) {
			log.info("Games validated");
		}
		//Negative scenario
		SearchProductsHelper.searchProducts("Electronics", "Pendrives");

		Boolean negscen=driver.findElement(By.xpath(PropertiesFileReader.getData("loc.unavlble"))).isDisplayed();

		if(negscen==true) {
			log.info("product unavailability message verified");
		}

		HeroImage  heroimage = new HeroImage();
		heroimage.sortingVerification();


		extrep.logMessage("Search validation ,Sorting of customer reviews completed");
	}	
}
