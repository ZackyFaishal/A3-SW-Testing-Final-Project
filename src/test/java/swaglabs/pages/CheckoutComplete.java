package swaglabs.pages;

import org.openqa.selenium.*;

import swaglabs.utility.BrowserDriver;


public class CheckoutComplete {

    WebDriver driver;

    public void CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    

    //*[@id="checkout_complete_container"]/h2

    // public static String checkout_complete_container(){
    //     String checkout_complete_container = BrowserDriver.driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
    //     return checkout_complete_container;
    // }

    public static void click_back_to_products(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }
}
