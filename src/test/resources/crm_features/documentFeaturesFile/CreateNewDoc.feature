@SmokeTest
@CreateNewDocTest
Feature: Create new Document

  Scenario: User should be able to create new document
    Given User logs into CRM
    When User clicks on Docs button and New Document button
    And User fills up the form
    Then User should successfully save the document