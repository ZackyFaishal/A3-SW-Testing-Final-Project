package apiusercontroller.runner;

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
        features = "src/test/java/apiusercontroller/features",
        glue = "apiusercontroller/StepDefinitions",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class GetRunner {
        @AfterClass
        public static void openHtmlReport() {
            try {
                Desktop.getDesktop().browse(new File("target/test-report.html").toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}