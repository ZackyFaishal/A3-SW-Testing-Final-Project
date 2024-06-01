package swaglabs.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pages.CheckoutPage;
import swaglabs.utility.BrowserDriver;

import static org.junit.Assert.assertEquals;
import static swaglabs.utility.BrowserDriver.driver;

public class CheckoutSteps {
    CheckoutPage checkoutPage;
    
    @Given("I'm on the checkout your information page")
    public void imOnTheCheckoutYourInformationPage(){
        BrowserDriver.driver.get("https://www.saucedemo.com/checkout-step-one.html");
        checkoutPage = new CheckoutPage(BrowserDriver.driver);
        System.out.println("I am on the checkout: your information page");

    }

    @When("I entered my first name {string}, last name {string}, and postal code {string}")
    public void iEnteredMyFirstNameLastNameAndPostalCode(String firstname, String lastname, String postalcode) {
        CheckoutPage.sendkeys_firstName(firstname);
        CheckoutPage.sendkeys_lastName(lastname);
        CheckoutPage.sendkeys_postalcode(postalcode);
    }

    @And("I Clicked Continue button")
    public void iClickedContinueButton() {
        CheckoutPage.click_continue();
    }

    @Then("I should be on the checkout overview page")
    public void iShouldBeOnTheCheckoutOverviewPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/checkout-step-two.html", currentUrl);
    }

    @When("I Clicked Cancel button")
    public void iClickedCancelButton() {
        CheckoutPage.click_cancel();
    }

    @Then("I should be on the cart page")
    public void iShouldBeOnTheCartPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/cart.html", currentUrl);
    }

    @Then("It should be to see the error message {string}")
    public void itShouldBeToSeeTheErrorMessage(String message) {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/checkout-step-one.html", currentUrl);
        CheckoutPage.get_error_message(message);

    }
}
