package steps;

import org.openqa.selenium.WebDriver;

import com.digi.PropertyReader;
import com.digi.SeleniumManager;
//import com.digi.TestContext;
import com.digi.Manager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook  {

	
	private static WebDriver driver;
	public  PropertyReader propertyReader;
//////	public TestContext txt;
	public SeleniumManager seleniumManager;
	
	@Before
	public void setUp(){
		try{
			propertyReader=PropertyReader.getPropertyReader();
			seleniumManager=SeleniumManager.getSeleniumManager();
			driver=SeleniumManager.getdriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@After
	public void cleanUp(){
		driver.close();
		//	driver.quit();
	}	

}
