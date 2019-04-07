@SmokeTest
@DemoSmoke
@crm

Feature: Header Tabs

  Scenario: User should be able to Successfully login
    Given User logs into CRM
    And User highlights all header nav tabs
    And User highlights all left side menu lists
    And User highlights Weeks
    And User highlights calendar
    And User hover overs header nav tabs
    And User should be able to create a new deal
  #  And User should verify left menu pages
