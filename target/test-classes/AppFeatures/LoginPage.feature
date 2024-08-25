Feature: Login page

  Scenario: Verify login page title
    Given I am on login page of magento application
    When I get the title of the current page
    Then I verify title of the page is 'Customer Login'

  Scenario: Verify user is able to login with correct creadentials
    Given I am on login page of magento application
    When I enter user name 'test1221@gmail.com' and password 'Iamtester@1'
    And I click on 'Sign In' button
    And I get the title of the current page
    Then I verify title of the page is 'Home Page'

  Scenario: Verify user gets error when login with invalid credentials
    Given I am on login page of magento application
    When I enter user name 'test1221@gmail.com' and password 'invalid'
    And I click on 'Sign In' button
    Then I verify that error message is displayed for invalid credentials

  Scenario: Verify user is able to click on Forgot Your Password link
    Given I am on login page of magento application
    And I verify that forgot your password link is displayed
    When I clik on forgot your password link
    And I get the title of the current page
    Then I verify title of the page is 'Forgot Your Password?'
