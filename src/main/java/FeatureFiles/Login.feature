Feature: Login Feature

  Scenario: login scenario
    Given User is on Application login Page
    When user enter user name and password
    And click on login button
    Then User is navigated to Apllication home page
