@Dashboard
Feature: Dashboard Feature

  Background:
    Given I am has logged in with valid credentials
    Given I am on the dashboard page

  Scenario: Add One Item to Cart
    When I Clicked Add to Cart button on "Sauce Labs Onesie"
    And Add to Cart button changes to Remove button
  #And The cart icon on the top right of the page will increase according to the selected item.
    And I Open The Cart Page
    Then I should see the "Sauce Labs Onesie" in the cart

  Scenario: Add All Items to Cart
    When I Clicked Add to Cart button for all items
    And All Add to Cart button changes to Remove button
  #And The cart icon on the top right of the page will increase according to the selected item.
    And I Open The Cart Page
    Then I should see all items in the cart

  Scenario: Remove One Item on Cart
    When I Clicked Add to Cart button for all items
    And Add to Cart button changes to Remove button
    And I Click Remove button for all items
  # And The cart icon on the top right of the page will increase according to the selected item.
    And I Open The Cart Page
    Then I should not see all items in the cart
