package steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.digi.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test {
	    private static WebDriver driver;
		private TestContext context=new TestContext();
		
	@Given("^Open TCC LoginPage$")
	public void open_TCC_LoginPage() throws Throwable {
		driver=context.getDriver();
		driver.get(context.getpropertyReader().getURL());
		}
	
	@Given("^Open LoginPage$")
	public void open_LoginPage() throws Throwable {
		 driver=context.getDriver();
		driver.get(context.getpropertyReader().getURL());
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
	}

	@When("^Logout happens$")
	public void logout_happens() throws Throwable {
		driver.findElement(By.xpath("//div[@id='top_nav_console']/div[5]/a")).click();
	}

	@Then("^Come back to LoginPage$")
	public void come_back_to_LoginPage() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("txtboxUserName")).isDisplayed());
	}
	
	@Given("^open inconsole search page$")
	public void open_inconsole_search_page() throws Throwable {
	}

	@When("^search Pending Orders$")
	public void search_Pending_Orders() throws Throwable {
	}

	@Then("^Verify some order are found$")
	public void verify_some_order_are_found() throws Throwable {
	}

	@When("^search Valid orders$")
	public void search_Valid_orders() throws Throwable {
		
	}
		
}
