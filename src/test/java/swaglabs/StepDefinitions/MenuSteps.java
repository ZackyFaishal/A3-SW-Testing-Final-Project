package swaglabs.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import swaglabs.pages.DashboardPage;
import swaglabs.pages.LoginPage;
import swaglabs.pages.MenuPage;
import swaglabs.utility.BrowserDriver;

import io.cucumber.java.en.Then;
//list
import java.util.List;


public class MenuSteps {
    WebDriver driver = BrowserDriver.driver;
    MenuPage menuPage = new MenuPage(driver);
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("i have logged in with valid credentials")
    public void i_have_logged_in_with_valid_credentials() {
        BrowserDriver.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(BrowserDriver.driver);
        dashboardPage = new DashboardPage(BrowserDriver.driver);
        LoginSteps.i_entered_my_username_and_password("standard_user", "secret_sauce");
        LoginSteps.i_clicked_login_button();
    }

    @Given("i'm on the dashboard page")
    public void i_am_on_the_dashboard_page() {
        BrowserDriver.driver.get("https://www.saucedemo.com/inventory.html");
        System.out.println("I am on the dashboard page");
    }

    @When("User click the menu button")
    public void user_clicks_the_menu_button() {
        menuPage.click_hamburger_menu();
    }

    @Then("Program displays the menu with the following options:")
    public void program_displays_the_menu_with_the_following_options(List<String> menuOptions) {
        menuPage.check_menu();
    }

    @When("User click the About menu")
    public void user_click_the_about_menu() {
        menuPage.click_about();
    }

    @Then("I should redirects to the information about Swag")
    public void i_should_redirects_ti_the_information_about_swag() {
        menuPage.check_about();
    }

    @When("User click the logout menu")
    public void user_click_the_logout_menu() {
        menuPage.click_logout();
    }

    @Then("I should be logout successfully")
    public void i_should_be_logout_succesfully() {
        menuPage.check_logout();
    }
}
