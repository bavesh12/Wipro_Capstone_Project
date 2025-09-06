Feature: Checkout process
  Scenario: User proceeds to checkout
    Given the user is logged in for checkout
    When the user adds items and proceeds to checkout
    Then the order should be placed successfully
