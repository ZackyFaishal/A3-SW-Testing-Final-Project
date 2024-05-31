package swaglabs.pages;

import static swaglabs.utility.BrowserDriver.driver;

import org.openqa.selenium.*;

import swaglabs.utility.BrowserDriver;

public class LoginPage {
    WebDriver driver;
    public static String username_xpath = "//*[@id=\"user-name\"]";

    public static String password_xpath = "//*[@id=\"password\"]";

    public static String login_button_xpath = "//*[@id=\"login-button\"]";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void sendkeys_username(String username)
    {
        BrowserDriver.driver.findElement(By.xpath(username_xpath)).sendKeys(username);
    }

    public static void sendkeys_password(String password)
    {
        BrowserDriver.driver.findElement(By.xpath(password_xpath)).sendKeys(password);
    }

    public static void click_login_button()
    {
        BrowserDriver.driver.findElement(By.xpath(login_button_xpath)).click();
        System.out.println("Login button clicked");
    }

    public String validateError(){
        String actualErrorMessage = driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        return actualErrorMessage;
    }
}
