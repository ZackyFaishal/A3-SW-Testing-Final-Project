package swaglabs.utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;


public class Hooks {

    public static BrowserDriver driver;

    public static ChromeOptions options;

    @Before
    public void setup(){
        driver = new BrowserDriver();
    }

    @After()
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

}