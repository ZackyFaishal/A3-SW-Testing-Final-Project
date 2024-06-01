@Delete
  Feature: Testing DELETE Method for Deleting User

    Scenario: Delete User without app-id
      Given  I don't have app-id
      When  I send a DELETE request with ID "665ab7f34c88d3f49c087ae8"
      Then I should receive error with status code 403

    Scenario: Delete User with a invalid app-id
      Given I have a invalid app-id "662e51efbb70a7543a259560eeee"
      When  I send a DELETE request with ID "665ab7f34c88d3f49c087ae8"
      Then I should receive error with status code 403

    Scenario: Delete User with a valid ID
      Given I have a valid app-id "662e51efbb70a7543a259560"
      When I send a DELETE request with ID "665ab9294c88d30fae087b35"
      Then I should receive success with status code 200

    Scenario: Delete User with a invalid ID
      Given I have a valid app-id "662e51efbb70a7543a259560"
      When I send a DELETE request with ID "665ab8824c88d3a3e7087b0d321"
      Then I should receive error with status code 400

    Scenario: Delete User without ID
      Given I have a valid app-id "662e51efbb70a7543a259560"
      When I send a DELETE request without ID
      Then I should receive error with status code 404