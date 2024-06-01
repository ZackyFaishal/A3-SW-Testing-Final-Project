package swaglabs.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {

    public static WebDriver driver;

    public ChromeOptions options;

    public BrowserDriver() {
        System.setProperty("webdriver.chrome.driver",
                "E:/Kuliah/SEMESTER 6/Pengujian Perangkat Lunak/Praktek/Tubes/A3-SW-Testing-Final-Project/src/test/resources/drivers/chromedriver.exe");

        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-web-security");

        driver = new ChromeDriver(options);

    }

    public void close() {
        if (this.driver != null) {
            this.driver.close();
            this.driver = null;
        }
    }
}
