package swaglabs.pages;

import org.openqa.selenium.*;


import swaglabs.utility.BrowserDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CartPage {
    public static String continue_shopping_xpath = "//*[@id=\"continue-shopping\"]";
    public static String checkout_xpath = "//*[@id=\"checkout\"]";

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

    public static void cartListTotal(int total){
        List<WebElement> elements = BrowserDriver.driver.findElements(By.className("cart_item_label"));
        int count = elements.size();

        System.out.println(count);

        assertEquals(total, count);
    }

    public static void click_continue_shopping(){
        BrowserDriver.driver.findElement(By.xpath(continue_shopping_xpath)).click();
        System.out.println("Continue Shopping clicked");
    }

    public static void click_checkout_shopping(){
        BrowserDriver.driver.findElement(By.xpath(checkout_xpath)).click();
        System.out.println("Checkout clicked");
    }
}
