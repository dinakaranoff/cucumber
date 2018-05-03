package steps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.digi.LoggerManager;
import com.digi.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook  {

	
	private WebDriver driver;
	private TestContext context;
	private LoggerManager logger;
	
	@Before
	public void setUp(){
		try{
			context=new TestContext();
			driver=context.getDriver();
			logger=LoggerManager.getLogger();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	@Before(order=0)
//	public void beforeScenario(Scenario scenario) {
//		Reporter.assignAuthor("ToolsQA - Dina");
//	}
	
	
	@Before("@SanityTest")
	public void beforeSanity(){
		logger.info("This method wil be called only before of sanity Test sceanrios");
		logger.info("Sanity Tests are to begin");
	}
	
	@After("@SanityTest")
	public void afterSanity(){
		logger.info("This method wil be called only after of sanity Test sceanrios");
		logger.info("Sanity Tests are completed");
	}
	
	
	@Before("@RegressionTest")
	public void beforeRegression(){
		logger.info("This method wil be called only before of Regression Test sceanrios");
		logger.info("Regression Tests are to begin");
	}
	
	@After("@RegressionTest")
	public void afterRegression(){
		logger.info("This method wil be called only after of Regression Test sceanrios");
		logger.info("Regression Tests are completed");
	}
	

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot) context.getSeleniumManager().getdriver()).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				Files.copy(sourcePath.toPath(), destinationPath.toPath());
			  //	Files.copy(sourcePath, destinationPath);   
			} catch (Exception e) {
			} 
		}
	}


	@After
	public void cleanUp(){
    	driver=context.getDriver();
		driver.close();
	}
	
	
//	@After(order=0)
//	public void cleanUp(){
//    	driver=context.getDriver();
//		driver.close();
//	}

}
