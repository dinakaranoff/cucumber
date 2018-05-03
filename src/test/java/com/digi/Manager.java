package com.digi;
import org.openqa.selenium.WebDriver;

public class Manager {
	private  static WebDriver driver=null;
	private static PropertyReader  propertyReader;
	private static SeleniumManager seleniumManager;
	private String browser;
	private static LoggerManager logger;
	private  String currentClassName=this.getClass().getName();

	
	public Manager(){
		initialize();
	}

	public void initialize(){
				try {
					initProperty();
					initLogger();
					initWebdriver();					
					} catch (Exception e) {
				logger.error(currentClassName, "Unable to read property File", e);
				}
	}

	private  void initLogger(){
		try{
			logger=LoggerManager.getLogger();
		}catch (Exception e) {
			logger.error(currentClassName, "Unable to read property File", e);
		}

	}

	private  void initProperty(){
		try {
			System.out.println("initiproperty");
			propertyReader=PropertyReader.getPropertyReader();
		}catch (Exception e) {
			logger.error(currentClassName, "Unable to read property File", e);
		}
	}

	private  void initWebdriver(){
		try {
			seleniumManager=SeleniumManager.getSeleniumManager();
			driver=seleniumManager.getdriver();
		}catch (Exception e) {
			logger.error(currentClassName, "Unable to read property File", e);
		}
	}
	
	public  WebDriver getDriver(){
		return driver;
	}

	public  SeleniumManager getSeleniumManager(){
		return seleniumManager;
	}

	public  PropertyReader getPropertyReader(){
		return propertyReader;
	}

		

	public void cleanup(){
		logger.info("killing driver");
		driver.close();
		logger.cleanup();		
	}
	

}
