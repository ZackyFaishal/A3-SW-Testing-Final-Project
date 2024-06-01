package swaglabs.pages;

import org.openqa.selenium.*;

import swaglabs.utility.BrowserDriver;


public class CheckoutStepTwo {

    WebDriver driver;

    public void CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public static String checkout_summary_container(){
        String checkout_summary_container = BrowserDriver.driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]")).getText();
        return checkout_summary_container;
    }

    public static void click_finish(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }

}
