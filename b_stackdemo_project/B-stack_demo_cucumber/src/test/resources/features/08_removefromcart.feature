Feature: Remove from cart

  Scenario: User removes products from the cart
    Given the user is logged in for remove from cart
    Given the user adds a product to the cart
    When the user removes products from the cart
    Then the cart should be empty
 