Feature: View privacy policy
  Scenario: User opens the privacy policy
    Given the user is logged in for privacy policy
    When the user opens the privacy policy
    Then the privacy policy should be displayed
