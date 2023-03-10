Feature: Swag labs order test with different users

  Scenario: Order test by standard_user
    Given I am on log in page
    Then I type standard user name
    And I type standard user password
    Then I click to log in button
    When Page 'Product' should be open
    Then I click 'Add to cart' standard user's products according date base
    And I click to cart icon button on top bar menu
    When Page 'Your cart' should be open
    And In cart should be standard user's products
    Then I click to 'Checkout' button
    When Page 'Checkout: Your Information' should be open
    Then I fill all necessary information to continue order
    And I click to 'Continue' button
    When Page 'Checkout: Overview' should be open
    Then I click to 'Finish' button
    When Page 'Checkout: Complete!' should be open
    Then I see complete text about order


  Scenario: Order test by locked out user
    Given I am on log in page
    Then I type locked out user name
    And I type locked out user password
    Then I click to log in button
    But Page 'Product' should not be open
    And I see text that user is locked out


  Scenario: Order test by problem user
    Given I am on log in page
    Then I type problem user name
    And I type problem user password
    Then I click to log in button
    When Page 'Product' should be open
    Then I click 'Add to cart' problem user's products according date base
    And I click to cart icon button on top bar menu
    When Page 'Your cart' should be open
    But In cart should not be problem user's all products
    Then I click to 'Checkout' button
    When Page 'Checkout: Your Information' should be open
    Then I can fill in all necessary information besides 'Last Name'





