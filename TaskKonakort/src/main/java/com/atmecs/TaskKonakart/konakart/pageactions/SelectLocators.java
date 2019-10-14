package com.atmecs.TaskKonakart.konakart.pageactions;

import java.io.IOException;

import org.openqa.selenium.By;

import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;

public class SelectLocators extends BrowserInvoke {

	
	
	public By selLocators(String path,String locators) throws IOException  {
		

		
				
				
//				String []locatorarr;
//				locatorarr=locators.split(",");
			    String loctyp="CSS";
//			    System.out.println(locatorarr[0]+locatorarr.length);
				By loc = null ;
				 switch (loctyp) {
				 
			        case "XPATH": 
			             loc=By.xpath(PropertiesFileReader.getData(path,locators));
			             return loc;
			            
			        case "CSS":
			            loc=By.cssSelector(PropertiesFileReader.getData(path,locators));
			            return loc;
			            
			        case "ID": 
			             loc=By.id(PropertiesFileReader.getData(path ,locators));
			             return loc;
			          
			        case "NAME": 
			            loc=By.name(PropertiesFileReader.getData(path ,locators));
			            return loc;
			        case "TAGNAME": 
			             loc=By.id(PropertiesFileReader.getData(path ,locators));
			             return loc;
			          
			        case "LINKTEXT": 
			            loc=By.linkText(PropertiesFileReader.getData(path ,locators));
			            return loc;
			           
			        case "PARTIALLINKTEXT": 
			            loc=By.partialLinkText(PropertiesFileReader.getData(path,locators));
			            return loc;
	}
				return loc;
				
}
	
}