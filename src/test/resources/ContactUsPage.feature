Feature: Contact us page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services!!

  Scenario: Valid Submission
    Given I am on the QAWorks Site
    Then I should be able to contact QAWorks with the following information
      | name    | j.Bloggs                              |
      | email   | j.Bloggs@qaworks.com                  |
      | message | please contact me I want to know more |


  Scenario Outline: Invalid submission with wrong email format
    Given I am on the QAWorks Site
    When I try to contact QAWorks with name: "j.Bloggs" , message:"please contact me" and invalid email:"<email>"
    Then an error message for invalid email address should appear
    And my contact form should not be sent if I click the Send button

    Examples:
      | email           |
      | j.Bloggs        |
      | jBloggs@qaworks |
      | @qaworks.com    |


  Scenario Outline: Invalid Submission
    Given I am on the QAWorks Site
    Then I should not be able to contact QAWorks with missing data like name: "<name>", email: "<email>" and message: "<message>"
    Examples:
      | name     | email                | message                                   |
      |          |                      |                                           |
      |          | j.Bloggs@qaworks.com | please contact me I want to find out more |
      | j.Bloggs |                      | please contact me I want to find out more |
      | j.Bloggs | j.Bloggs@qaworks.com |                                           |