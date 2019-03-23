@SmokeTest
@RegressionTest
@CreateTask

Feature: Create a new task

  Scenario: User should be able to create a new contact on Contacts page
    Given User logs into CRM
    When User clicks on New Task option
    And User creates a new task
    Then User should successfully create a new task

