package steps;

import java.util.List;
import java.util.Map;

//import mx4j.log.Logger;




import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.Arrays;
import org.openqa.selenium.remote.CapabilityType;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


//import com.digicert.PropertyReader;
//i//mport com.digicert.SeleniumManager;
//import com.digi.TestContext;
//import com.digi.Manager;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test {

	//TestContext txt;
	
	    private static WebDriver driver;
	    DesiredCapabilities dCaps;

	//	public  PropertyReader propertyReader;
	//	public TestContext txt;
	//	public SeleniumManager seleniumManager;
		
	//	private  Test(){
//			try{
//				propertyReader=PropertyReader.getPropertyReader();
//				seleniumManager=SeleniumManager.getSeleniumManager();	
//			    driver=SeleniumManager.getdriver();
//			    driver.get(propertyReader.getURL());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
	//	}	
	
	@Given("^Open TCC LoginPage$")
	public void open_TCC_LoginPage() throws Throwable {


				System.setProperty("webdriver.chrome.driver", "C:/Users/dinakaran_palaniswam/Desktop/Softwares/chromedriver.exe");
				dCaps = DesiredCapabilities.chrome();
				//Enable plug-in like java required by some applications like SSLTOOLS
				dCaps.setCapability("chrome.switches", Arrays.asList("--always-authorize-plugins"));
				//Bypass the SSL error 
				dCaps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//	driver = new ChromeDriver(dCaps);
			
			
		//System.setProperty("webdriver.ie.driver", "C:/Users/dinakaran_palaniswam/Desktop/Softwares/IEDriverServer-w32.exe");
		//dCaps = DesiredCapabilities.internetExplorer();
		//dCaps.setCapability("ignoreZoomSetting", true);
		//dCaps.setCapability("ignoreProtectedModeSettings", true);
		//driver = new InternetExplorerDriver(dCaps);

	driver=new InternetExplorerDriver("webdriver.ie.driver","C:/Program Files (x86)/Internet Explorer/iexplore.exe");	
	driver.get("https://ssl-certificate-center5.thawte.symclab.net/process/trust/console_login?application_locale=THAWTE_US");
		Thread.sleep(5000);
		System.out.println("HHHHHHHHHHHHHHHHHHHH");
		driver.findElement(By.id("txtboxUserName")).sendKeys("oemtcc@wssqa.net");
		driver.findElement(By.id("txtboxPassword")).sendKeys("P@ssword1");
		driver.findElement(By.id("continueButton")).click();


		Thread.sleep(5000);
driver.close();
System.out.println("HHHHHHHHHHHHHHHHHHHH");
	
	}
	
	@Given("^Open LoginPage$")
	public void open_LoginPage() throws Throwable {
		//driver=new FirefoxDriver();
		//driver.get(facebookURI);
	}

	@When("^Enter credentials$")
	public void enter_credentials() throws Throwable {
		driver.findElement(By.id("txtboxUserName")).sendKeys("oemtcc@wssqa.net");
		driver.findElement(By.id("txtboxPassword")).sendKeys("P@ssword1");
		driver.findElement(By.id("continueButton")).click();
	}

	@Then("^Validate HomePage$")
	public void validate_HomePage() throws Throwable {
		String expected=driver.findElement(By.xpath("//div[@id='top_nav_console']/div[5]/a")).getText();
		System.out.println("Expected Value"+expected);
		Assert.assertEquals("Sign Out", expected);
	}
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
	}
	
	@When("^Enter Credentials from datatable$")
	public void enter_Credentials_from_datatable(DataTable table) throws Throwable {
	  List<List<String>> data=table.raw();
		driver.findElement(By.id("txtboxUserName")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("txtboxPassword")).sendKeys(data.get(0).get(1));
		driver.findElement(By.id("continueButton")).click();
	}
	
	@When("^Enter Credentials with header using Maps$")
	public void enter_Credentials_with_header_using_maps(DataTable table) throws Throwable {
		for (Map<String, String> datas : table.asMaps(String.class, String.class)) {
			driver.findElement(By.id("txtboxUserName")).sendKeys(datas.get("userName"));
			driver.findElement(By.id("txtboxPassword")).sendKeys(datas.get("password"));
			driver.findElement(By.id("continueButton")).click();
			
		}
		

	}
		
	@When("^Enter userName \"([^\"]*)\"  password \"([^\"]*)\"$")
	public void enter_userName_password(String userName, String password) throws Throwable {
		driver.findElement(By.id("txtboxUserName")).sendKeys(userName);
		driver.findElement(By.id("txtboxPassword")).sendKeys(password);
		driver.findElement(By.id("continueButton")).click();
		System.out.println("Expected Value");
	}

	@When("^Logout happens$")
	public void logout_happens() throws Throwable {
		driver.findElement(By.xpath("//div[@id='top_nav_console']/div[5]/a")).click();
	}

	@Then("^Come back to LoginPage$")
	public void come_back_to_LoginPage() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("txtboxUserName")).isDisplayed());
	}
		
}
