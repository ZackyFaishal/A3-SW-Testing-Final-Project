@Update
Feature: Testing PUT Method for Update User

    Scenario: Update user without providing app-id in the header
        Given I have an existing user
        When I update the user without including the app-id in the header
        Then the response body should contain "APP_ID_MISSING"
        And the message status should be 403 Forbidden
        And the database condition should not change
    
    Scenario: Update user by providing wrong app id in header
        Given I have an user
        When I update the user without including the incorrect app-id in the header
        And the message status should be 403 Forbidden
        And the database condition should not change
    
    Scenario: Update user firstName with 2 characters
        Given I have a user registered on the system 
        When I update the user firstName with only 2 characters
        Then I should receive  success response with status code 200
    
    Scenario: Update user firstName with 50 characters
        Given I have a user registered on the system 
        When I update the user firstName with only 50 characters
        Then I should receive  success response with status code 200

    Scenario: Update user data with title and gender fields using numbers
        Given I have a user registered on the system
        When I update the user with title and gender fields using the following data
        | field  | value |
        | title  | 12345 |
        | gender | 67890 |
        Then the message status should be 400 Bad request
        And the database condition should not change