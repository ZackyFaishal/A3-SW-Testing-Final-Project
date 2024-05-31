package swaglabs.StepDefinitions;

import swaglabs.pages.DashboardPage;
import swaglabs.pages.LoginPage;
import swaglabs.pages.CartPage;
import swaglabs.utility.BrowserDriver;
import swaglabs.utility.Hooks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static swaglabs.pages.LoginPage.*;
import static swaglabs.utility.BrowserDriver.driver;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;


public class DashboardSteps {
    
    LoginPage loginPage;
    DashboardPage dashboardPage;


    @Given("I am has logged in with valid credentials")
    public void login_with_valid_credentials() {
        BrowserDriver.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(BrowserDriver.driver);
        dashboardPage = new DashboardPage (BrowserDriver.driver);
        LoginSteps.i_entered_my_username_and_password("standard_user","secret_sauce");
        LoginSteps.i_clicked_login_button();
    }

     @Given("I am on the dashboard page")
        public void i_am_on_the_dashboard_page() {
        BrowserDriver.driver.get("https://www.saucedemo.com/inventory.html");
        System.out.println("I am on the dashboard page");
    }

     @When("I Clicked Add to Cart button on {string}")
    public void i_clicked_add_to_cart_button_on(String item) {
        switch (item) {
            case "Sauce Labs Onesie":
                DashboardPage.click_add_to_cart_onesie();
                break;
            // Tambahkan case untuk item lain jika diperlukan
        }
    }

    @When("Add to Cart button changes to Remove button")
    public void add_to_cart_button_changes_to_remove_button() {
        assertTrue(driver.findElement(By.id("remove-sauce-labs-onesie")).isDisplayed());
    }

    // @When("The cart icon on the top right of the page will increase according to the selected item")
    // public void the_cart_icon_on_the_top_right_of_the_page_will_increase_according_to_the_selected_item() {
    //     String itemCount = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
    //     assertEquals("1", itemCount);
    // }

    @When("I Open The Cart Page")
    public void i_open_the_cart_page() {
        DashboardPage.click_shopping_cart();
    }

    @Then("I should see the {string} in the cart")
    public void i_should_see_the_in_the_cart(String item) {
        String cartContents = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]")).getText();
        assertTrue(cartContents.contains(item));
    }

    @When("I Clicked Add to Cart button for all items")
    public void i_clicked_button_for_all_items() {
        DashboardPage.click_add_to_cart_onesie();
        DashboardPage.click_add_to_cart_bike_light();
        DashboardPage.click_add_to_cart_bolt_t_shirt();
        DashboardPage.click_add_to_cart_fleece_jacket();
        DashboardPage.click_add_to_cart_red_t_shirt();
    }

    @When("All Add to Cart button changes to Remove button")
    public void all_add_to_cart_button_changes_to_remove_button() {
        assertTrue(driver.findElement(By.id("remove-sauce-labs-onesie")).isDisplayed());
        assertTrue(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed());
        assertTrue(driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).isDisplayed());
        assertTrue(driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).isDisplayed());
        assertTrue(driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).isDisplayed());
    }

    @Then("I should see all items in the cart")
    public void i_should_see_all_items_in_the_cart() {
        String cartContents = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]")).getText();
        assertTrue(cartContents.contains("Sauce Labs Onesie"));
        assertTrue(cartContents.contains("Sauce Labs Bike Light"));
        assertTrue(cartContents.contains("Sauce Labs Bolt T-Shirt"));
        assertTrue(cartContents.contains("Sauce Labs Fleece Jacket"));
        assertTrue(cartContents.contains("Test.allTheThings() T-Shirt (Red)"));
    }

    @When("I Click Remove button for all items")
    public void i_clicked_remove_button_for_all_items() {
        DashboardPage.click_remove_from_cart_onesie();
        DashboardPage.click_remove_from_cart_bike_light();
        DashboardPage.click_remove_from_cart_bolt_t_shirt();
        DashboardPage.click_remove_from_cart_fleece_jacket();
        DashboardPage.click_remove_from_cart_red_t_shirt();
    }

    @Then("I should not see all items in the cart")
    public void i_should_not_see_all_items_in_the_cart() {
        String cartContents = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]")).getText();
        assertFalse(cartContents.contains("Sauce Labs Onesie"));
        assertFalse(cartContents.contains("Sauce Labs Bike Light"));
        assertFalse(cartContents.contains("Sauce Labs Bolt T-Shirt"));
        assertFalse(cartContents.contains("Sauce Labs Fleece Jacket"));
        assertFalse(cartContents.contains("Test.allTheThings() T-Shirt (Red)"));
    }
}
