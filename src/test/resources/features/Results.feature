Feature: Mercado libre results

  Some tests to mercado libre results

  Scenario: User is able to get results using search criteria
    Given the user navigates to home page
    When user performs a search using "Camiseta"
    Then user is able to save results into a CSV file