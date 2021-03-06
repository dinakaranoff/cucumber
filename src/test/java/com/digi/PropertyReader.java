package com.digi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.digi.LoggerManager;

public class PropertyReader {
	
	private static  Properties properties;
	private final String path="properties\\Config.properties";
	//private final String reportConfigPath="configs\\extent-config.xml";
	private static PropertyReader propertyReader=null;
	private static LoggerManager logger;
	private String currentClasssName=this.getClass().getName();
	
	private PropertyReader(){
		BufferedReader bufferReader;
		try {
			logger=LoggerManager.getLogger();			
			bufferReader=new BufferedReader(new FileReader(path));
			properties=new Properties();
			properties.load(bufferReader);
			bufferReader.close();
			logger.info(currentClasssName, "Property File is loaded from "+path);
		}	
		catch (IOException e) {
			logger.error(this.getClass().getName(),"Unable to property File from "+path,e);	
			}
	}

	
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	public static PropertyReader getPropertyReader(){
		if(propertyReader==null){
			propertyReader=new PropertyReader();
		}
		return propertyReader;
}
	
	public  String getbrowser() throws Exception{
		String browser=properties.getProperty("browser");
		if(browser==null){
			throw new Exception("browser is null");
		}
		logger.info(currentClasssName, "Browser from property file :"+browser);
		return browser;
	}
	
	public  String getImplicitlyWait(){
		String wait= properties.getProperty("implicitlyWait");
		logger.info(currentClasssName, "implicitlyWait from property file :"+wait);
		return wait;
	}
	
	public  String getURL() throws Exception{
		String url=properties.getProperty("url");
		if(url==null){
			throw new Exception("URL is null");
		}
		logger.info(currentClasssName, "URL from property file :"+url);

		return url;
	}
}
