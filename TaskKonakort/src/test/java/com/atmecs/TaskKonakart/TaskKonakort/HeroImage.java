package com.atmecs.TaskKonakart.TaskKonakort;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.TaskKonakart.konakart.pageactions.SelectLocators;
import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.reports.ExtentReport;
import com.atmecs.TaskKonakart.konakart_automation.reports.LogReport;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class HeroImage extends BrowserInvoke {
LogReport log = new LogReport();
	public void HeroImage() throws IOException, InterruptedException, ParseException {
		SelectLocators selloc = new SelectLocators();
		WebElement elem1 = driver.findElement(selloc.selLocators(FilePath.LOCATORS_FILE, "loc.heroimage.location"));
        log.info("Element is present");
		String element1 = elem1.getAttribute("srcset");

		if (element1.contains("https://www.konakart.com/konakart/images/content/home_delonghi.png")) {
			HeroImageCoffee herocoffee = new HeroImageCoffee();
			herocoffee.heroImage();

		}

		else {
			HeroImageScenario heroscenario = new HeroImageScenario();
			heroscenario.HeroImageValidation();
		}

	}

}
