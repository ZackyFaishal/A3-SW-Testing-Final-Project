@Cart
Feature: Cart Feature

  Background:
    Given I am has logged in

  Scenario: Verify Cart Page with 1 Product
    Given I'm on the dashboard page
    And I Add to Cart 1 "Sauce Labs Onesie"
    When I go to The Cart Page
    Then I should see 1 product in the cart


  Scenario: Pressing the Continue Shopping button
    Given I am on the cart page
    When I Clicked Continue Shopping button
    Then I should be on the dashboard page

  Scenario: Pressing Checkout button with 1 product
    Given I'm on the dashboard page
    And I Add to Cart 1 "Sauce Labs Onesie"
    When I go to The Cart Page
    And I should see 1 product in the cart
    And I Clicked Checkout button
    Then I should be on the checkout page