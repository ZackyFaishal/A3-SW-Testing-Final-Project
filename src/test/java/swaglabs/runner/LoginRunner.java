package swaglabs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish=true,
        features = "src/test/java/features/Login",
        glue = {"StepDefinitions","utility"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class LoginRunner {
    @AfterClass
    public static void openHtmlReport() {
        try {
            Desktop.getDesktop().browse(new File("target/test-report.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}