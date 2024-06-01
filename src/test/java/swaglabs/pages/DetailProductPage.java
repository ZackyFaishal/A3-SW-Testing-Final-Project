package swaglabs.pages;

import org.openqa.selenium.*;
import swaglabs.utility.BrowserDriver;

public class DetailProductPage {

    public static String back_button_xpath = "//*[@id=\"back-to-products\"]";
    public static String add_to_cart_button_xpath = "//*[@id=\"add-to-cart\"]";
    public static String remove_button_xpath = "//*[@id=\"remove-sauce-labs-backpack\"]";
    public static String cart_icon_xpath = "//*[@id=\"shopping_cart_container\"]/a/span";

    WebDriver driver;

    public DetailProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void click_back_button() {
        BrowserDriver.driver.findElement(By.xpath(back_button_xpath)).click();
        System.out.println("Back button clicked");
    }

    public static void click_add_to_cart_button() {
        BrowserDriver.driver.findElement(By.xpath(add_to_cart_button_xpath)).click();
        System.out.println("Add to cart button clicked");
    }

    public static void click_remove_button() {
        BrowserDriver.driver.findElement(By.xpath(remove_button_xpath)).click();
        System.out.println("Remove button clicked");
    }

    public static void click_cart_icon() {
        BrowserDriver.driver.findElement(By.xpath(cart_icon_xpath)).click();
        System.out.println("Cart icon clicked");
    }

    public static void check_inventory_item_container() {
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]"));
    }

    // click image
    public static void click_title_backpack() {
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
        System.out.println("Title clicked");
    }

    public static void click_title_bike_light() {
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div")).click();
        System.out.println("Title clicked");
    }

    // check image, name, description, and price
    // *[@id="inventory_item_container"]
    public static void check_inventory_item_container_backpack() {
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]"));
    }
}
