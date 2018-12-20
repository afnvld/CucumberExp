Feature: Search Ticket
  Scenario: User searches for a business class avia ticket
    Given user is on the home page "https://www.aviasales.ru/"
    When user sets depart point
    And user sets destination point
    And user sets depart date
    And user sets destination date
    And user sets number of passengers
    And user sets class
    And user start the search
    Then user should be redirected to avia tickets page