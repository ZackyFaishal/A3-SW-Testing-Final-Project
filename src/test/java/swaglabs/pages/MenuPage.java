package swaglabs.pages;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import swaglabs.utility.BrowserDriver;
import swaglabs.utility.Hooks;

//assert
import org.junit.Assert;


public class MenuPage {
    //Tree line icon
    public static String hamburger_menu_xpath = "//*[@id=\"react-burger-menu-btn\"]";
    // About
    public static String about_xpath = "//*[@id=\"about_sidebar_link\"]";
    // Logout
    public static String logout_xpath = "//*[@id=\"logout_sidebar_link\"]";
    // All menu items
    public static String all_items_xpath = "//*[@id=\"inventory_sidebar_link\"]";
    // Reset App State
    public static String reset_app_state_xpath = "//*[@id=\"reset_sidebar_link\"]";

    WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void click_hamburger_menu() {
        BrowserDriver.driver.findElement(By.xpath(hamburger_menu_xpath)).click();
        System.out.println("Hamburger menu clicked");
    }

    public static void click_about() {
        BrowserDriver.driver.findElement(By.xpath(about_xpath)).click();
        System.out.println("About clicked");
    }

    public static void click_logout() {
        BrowserDriver.driver.findElement(By.xpath(logout_xpath)).click();
        System.out.println("Logout clicked");
    }

    public static void click_all_items() {
        BrowserDriver.driver.findElement(By.xpath(all_items_xpath)).click();
        System.out.println("All items clicked");
    }

    public static void click_reset_app_state() {
        BrowserDriver.driver.findElement(By.xpath(reset_app_state_xpath)).click();
        System.out.println("Reset app state clicked");
    }

    public static void check_menu() {
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"inventory_sidebar_link\"]"));
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"about_sidebar_link\"]"));
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
        BrowserDriver.driver.findElement(By.xpath("//*[@id=\"reset_sidebar_link\"]"));
    }

    // Check if the user is redirected to the About page
    public static void check_about() {
        //expected url https://saucelabs.com/
        String expected_url = "https://saucelabs.com/";
        //get current url
        String current_url = BrowserDriver.driver.getCurrentUrl();
        //assert
        Assert.assertEquals(expected_url, current_url);
    }

    public static void check_logout() {
        //expected url https://www.saucedemo.com/
        String expected_url = "https://www.saucedemo.com/";
        //get current url
        String current_url = BrowserDriver.driver.getCurrentUrl();
        //assert
        Assert.assertEquals(expected_url, current_url);
    }
}
