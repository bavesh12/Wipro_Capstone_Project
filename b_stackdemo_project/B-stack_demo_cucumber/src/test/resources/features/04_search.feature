Feature: Search for a product

  Scenario: User searches for Apple products
    Given the user is logged in for search
    When the user searches for "Samsung"
    Then samsung products should be displayed
