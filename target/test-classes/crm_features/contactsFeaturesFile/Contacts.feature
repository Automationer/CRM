@SmokeTest
@Contacts

Feature: Contacts Features
  Scenario: Contacts Tab contents have to be correctly displayed
    Given User logs into CRM
    When User clicks on Contacts tab
    Then User should verify that the Contacts contents are displayed
