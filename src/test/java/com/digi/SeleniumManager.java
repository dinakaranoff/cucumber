package com.digi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cons.Constants;

public class SeleniumManager {

	public  static WebDriver driver=null;
	private static PropertyReader  propertyReader;
	private static LoggerManager logger;
	public  static SeleniumManager seleniumManager=null;
	
	private SeleniumManager(){
		logger=LoggerManager.getLogger();			
	}
	
	private static void createWebdriver()  {
		String browser=null;
		try {
			propertyReader=PropertyReader.getPropertyReader();
			browser=propertyReader.getbrowser();
			logger.info("browser is :");
		} catch (Exception e) {
			logger.error("browser is Empty", e);
		}
		switch(browser){
		case Constants.FF:
			driver=new FirefoxDriver();
			break;
		case Constants.CHROME:
			driver=new ChromeDriver();
			break;
		case Constants.IE:
			driver=new InternetExplorerDriver();
			break;
		}
		logger.info("Webdriver is initiated");

	}

	
	public static SeleniumManager getSeleniumManager() {
		if(seleniumManager==null){
			seleniumManager=new SeleniumManager();
			createWebdriver();
		}
		return seleniumManager;
		
	}

	public  WebDriver getdriver() {
		return driver;	
	}

	
	public void close() {
		driver.close();		
	}

	public void type(String webElement, String userName,String message) {
		driver.findElement(By.id(webElement)).clear();
		driver.findElement(By.id(webElement)).sendKeys(userName);
		logger.info(message +" is Entered");
	}
	
	public void click(String webElement,String message ) {
		driver.findElement(By.id(webElement)).click();;
		logger.info(message +" is Clicked");
	}
	
	
	private void findElement(String webElement,String type){
		WebElement element;
		try{
		
		if(type.contains("//")){
			element=driver.findElement(By.xpath(webElement));
		}else if(type.contains("id")){
				element=driver.findElement(By.id(webElement));
			}else if(type.contains("name")){
				element=driver.findElement(By.name(webElement));				
			}
		}catch(Exception exception){
			logger.error("Element Not found",exception);
		}
		
	}


	
}

