package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swaglabs.utility.BrowserDriver;

import static org.junit.Assert.assertEquals;

public class CheckoutPage {
    public static String firstname_xpath = "//*[@id=\"first-name\"]";
    public static String lastname_xpath = "//*[@id=\"last-name\"]";
    public static String postalcode_xpath = "//*[@id=\"postal-code\"]";

    public static String continue_xpath = "//*[@id=\"continue\"]";
    public static String cancel_xpath = "//*[@id=\"cancel\"]";

    public static String error_xpath = "//*[@data-test=\"error\"]";

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void sendkeys_firstName(String firstname)
    {
        BrowserDriver.driver.findElement(By.xpath(firstname_xpath)).sendKeys(firstname);
    }
    public static void sendkeys_lastName(String lastname)
    {
        BrowserDriver.driver.findElement(By.xpath(lastname_xpath)).sendKeys(lastname);
    }
    public static void sendkeys_postalcode(String postalcode)
    {
        BrowserDriver.driver.findElement(By.xpath(postalcode_xpath)).sendKeys(postalcode);
    }

    public static void click_continue(){
        BrowserDriver.driver.findElement(By.xpath(continue_xpath)).click();
        System.out.println("Continue button clicked");
    }

    public static void click_cancel(){
        BrowserDriver.driver.findElement(By.xpath(cancel_xpath)).click();
        System.out.println("Cancel button clicked");
    }

    public static void get_error_message(String message){
        String actualMessage = BrowserDriver.driver.findElement(By.xpath(error_xpath)).getText();
        assertEquals(message, actualMessage);
    }


    //CHECKOUT STEP TWO
    public static String checkout_summary_container(){
        String checkout_summary_container = BrowserDriver.driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]")).getText();
        return checkout_summary_container;
    }

    public static void click_finish(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }

    //CHECKOUT COMPLETE
    public void CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void click_back_to_products(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }

}
