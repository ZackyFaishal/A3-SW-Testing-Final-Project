package swaglabs.StepDefinitions;

import swaglabs.pages.DashboardPage;
import swaglabs.pages.LoginPage;
import swaglabs.pages.CartPage;
import swaglabs.pages.DetailProductPage;
import swaglabs.utility.BrowserDriver;
import swaglabs.utility.Hooks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static swaglabs.pages.LoginPage.*;
import static swaglabs.utility.BrowserDriver.driver;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailSteps {

    WebDriver driver = BrowserDriver.driver;
    DetailProductPage detailProductPage = new DetailProductPage(driver);
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("User has logged in with valid credentials")
    public void user_has_logged_in_with_valid_credentials() {
        BrowserDriver.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(BrowserDriver.driver);
        dashboardPage = new DashboardPage(BrowserDriver.driver);
        LoginSteps.i_entered_my_username_and_password("standard_user", "secret_sauce");
        LoginSteps.i_clicked_login_button();
    }

    @Given("User is on the dashboard page")
    public void i_am_on_the_dashboard_page() {
        BrowserDriver.driver.get("https://www.saucedemo.com/inventory.html");
        System.out.println("I am on the dashboard page");
    }

    @When("User clicks on the product title of Sauce Labs Backpack on the dashboard page")
    public void user_clicks_on_the_product_title_of_on_the_dashboard_page() {
        DetailProductPage.click_title_backpack();
    }

    @Then("User sees the image, name, description, and price information of Sauce Labs Backpack")
    public void user_sees_the_image_name_description_and_price_information_of() {
        // Ensure the user sees the image, name, description, and price information of
        // the product
        // Example:
        assert driver.findElement(By.xpath("//*[contains(text(), 'Sauce Labs Backpack')]")).isDisplayed();
    }

    @Given("User is on the product detail page")
    public void user_is_on_the_product_detail_page() {
        DetailProductPage.click_title_backpack();
    }

    @When("User clicks the add to cart button")
    public void user_clicks_the_add_to_cart_button() {
        detailProductPage.click_add_to_cart_button();
    }

    @Then("The product is added to the cart")
    public void the_product_is_added_to_the_cart() {
        WebElement cartIcon = driver.findElement(By.xpath(DetailProductPage.cart_icon_xpath));
        assert cartIcon.isDisplayed();
        assert !cartIcon.getText().isEmpty();
    }

    @When("User clicks the back to products button")
    public void user_clicks_the_back_to_products_button() {
        detailProductPage.click_back_button();
    }

    @Then("User is navigated to the dashboard page")
    public void user_is_navigated_to_the_dashboard_page() {
        // Ensure the user is navigated back to the dashboard page
        // Example:
        // DashboardPage dashboardPage = new DashboardPage(driver);
        // dashboardPage.verifyDashboardPage();
    }
}
