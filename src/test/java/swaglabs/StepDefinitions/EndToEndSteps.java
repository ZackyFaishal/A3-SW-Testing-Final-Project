package swaglabs.StepDefinitions;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swaglabs.pages.DashboardPage;
import swaglabs.pages.LoginPage;
import swaglabs.pages.CartPage;
import swaglabs.pages.CheckoutStepOne;
import swaglabs.pages.CheckoutStepTwo;
import swaglabs.pages.CheckoutComplete;
import swaglabs.utility.BrowserDriver;

public class EndToEndSteps {
    WebDriver driver = BrowserDriver.driver;
    DashboardPage dashboardPage = new DashboardPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutStepOne checkoutStepOne = new CheckoutStepOne();
    CheckoutStepTwo checkoutStepTwo = new CheckoutStepTwo();
    CheckoutComplete checkoutComplete = new CheckoutComplete();
    LoginPage loginPage;


    @Given("I logged in with valid credentials")
    public void i_have_logged_with_valid_credentials() {
        BrowserDriver.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(BrowserDriver.driver);
        dashboardPage = new DashboardPage (BrowserDriver.driver);
        LoginSteps.i_entered_my_username_and_password("standard_user","secret_sauce");
        LoginSteps.i_clicked_login_button();
    }

    @Given("I am on the dashboard pages")
    public void i_am_on_the_dashboard_pages() {
            BrowserDriver.driver.get("https://www.saucedemo.com/inventory.html");
            System.out.println("I am on the dashboard page");
    }

    @When("I Click Add to Cart button on {string}")
    public void i_click_add_to_cart_button_on(String productName) {
        if(productName.equals("Sauce Labs Onesie")) {
            dashboardPage.click_add_to_cart_onesie();
        }
    }

    @When("I Opened The Cart Page")
    public void i_opened_the_cart_page() {
        dashboardPage.click_shopping_cart();
    }

    @When("I should see the {string} item in the cart")
    public void i_should_see_the_in_the_cart(String productName) {
        cartPage.cartList();
        String cartItems = CartPage.cartList();
        assert cartItems.contains(productName);
    }

    @When("I Click Checkout Button")
    public void i_click_checkout_button() {
        cartPage.click_checkout();
    }

    @When("I Fill The Checkout Information Form with valid data.")
    public void i_fill_the_checkout_information_form_with_valid_data() {
        checkoutStepOne.sendkeys_first_name("John");
        checkoutStepOne.sendkeys_last_name("Doe");
        checkoutStepOne.sendkeys_postal_code("12345");
    }

    @When("I entered first name {string}, last name {string}, postal code {string}")
    public void i_entered_first_name_last_name_postal_code(String firstName, String lastName, String postalCode) {
        checkoutStepOne.sendkeys_first_name(firstName);
        checkoutStepOne.sendkeys_last_name(lastName);
        checkoutStepOne.sendkeys_postal_code(postalCode);
    }

    @When("I Click Continue Button")
    public void i_click_continue_button() {
        checkoutStepOne.click_continue_button();
    }

    @When("I see {string} in the confirmation page")
    public void i_see_in_the_confirmation_page(String productName) {
        String summary = checkoutStepTwo.checkout_summary_container();
        assert summary.contains(productName);
    }

    @When("I Click Finish Button")
    public void i_click_finish_button() {
        checkoutStepTwo.click_finish();
    }

    @When("I should see the confirmation message")
    public void i_should_see_the_confirmation_message() {
        String content = BrowserDriver.driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/div")).getText();
        assertTrue(content.contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
    }

    @Then("I click Back Home button")
    public void i_click_back_home_button() {
        checkoutComplete.click_back_to_products();
    }

    @Then("I should see the dashboard page")
    public void i_should_see_the_dashboard_page() {
        BrowserDriver.driver.get("https://www.saucedemo.com/inventory.html");
        System.out.println("I am on the dashboard page");
    }
}
