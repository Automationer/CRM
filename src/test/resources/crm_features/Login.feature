@LoginTest

Feature: Login

  Scenario: User should be able to Successfully login
    Given User goes to CRM
    When User enters valid credentials
    Then User should successfully log into CRM

