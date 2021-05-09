Feature: run tests with the help of Cucumber

  Scenario Outline: Clickable services buttons
    Given I visit website epam.com
    When I click "<buttons>" button
    Then I should be redirected to appropriate service "<pages>" page
    Examples:
      | buttons      | pages        |
      | SERVICES     | services     |
      | HOW WE DO IT | how-we-do-it |
      | OUR WORK     | our-work     |
      | INSIGHTS     | insights     |
      | ABOUT        | about        |
      | CAREERS      | careers      |

  Scenario: Search request processing
    Given I visit website epam.com
    When I click 'search' button
    And I write 'kubernetes' in special form
    Then I should be redirected to the page of search result

  Scenario: Clickable 'Contact us' link
    Given I visit website epam.com
    When I click 'Contact Us' button
    Then I should be redirected to appropriate service "about/who-we-are/contact" page

  Scenario: Switching the landing page language from English to Polish (careers)
    Given I visit website epam.com
    When I click 'language' button
    And I click 'Polska' button
    Then I should see the page in correct translated Polish language

  Scenario: Checking FAQ
    Given I visit website epam.com
    When I point cursor on 'ABOUT'
    And I click 'FAQ' button
    Then I should be redirected to the page with opened FAQ

  Scenario: Redirecting to 'INFONGEN' link
    Given I visit website epam.com
    When I click 'INFONGEN' button
    Then I should be redirected to the new page 'https://www.infongen.com/'

  Scenario: Checking 'OUR WORK' and 'Explore our latest work' linkages
    Given I visit website epam.com
    When I point cursor on 'OUR WORK'
    And I click 'INSURANCE' button
    Then I should be redirected to appropriate service "our-work/insurance" page
    And I should see the 'EXPLORE OUR LATEST WORK' button

  Scenario: Checking text hover
    Given I visit website epam.com
    When I point cursor on 'OUR WORK'
    And I click 'MEDIA ENTERTAINMENT TELECOM' button
    Then I should be redirected to appropriate service "our-work/media-entertainment-and-telecom" page
    And I point cursor on 'CUSTOMER'
    And I should see image hovered by text