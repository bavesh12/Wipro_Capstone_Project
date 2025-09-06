Feature: View offers
  Scenario: User checks available offers
    Given the user is logged in for offers
    When the user navigates to offers
    Then offers should be displayed
