@contacts @list
Feature: Get one specific contact

  Scenario: Should be able to get the contact
    Given Sam is logged into the application
    When Sam requested the contact service
    Then he should see the contact requested

