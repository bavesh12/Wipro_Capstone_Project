Feature: Login to bstack demo
  Scenario: User logs in with valid credentials
    Given the user is on the bstack demo page
    When the user logs in with valid credentials
    Then the user should be logged in successfully
