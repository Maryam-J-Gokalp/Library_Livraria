Feature: Library app login feature
  User Story:
  As a user, I should be able to login with
  correct
  credentials to different accounts

  Background: Assuming user is on the login page
    Given user is on the login page

  @wip2
  Scenario: Login as librarian
    When user enters librarian username "librarian24@library "
    And user enters librarian password "8v8ZByKA"
    Then user should see the dashboard

  @wip
  Scenario: Login as student
    When user enters student username "library"
    And user enters student password "QfYjDNXj"
    Then user should see the dashboard


  @4
  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian1@library" and "qU9mrvur"
    Then dashboard should be displayed
    And there should be 144 'users'
 #number can be whatever you have there
