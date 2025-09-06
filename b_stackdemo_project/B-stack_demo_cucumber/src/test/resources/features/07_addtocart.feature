Feature: Add items to cart
  Scenario: User adds products to the cart
    Given the user is logged in for add to cart
    When the user adds products to the cart
    Then the products should appear in the cart
