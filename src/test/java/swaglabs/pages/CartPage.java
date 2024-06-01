package swaglabs.pages;

import org.openqa.selenium.*;

import swaglabs.utility.BrowserDriver;


public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public static String cartList(){
        String cartList = BrowserDriver.driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]")).getText();
        return cartList;
    }

    public static void click_checkout(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }
}
