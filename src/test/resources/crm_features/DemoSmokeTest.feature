@SmokeTest
@DemoSmoke

Feature: Header Tabs

  Scenario: User should be able to Successfully login
    Given User logs into CRM
    And User highlights all header nav tabs
    And User highlights all left side menu lists
    And User highlights Weeks
   And User highlights calendar
    And User hover overs header nav tabs
    And User should be able to create a new deal

  Scenario: User should be able to find cheap flight ticket
    Given User goes to Expedia
    When User searches for a flight ticket from United States to East Turkistan
    Then User should be provided with best deals
