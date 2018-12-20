package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/stepdefs",
        glue = "stepdefs"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
