@contacts @update
Feature: Update a new contact information

  Scenario: Should be able to update the contact information
    Given Sam requested the add contact service
    And he should see the newly created contact
    When Sam try to update the contact
    Then he should see the contact updated

