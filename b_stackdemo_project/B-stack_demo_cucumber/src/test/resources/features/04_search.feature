Feature: Search for a product

  Scenario Outline: User searches for different products
    Given the user is logged in for search
    When the user searches for "<product>"
    Then the results for "<product>" should be displayed

    Examples:
      | product   |
      | Samsung   |
      | OnePlus   |
      | iPhone    |
      | Pixel     |
