package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;

import com.digi.PropertyReader;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = {"features/dataTable.feature"},
							glue={"steps"},
							monochrome=true,
							format={"junit:results/cucumber.xml"},
							tags={"@SanityTest, @RegressionTest"},
//							plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
//													"junit:target/cucumber-reports/Cucumber.xml",
//														"html:target/cucumber-reports"},
							plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
//							plugin = { "pretty" },
//									plugin = { "usage"},
//									plugin={"pretty","junit:results/cucumber.xml"},
//									plugin={"pretty","json:results/cucumber.json"},
//							plugin={"pretty","html:target/cucumber-reports"}
		
)

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
	//	Reporter.loadXMLConfig(new File(PropertyReader.getPropertyReader().getReportConfigPath()));
	}
}
