package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@Firefox"},
                 monochrome=true,
                 features = "src/test/java/feature", 
                 plugin = {"json:target/cucumber.json", "html:target/htmlreport/cucumber-pretty"},
                 glue={"stepdefinition"}
		)

public class FirefoxTest { 
	
}