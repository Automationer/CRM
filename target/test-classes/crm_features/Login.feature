@SmokeTest
@LoginFeature

Feature: Login   Gherkin language

  Scenario: User should be able to Successfully login with valid username and password
    Given User goes to CRM
    When User enters valid credentials
    Then User should successfully log into CRM


  Scenario: User should not be able to login with valid username and invalid password
    Given User goes to CRM
    When User enters valid credentials
    Then User should successfully log into CRM