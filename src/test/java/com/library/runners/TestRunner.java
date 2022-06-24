package com.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumberReports/cucumber.report.html",
                //"json:target/cucumberReports/cucumber.report.json",
                "rerun:target/cucumberReports/cucumber.txt"
        },
        features = "src/test/resources/features",
        glue = "com/library/stepDefinitions",
        dryRun = false,
        tags = "@smoke"

)

public class TestRunner {
}
