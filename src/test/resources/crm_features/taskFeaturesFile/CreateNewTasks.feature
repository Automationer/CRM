@SmokeTest
@RegressionTest
@CreateTask

Feature: Create a new task

  Scenario: User should be able to create a new task on Tasks page
    Given User logs into CRM
    When User clicks on New Tasks option
    And User creates a new task
    Then User should successfully create a new task

