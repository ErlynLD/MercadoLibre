package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src\\test\\resources\\features"},
        glue = {"step_definitions", "hooks"},
        plugin = { "pretty" }
)
public class ResultsRunner extends AbstractTestNGCucumberTests {
}
