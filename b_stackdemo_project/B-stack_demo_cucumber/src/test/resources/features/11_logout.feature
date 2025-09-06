Feature: Logout
  Scenario: User logs out
    Given the user is logged in for logout
    When the user logs out
    Then the user should be logged out successfully
