package com.atmecs.konakart_automation.testbase;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import com.atmecs.konakart_automation.constants.FilePath;
import com.atmecs.konakart_automation.reports.ExtentReport;
import com.atmecs.konakart_automation.reports.LogReport;
import com.atmecs.konakart_automation.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.ExtentReports;

public class BrowserInvoke extends ExtentReport{

				LogReport log = new LogReport();
				Properties properties;
				String url;
				String browser;
				
		@BeforeMethod
		public void initializeBrowser() throws Exception {
			extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
			extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
					properties = PropertiesFileReader.loadProperty(FilePath.CONFIG_FILE);

					url = properties.getProperty("url");
					browser = properties.getProperty("browser");
					
					if (browser.equalsIgnoreCase("chrome")) {
						System.setProperty("webdriver.chrome.driver",FilePath.CHROME_FILE);
						driver = new ChromeDriver();
						log.info("Chrome browser opens");
					} 
					else if (browser.equalsIgnoreCase("firefox")) {
						System.setProperty("webdriver.gecko.driver",FilePath.FIREFOX_FILE);
						driver = new FirefoxDriver();
						log.info("Firefox browser opens");
					}
					else if (browser.equalsIgnoreCase("IE")) {
						System.setProperty("webdriver.ie.driver",FilePath.IE_FILE);
						DesiredCapabilities capabilities =new DesiredCapabilities();
						capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
						capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
						//capabilities.setCapability("requireWindowFocus", true);
						driver = new InternetExplorerDriver(capabilities);
						log.info("IE browser opens");
					}

				
					driver.get(url);
					log.info("Application is open");
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
				}
			}



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		



