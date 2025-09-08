Feature: Checkout process

  Scenario Outline: User proceeds to checkout
    Given the user is logged in for checkout
    When the user adds items and proceeds to checkout "<firstname>" "<lastname>" "<address>" "<state>" "<postcode>"
    Then the order should be placed successfully

    Examples:
      | firstname | lastname   | address   | state     | postcode |
      | sai bavesh| vellampalli| hyderabad | Telengana | 500008   |
