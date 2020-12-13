#Author: sabyasachibhunia@gmail.com
@cybr
Feature: Verify specops application blogs

  @blog
  Scenario Outline: As an admin, I can verify blogs in specops application
    Given I am an admin with <userid> and <password>
    When I click on login button
    Then I logged into the dashboard
    When I click on blog menu
    Then I can see <subject> blogs

    Examples: 
      | userid        | password       | subject |
      | administrator | xisE4P5DsjT4Hq | Cybr    |
