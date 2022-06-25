package com.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber.report.html",
                //"json:target/cucumberReports/cucumber.report.json",
                "rerun:target/cucumber.txt"
        },
        features = "src/test/resources/features",
        glue = "com/library/stepDefinitions",
        dryRun = false,
        tags = "@Excel"

)

public class TestRunner {
}
