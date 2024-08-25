Feature: Home page

  Scenario: Verify Home page title
    Given I login to magento app using below credentials
      | username           | password    |
      | test1221@gmail.com | Iamtester@1 |
    When I get the title of the current page
    Then I verify title of the page is 'Home Page'

  Scenario: Verify home page top navigation bar pages
    Given I login to magento app using below credentials
      | username           | password    |
      | test1221@gmail.com | Iamtester@1 |
    Then I verify 'top navigation bar' content has 6 page links
    And I verify that 'top navigation bar' has following pages
      | What's New |
      | Women      |
      | Men        |
      | Gear       |
      | Training   |
      | Sale       |

  Scenario: Verify home page footer contents
    Given I login to magento app using below credentials
      | username           | password    |
      | test1221@gmail.com | Iamtester@1 |
    Then I verify 'footer' content has 6 page links
    And I verify that 'footer' has following pages
      | Notes                                |
      | Practice API Testing using Magento 2 |
      | Write for us                         |
      | Subscribe                            |
      | Search Terms                         |
      | Privacy and Cookie Policy            |
      | Advanced Search                      |
