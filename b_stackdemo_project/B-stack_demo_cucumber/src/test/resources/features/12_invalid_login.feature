Feature: Invalid login on bstack demo
  Scenario: User enters wrong credentials
    Given the user is on the bstack demo page for invalid login
    When the user tries to login with invalid credentials
    Then an error message should be shown
