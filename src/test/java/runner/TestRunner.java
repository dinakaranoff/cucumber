package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features/TagExample.feature"},
							glue={"steps"},
							monochrome=true,
							format={"junit:results/cucumber.xml"},
							tags={"@SanityTest, @RegressionTest"},
							plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
													"junit:target/cucumber-reports/Cucumber.xml",
														"html:target/cucumber-reports"}
)

public class TestRunner {
}

