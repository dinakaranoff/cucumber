package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = {"features/dataTable.feature","features/MyApplication.feature"},
							glue={"steps"},
							monochrome=true,
							format={"junit:results/cucumber.xml"}							 
)

public class TestRunner {

}
