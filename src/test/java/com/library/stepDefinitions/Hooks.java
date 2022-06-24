package com.library.stepDefinitions;

import com.library.utilities.BrowserUtils;
import com.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @AfterStep
    public void esver(){
        BrowserUtils.sleep(1);
    }

    @After
    public void tearDwn(Scenario scenario){

        if (scenario.isFailed()){
            byte[] snap = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(snap,"image/png", scenario.getName());

        }

       Driver.stopSession();

    }
}
