@SmokeTest
@Tasks

Feature: Task Features
  Scenario: Task Tab contents have to be correctly displayed
    Given User logs into CRM
    When User clicks on Tasks tab
    Then User should verify that the Tasks contents are displayed
