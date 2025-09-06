Feature: Filter by vendors
  Scenario: User filters products by vendors
    Given the user is logged in for vendors
    When the user selects Google, Apple, Samsung, and OnePlus
    And then deselects them
    And selects OnePlus again
    Then only OnePlus products should be displayed
 