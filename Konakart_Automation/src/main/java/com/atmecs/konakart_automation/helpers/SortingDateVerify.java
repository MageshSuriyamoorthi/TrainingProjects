package com.atmecs.konakart_automation.helpers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.konakart.pageactions.PageActions;
import com.atmecs.konakart_automation.reports.LogReport;
import com.atmecs.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.konakart_automation.utils.PropertiesFileReader;

public class SortingDateVerify extends BrowserInvoke {
	LogReport log = new LogReport();

	public void sortingDate() throws IOException, InterruptedException, ParseException {
		PageActions pageaction = new PageActions();
		pageaction.dropdown("loc.dropdown", "Oldest first");
		Thread.sleep(3000);

		int size = 4;
		int i = 0;
		int date[] = new int[size];
		int year[] = new int[size];
		int month[] = new int[size];
		String datearr1[] = new String[size];
		WebElement element;
		String sort[] = new String[size];
		String elemtext1;

		for (i = 1; i <= 4; i++) {

			Date datetext;
			String text1 = PropertiesFileReader.getData("loc.datetext");
			String text2 = Integer.toString(i);
			String text3 = "]";
			element = driver.findElement(By.xpath(text1 + text2 + text3));
			SimpleDateFormat input = new SimpleDateFormat("EEEE DD MMMM YYYY");
			SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
			String elemtext = element.getText();
			datetext = input.parse(elemtext);
			String inputarr[] = new String[10];
			datearr1[i - 1] = output.format(datetext);
		}

		for (int j = 0; j < (datearr1.length) - 1; j++) {

			Date date1;
			Date date2;
			SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
			date1 = output.parse(datearr1[j]);
			date2 = output.parse(datearr1[j + 1]);
			if (date1.before(date2)) {
				log.info("Arranged in oldest fist");
			}
			if (date1.after(date2)) {
				log.info("Not in Oldest first");
			}

		}

	}

	public void sortingDate2() throws IOException, ParseException, InterruptedException {

		PageActions pageaction = new PageActions();
		pageaction.dropdown("loc.dropdown", "Most recent first");
		Thread.sleep(3000);
		int size = 4;
		int i = 0;
		int date[] = new int[size];
		int year[] = new int[size];
		int month[] = new int[size];
		String datearr2[] = new String[size];
		WebElement element;
		String sort[] = new String[size];
		String elemtext1;

		for (i = 1; i <= 4; i++) {

			Date datetext;
			String text1 = PropertiesFileReader.getData("loc.datetext");
			String text2 = Integer.toString(i);
			String text3 = "]";
			element = driver.findElement(By.xpath(text1 + text2 + text3));
			SimpleDateFormat input = new SimpleDateFormat("EEEE DD MMMM YYYY");
			SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
			String elemtext = element.getText();

			datetext = input.parse(elemtext);
			String inputarr[] = new String[10];

			datearr2[i - 1] = output.format(datetext);

		}

		for (int j = 0; j < (datearr2.length) - 1; j++) {

			Date date1;
			Date date2;
			SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datearr2[j]);
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse(datearr2[j + 1]);
			if (date2.before(date1)) {
				log.info("Arranged in Most Recent fist");
			}
			if (date2.after(date1)) {
				log.info("Not in Most Recent first");
			}

		}

	}

}
