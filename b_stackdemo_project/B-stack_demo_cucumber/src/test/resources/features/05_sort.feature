Feature: Sort products
  Scenario: User sorts products by lowest price
    Given the user is logged in for sort
    When the user sorts products by lowest price
    Then products should be displayed in sorted order
 