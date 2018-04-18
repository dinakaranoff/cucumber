package com.digi;

import org.openqa.selenium.WebDriver;

public class TestContext {
	private PropertyReader  propertyReader;
	private SeleniumManager  seleniumManager;
	private LoggerManager logger;
	private WebDriver driver;

	public TestContext(){
		seleniumManager = SeleniumManager.getSeleniumManager();
		propertyReader=PropertyReader .getPropertyReader();
		driver=seleniumManager.getdriver();
		logger=LoggerManager.getLogger();
	}
	
	public WebDriver getDriver() {
		return  driver;
	}
	
	public LoggerManager getLogger() {
		return  logger;
	}
	
	public PropertyReader getpropertyReader() {
		return propertyReader;
	}
	
	public SeleniumManager getSeleniumManager() {
		return seleniumManager;
	}
}