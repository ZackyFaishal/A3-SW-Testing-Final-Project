@Create
Feature: Testing POST Method for Creating User

  Scenario: Create a user successfully
    Given I have user data to create
    When I send a POST request to create the user
    Then I should receive a success response with status code 200

  Scenario: Attempt to create a user with an email that is already in use
    Given I have user data with an email that is already in use
    When I send a POST request to create the user
    Then I should receive an error response with status code 400

  Scenario: Attempt to create a user with a last name exceeding 50 characters
    Given I have user data with a last name exceeding 50 characters
    When I send a POST request to create the user
    Then I should receive a success response with status code 200

  Scenario: Attempt to create a user with a blank first name
    Given I have user data with a blank first name
    When I send a POST request to create the user
    Then I should receive an error response with status code 400

  Scenario: Attempt to create a user with a blank email
    Given I have user data with a blank email
    When I send a POST request to create the user
    Then I should receive an error response with status code 400

Examples:
  | title | firstName | lastName   | picture | gender | email             | dateOfBirth | phone      | street        | city    | state       | country   | timezone |
  | mr    | Zacky     | Faishal    |         | male   | paisall1@google.com | 2002-06-30 | 0811111111 | 123 Palasari 1 | Bandung | Jawa Barat | Indonesia | -10:00   |
  | mr    | Zacky     | Faishal    |         | male   | paisall1@google.com | 2002-06-30 | 0811111111 | 123 Palasari 1 | Bandung | Jawa Barat | Indonesia | -10:00   |
  | mr    | Zacky     | jekijekijekijekijekijekijekijerrrrrrrrrrrrrrrrrrrr |         | male   | abror12@google.com  | 2002-06-30 | 0811111111 | 123 Palasari 1 | Bandung | Jawa Barat | Indonesia | -10:00   |
  | mr    |           | Faishal    |         | male   | jeki21@google.com | 2002-06-30 | 0811111111 | 123 Palasari 1 | Bandung | Jawa Barat | Indonesia | -10:00   |
  | mr    | Zacky     | Faishal    |         | male   |                   | 2002-06-30 | 0811111111 | 123 Palasari 1 | Bandung | Jawa Barat | Indonesia | -10:00   |
