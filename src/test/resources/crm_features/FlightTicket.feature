@SmokeTest
@DemoSmoke
@Flight

Feature: Search for flight tickets

  Scenario: User should be able to find cheap flight ticket
    Given User goes to Hipmunk
    When User searches for a flight ticket from VA to CA
    Then User should be provided with best deals
