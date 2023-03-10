Feature: Swag labs order test with different users


  Scenario: Swag lab order test by standard_user
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





