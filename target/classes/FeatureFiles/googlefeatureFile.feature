Feature: Google feature

  Scenario Outline: google search scenario
    Given User is on Google home page
    Then verify user is on Google home Page
    Then user entered "<data>" in the search box
    And clicked enter
    Then user is navigated to result page

    Examples: 
      | data     |
      | free CRM |
