@contacts @delete
Feature: Delete a contact

  Scenario: Should be able to delete the contact
    Given Sam requested the add contact service
    And he should see the newly created contact
    When Sam try to delete the contact
    Then he should see the contact was deleted

