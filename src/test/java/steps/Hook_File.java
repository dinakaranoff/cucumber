//package steps;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//
//public class Hook_File {
//
//	WebDriver driver;
//	Logger logger;
//	
//	@Before(order=0)
//	public void setUp(){
//		logger.info("Webdriver  object will be intiated");
//	}
//	
//	@After(order=1)
//	public void cleanUp(){
//		logger.info("Test excution is completed");
//	}	
//	
//	
//	@Before(order=1)
//	public void setUp1(){
//		logger.info("Test excution wil begin shortly");
//	}
//	
//	@After(order=0)
//	public void cleanUp1(){
//		logger.info("Web driver will be killed shortly");
//	}
//	
//	
//	@Before("@SanityTest")
//	public void beforeSanity(){
//		logger.info("This method wil be called only before of sanity Test sceanrios");
//		logger.info("Sanity Tests are to begin");
//	}
//	
//	@After("@SanityTest")
//	public void afterSanity(){
//		logger.info("This method wil be called only after of sanity Test sceanrios");
//		logger.info("Sanity Tests are completed");
//	}
//	
//
//	@Before("@RegressionTest")
//	public void beforeRegression(){
//		logger.info("This method wil be called only before of RegressionTest sceanrios");
//		logger.info("RegressionTest are to begin");
//	}
//	
//	@Before("@RegressionTest")
//	public void afterRegression(){
//		logger.info("This method wil be called only after of RegressionTest sceanrios");
//		logger.info("RegressionTest are completed");
//	}
//	
//}