package com.atmecs.TaskKonakart.konakart_automation.helpers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.TaskKonakart.konakart.pageactions.PageActions;
import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.reports.LogReport;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;

public class SortingDateVerify extends BrowserInvoke{
	LogReport log = new LogReport();

public void sortingDate() throws IOException, InterruptedException, ParseException {

		PageActions pageaction = new PageActions();
		pageaction.dropdown(FilePath.LOCATORS_FILE,"loc.review.dropdown", "Oldest first");
		Thread.sleep(3000);
	                   
		int size = 4;
		int i=0;
	
		String datearr1[] = new String [size];
		WebElement element;
	
		
		for (i = 1; i <size; i++) {

			String text1 = PropertiesFileReader.getData(FilePath.LOCATORS_FILE,"loc.datetext");
			String text2 = Integer.toString(i);
			String text3 = ") span[class='product-review-details-date']";
			element = driver.findElement(By.cssSelector(text1 + text2 + text3));

			String elemtext = element.getText();
			
			String words[];
			words=elemtext.split("\\s");
	
			Date date1;
			SimpleDateFormat input = new SimpleDateFormat("dd/MMMM/yyyy");
			SimpleDateFormat output;
			
			//if(wordint<10) {
		
				String elemtext12= words[1]+"/"+words[2]+"/"+words[3];
				System.out.println(elemtext12);
				output= new SimpleDateFormat("yyyy-MM-dd");
				date1 = input.parse(elemtext12);
			//}
			
			
//			 else { String elemtext11= words[1]+" "+words[2]+" "+words[3]; output= new
//			 SimpleDateFormat("yyyy-MM-dd"); date1 = input.parse(elemtext11);
//			 
//			 }
//			 

				//div#product-content div[id='product-reviews-area']>div:nth-of-type(4) span[class='product-review-details-date']
		
            datearr1[i-1]=output.format(date1);
	
			
     }
		
		
		for(int j=0;j<(datearr1.length)-2;j++) {
			  
			  Date date1;
			  Date date2;
		 
			 
			   date1=new SimpleDateFormat("yyyy-MM-dd").parse(datearr1[j]);  
               date2=new SimpleDateFormat("yyyy-MM-dd").parse(datearr1[j+1]);  
               if(date1.before(date2)) {
               log.info("Arranged in oldest fist");
               }
               if(date1.after(date2)) {
            	  log.info("Not in Oldest first");
               }
               

		     
 	}
		
		
}
	
	public void sortingDate2() throws IOException, ParseException, InterruptedException {

		PageActions pageaction = new PageActions();
		pageaction.dropdown(FilePath.LOCATORS_FILE,"loc.review.dropdown", "Most recent first");
		
		Thread.sleep(3000);
	                   
		int size = 4;
		int i;

		String datearr2[] = new String [size];
		WebElement element;
	
	
		
		for (i = 1; i <4; i++) {

			String text1 = PropertiesFileReader.getData(FilePath.LOCATORS_FILE,"loc.datetext");
			String text2 = Integer.toString(i);
			String text3 = ") span[class='product-review-details-date']";
			element = driver.findElement(By.cssSelector(text1 + text2 + text3));

			String elemtext = element.getText();
			
			String[] words=new String [10];
			words=elemtext.split("\\s");
			//int wordint=Integer.parseInt(words[1]);
			Date date1;
			SimpleDateFormat input = new SimpleDateFormat("dd/MMMM/yyyy");
			SimpleDateFormat output =new SimpleDateFormat("yyyy-MM-dd");
			
			String elemtext12= words[1]+"/"+words[2]+"/"+words[3];
	
			date1 = input.parse(elemtext12);
            datearr2[i-1]=output.format(date1);
	
			
     }
		
		
		for(int j=0;j<(datearr2.length)-2;j++) {
			  System.out.println(datearr2.length);
			  Date date1;
			  Date date2;
		
				SimpleDateFormat output =new SimpleDateFormat("yyyy-MM-dd");
			 
			   date1=output.parse(datearr2[j]);  
               date2=output.parse(datearr2[j+1]);  
               if(date2.before(date1)) {
               log.info("Arranged in Most Recent fist");
               }
               if(date2.after(date1)) {
            	  log.info("Not in Most Recent first");
               }
               

		     
 	}
		
		
}
		     
 	
		
		
		
	}
