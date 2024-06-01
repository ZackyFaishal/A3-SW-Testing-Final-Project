@Get
Feature: Testing GET Method for API

  Scenario: Get user with no app-id
    Given I have no app-id
    When I request user information by ID
    Then I should receive an error with status code 403

  Scenario: Get user with invalid app-id
    Given I have an invalid app-id
    When I request user information by ID
    Then I should receive an error with status code 403

  Scenario: Get user with valid app-id and invalid user ID
    Given I have a valid app-id
    When I request user information by an invalid user ID
    Then I should receive an error with status code 404

  Scenario: Get user with valid app-id and valid user ID
    Given I have a valid app-id
    When I request user information by a valid user ID
    Then I should receive user information with status code 200

  Scenario: Get user with invalid user ID
    Given I have a valid app-id
    When I request user information by an invalid user ID format
    Then I should receive an error with status code 400
