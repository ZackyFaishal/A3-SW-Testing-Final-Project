@Menu
Feature: Menu

    Background:
        Given I have logged in with valid credentials
        Given I am on the dashboard page
    
    Scenario: User opens the navbar menu
        When User click the menu button
        Then Program displays the menu with the following options:
            | All items       |
            | About           |
            | Logout          |
            | Reset App State | 

    Scenario: User select about menu
        When User click the menu button
        And User click the About menu
        Then I should redirects to the information about Swag

    Scenario: User select logout menu
        When User click the menu button
        And User click the logout menu
        Then I should be logout successfully