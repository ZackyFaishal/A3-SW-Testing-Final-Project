@EndToEnd
Feature: End To End Testing

  Scenario: End To End Testing
    Given I logged in with valid credentials
    Given I am on the dashboard pages
    When I Click Add to Cart button on "Sauce Labs Onesie"
    And I Opened The Cart Page
    And I should see the "Sauce Labs Onesie" item in the cart
    And I Click Checkout Button
    And I Fill The Checkout Information Form with valid data.
    And I entered first name "Zacky", last name "Faishal", postal code "12345"
    And I Click Continue Button
    And I see "Sauce Labs Onesie" in the confirmation page 
    And I Click Finish Button
    And I should see the confirmation message
    Then I click Back Home button
    Then I should see the dashboard page