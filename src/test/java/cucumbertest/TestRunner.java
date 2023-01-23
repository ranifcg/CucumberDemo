package cucumbertest;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
		(
		features = "Features",
		glue = {"stepDefinition"},
		//tags = "@tag"

		//tags = "(@SmokeTest or @RegressionTest) and (not @E2ETest)"
		tags = "@completeprogram"
		//tags = "@SmokeTest or @RegressionTest"
		//tags = "@SmokeTest and @RegressionTest"

		)
public class TestRunner {

}
