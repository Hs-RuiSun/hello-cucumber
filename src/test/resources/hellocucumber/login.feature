Feature: login in
  I want to use this template for my feature file

  Scenario: login with valid credentials
    Given I am on the login page
    When I login using "userGFI" and "gfi2015"
    Then I should be on the "USER" home page
