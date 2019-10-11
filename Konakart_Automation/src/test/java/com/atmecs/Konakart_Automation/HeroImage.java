package com.atmecs.Konakart_Automation;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.konakart_automation.reports.ExtentReport;
import com.atmecs.konakart_automation.reports.LogReport;
import com.atmecs.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.konakart_automation.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class HeroImage extends BrowserInvoke {


	public void sortingVerification() throws IOException, InterruptedException, ParseException {

		driver.findElement(By.xpath(PropertiesFileReader.getData("loc.homebc"))).click();

		WebElement elem1=driver.findElement(By.xpath("//picture[@class='slide rounded-corners']/descendant::img"));


		String element1=	elem1.getAttribute("srcset");

		if(element1.contains("https://www.konakart.com/konakart/images/content/home_delonghi.png")) {
			HeroImageCoffee herocoffee= new HeroImageCoffee();
			herocoffee.heroImageCoffee();

		}

		else
		{
			HeroImageScenario heroscenario =new HeroImageScenario();
			heroscenario.HeroImageValidation();
		}
		driver.close();
	}

}




