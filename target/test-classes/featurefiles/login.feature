#Author: sabyasachibhunia@gmail.com
@cybr
Feature: Log in to specops application

  @login
  Scenario Outline: As an admin, I can login to specops application
    Given I am an admin with <userid> and <password>
    When I click on login button
    Then I logged into the dashboard

    Examples: 
      | userid        | password       |
      | administrator | xisE4P5DsjT4Hq |

  @login
  Scenario Outline: Verify application menu after login
    Given I am an admin with <userid> and <password>
    When I click on login button
    Then I logged into the dashboard
    And I verify the navigation menus

    Examples: 
      | userid        | password       |
      | administrator | xisE4P5DsjT4Hq |
