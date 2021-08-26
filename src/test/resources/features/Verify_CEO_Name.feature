@CEOname
Feature: This feature to get the CEO of OrangeHRM app
  Scenario Outline: This is to verify CEO name
    Given User Logged in successfully on app
    When User click director option from Menu bar
    And the user select 'Chief Executive Officer' from the dropdown
    And click the search button
    Then user should see the CEO name "<CEO_NAME>"
    Examples:
      |CEO_NAME|
      |John Smith|
