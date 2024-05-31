package swaglabs.pages;

import org.openqa.selenium.*;

import swaglabs.utility.BrowserDriver;

public class DashboardPage {

    public static String hamburger_menu_xpath = "//*[@id=\"react-burger-menu-btn\"]";

    public static String logout_xpath = "//*[@id=\"logout_sidebar_link\"]";

    public static String product_xpath = "//*[@id=\"inventory_container\"]";
    private final WebDriver driver;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public static void click_hamburger_menu() throws InterruptedException{
        Thread.sleep(2000);
        BrowserDriver.driver.findElement(By.xpath(hamburger_menu_xpath)).click();
        System.out.println("Hamburger menu clicked");
    }

    public static void click_logout() throws InterruptedException{
        Thread.sleep(2000);
        BrowserDriver.driver.findElement(By.xpath(logout_xpath)).click();
        System.out.println("Logout clicked");
    }

    public static String visiblity_product(){
        String catalog_product = BrowserDriver.driver.findElement(By.xpath(product_xpath)).getText();
        return catalog_product;
    }

    public static void click_add_to_cart_onesie(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
        System.out.println("Add to cart button clicked");
    }

    public static void click_add_to_cart_bike_light(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        System.out.println("Add to cart button clicked");
    }

    
    public static void click_add_to_cart_bolt_t_shirt(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
        System.out.println("Add to cart button clicked");
    }

    public static void click_add_to_cart_fleece_jacket(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        System.out.println("Add to cart button clicked");
    }

    public static void click_add_to_cart_red_t_shirt(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
        System.out.println("Add to cart button clicked");
    }

    public static void click_remove_from_cart_backpack(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
        System.out.println("Remove from cart button clicked");
    }

    public static void click_remove_from_cart_onesie(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-onesie\"]")).click();
        System.out.println("Remove from cart button clicked");
    }

    public static void click_remove_from_cart_bike_light(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
        System.out.println("Remove from cart button clicked");
    }

    public static void click_remove_from_cart_bolt_t_shirt(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]")).click();
        System.out.println("Remove from cart button clicked");
    }

    public static void click_remove_from_cart_fleece_jacket(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-fleece-jacket\"]")).click();
        System.out.println("Remove from cart button clicked");
    }

    public static void click_remove_from_cart_red_t_shirt(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"remove-test.allthethings()-t-shirt-(red)\"]")).click();
        System.out.println("Remove from cart button clicked");
    }

    public static void click_shopping_cart(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        System.out.println("Shopping cart clicked");
    }

    public static void check_cart_container(){
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
        System.out.println("Check Cart container");
    }

}
