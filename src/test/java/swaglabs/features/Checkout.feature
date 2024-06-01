@Checkout
Feature: Checkout Feature

  Background:
    Given I am has logged in
    Given I'm on the dashboard page
    Given I Add to Cart 1 "Sauce Labs Onesie"
    Given I go to The Cart Page
    Given I should see 1 product in the cart
    Given I Clicked Checkout button

  Scenario: Go to Next Page
    Given I'm on the checkout your information page
    When I entered my first name "Lebron", last name "james", and postal code "40121"
    And I Clicked Continue button
    Then I should be on the checkout overview page

  Scenario: Go to Previous Page
    Given I'm on the checkout your information page
    When I Clicked Cancel button
    Then I should be on the cart page

  Scenario: Go to Next Page with only fill Postal Code
    Given I'm on the checkout your information page
    When I entered my first name "", last name "", and postal code "40121"
    And I Clicked Continue button
    Then It should be to see the error message "First Name and Last Name is required!"