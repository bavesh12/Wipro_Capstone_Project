Feature: Add products to favourites
  Scenario: User adds product to favourites
    Given the user is logged in for favourites
    When the user adds a product to favourites
    Then the product should be in the favourites list
