@contacts @smoke @updateattribute
Feature: Update a new contact information

  Scenario: Should be able to update just one attribute of the contact
    Given Sam requested the add contact service
    And he should see the newly created contact
    When Sam try to update just one attribute of the contact
    Then he should see the contact updated

