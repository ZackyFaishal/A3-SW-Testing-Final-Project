package swaglabs.pages;

import org.openqa.selenium.*;

import swaglabs.utility.BrowserDriver;



public class CheckoutStepOne {
    
    WebDriver driver;

    public static String first_name_xpath = "//*[@id=\"first-name\"]";
    public static String last_name_xpath = "//*[@id=\"last-name\"]";
    public static String postal_code_xpath = "//*[@id=\"postal-code\"]";
    public static String continue_button_xpath = "//*[@id=\"continue\"]";

    public void CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void sendkeys_first_name(String first_name)
    {
        BrowserDriver.driver.findElement(By.xpath(first_name_xpath)).sendKeys(first_name);
    }

    public static void sendkeys_last_name(String last_name)
    {
        BrowserDriver.driver.findElement(By.xpath(last_name_xpath)).sendKeys(last_name);
    }

    public static void sendkeys_postal_code(String postal_code)
    {
        BrowserDriver.driver.findElement(By.xpath(postal_code_xpath)).sendKeys(postal_code);
    }

    public static void click_continue_button()
    {
        BrowserDriver.driver.findElement(By.xpath(continue_button_xpath)).click();
        System.out.println("Continue button clicked");
    }
}
