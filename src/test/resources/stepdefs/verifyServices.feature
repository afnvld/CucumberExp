Feature: Verify Services Dropdown
  Scenario: Services dropdown displayed successfully
    Given user is on the home page "https://www.aviasales.ru/"
    When user clicks on the services button
    Then user should see services dropdown