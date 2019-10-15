package com.atmecs.TaskKonakart.konakart_automation.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.atmecs.TaskKonakart.konakart_automation.constants.FilePath;
import com.atmecs.TaskKonakart.konakart_automation.reports.ExtentReport;
import com.atmecs.TaskKonakart.konakart_automation.reports.LogReport;
import com.atmecs.TaskKonakart.konakart_automation.utils.PropertiesFileReader;

public class BrowserInvoke extends ExtentReport {

	LogReport log = new LogReport();
	Properties properties;
	String url;
	String browser;

	@BeforeMethod
	public void initializeBrowser() throws Exception {
url="https://www.konakart.com/konakart/Welcome.action";
		//url = PropertiesFileReader.getData(FilePath.CONFIG_FILE, "config.url");
		browser = PropertiesFileReader.getData(FilePath.CONFIG_FILE, "browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", FilePath.CHROME_FILE);
			driver = new ChromeDriver();
			log.info("Chrome browser opens");
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_FILE);
			driver = new FirefoxDriver();
			log.info("Firefox browser opens");
		}

		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", FilePath.IE_FILE);
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
			driver = new InternetExplorerDriver(capabilities);
			capabilities.setCapability("requireWindowFocus", true);
			log.info("IE browser opens");
		}

		driver.get(url);
		log.info("Application is open");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void browserClose() {
		driver.close();
	}
}
