package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pages.CartPage;
import swaglabs.pages.DashboardPage;
import swaglabs.pages.LoginPage;
import swaglabs.utility.BrowserDriver;

import static org.junit.Assert.assertEquals;
import static swaglabs.utility.BrowserDriver.driver;

public class CartSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CartPage cartPage;

    @Given("I am has logged in")
    public void iAmHasLoggedIn(){
        BrowserDriver.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(BrowserDriver.driver);
        cartPage = new CartPage(BrowserDriver.driver);
        dashboardPage = new DashboardPage(BrowserDriver.driver);
        LoginSteps.i_entered_my_username_and_password("standard_user","secret_sauce");
        LoginSteps.i_clicked_login_button();
    }

    @Given("I am on the cart page")
    public void iAmOnTheCartPage() {
        BrowserDriver.driver.get("https://www.saucedemo.com/cart.html");
        System.out.println("I am on the cart page");
    }

    @When("I Clicked Continue Shopping button")
    public void iClickedContinueShoppingButton() {
        CartPage.click_continue_shopping();
    }

    @Then("I should be on the dashboard page")
    public void iShouldBeOnTheDashboardPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
    }

    @Given("I'm on the dashboard page")
    public void iMOnTheDashboardPage() {
        BrowserDriver.driver.get("https://www.saucedemo.com/inventory.html");
        System.out.println("I am on the dashboard page");
    }

    @And("I Add to Cart 1 {string}")
    public void iAddToCartSauceLabsOnesie(String product) {
        DashboardPage.click_add_to_cart_onesie();
    }

    @When("I go to The Cart Page")
    public void iGoToTheCartPage() {
        BrowserDriver.driver.get("https://www.saucedemo.com/cart.html");
        System.out.println("I am on the cart page");
    }

    @Then("I should see {int} product in the cart")
    public void iShouldSeeProductInTheCart(int total) {
        CartPage.cartListTotal(total);
    }

    @And("I Clicked Checkout button")
    public void iClickedCheckoutButton() {
        CartPage.click_checkout_shopping();
    }

    @Then("I should be on the checkout page")
    public void iShouldBeOnTheCheckoutPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/checkout-step-one.html", currentUrl);
    }
}
