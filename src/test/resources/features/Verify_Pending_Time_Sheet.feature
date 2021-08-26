@timesheet
Feature: This feature is to get Pending Timesheet
  Scenario Outline: This is to verify the Pending Timesheet
    Given user is on home page
    And the user clicks on the timesheet option from menu
    And user enters the name as "John Smith"
    And user clicks on view button
    Then user should see the message as "<message>"
    Examples:
      |message|
      |No Timesheets found|