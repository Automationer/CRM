@SmokeTest
@RegressionTest
@CreateContact

Feature: Create a new contact

  Scenario: User should be able to create a new contact on Contacts page
    Given User logs into CRM
    When User clicks on New Contact option
    And User creates a new contact
    Then User should successfully create a new contact

