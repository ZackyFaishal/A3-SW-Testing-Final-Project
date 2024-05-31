package swaglabs.StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;

import swaglabs.pages.LoginPage;
import swaglabs.utility.BrowserDriver;

import static org.junit.Assert.assertEquals;
import static swaglabs.pages.LoginPage.*;
import static swaglabs.utility.BrowserDriver.driver;


public class LoginSteps {
    LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_login_page() {
        BrowserDriver.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(BrowserDriver.driver);
        System.out.println("I am on the login page");
    }

    @When("I entered my username {string} and password {string}")
    public static void i_entered_my_username_and_password(String username, String password) {
        sendkeys_username(username);
        sendkeys_password(password);
    }

    @And("I clicked on the login button")
    public static void i_clicked_login_button() {
        click_login_button();
    }

    @Then("I should be logged in successfully and redirected to the home page and should be able to view catalog of products")
    public void i_should_be_logged_in_successfully_and_redirected_to_the_home_page_and_should_be_able_to_view_catalog_of_products() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
    }

    @Then("I should see the error message {string}")
    public void Result(String errorMessage) {
        String actualErrorMessage = loginPage.validateError();
        //String actualErrorMessage = driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        System.out.println("Expected error message: " + errorMessage);
        System.out.println("Actual error message: " + actualErrorMessage);
        assertEquals(errorMessage, actualErrorMessage);
    }

    @When("I leave the username and password field empty")
    public void I_leave_the_username_and_password_field_empty() {
        sendkeys_username("");
        sendkeys_password("");
    }
}
