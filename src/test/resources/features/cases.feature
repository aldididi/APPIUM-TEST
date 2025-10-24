Feature: Checkout

  Scenario: Checkout from search result product
    Given user on Search Result Product
    And click hamburger
    And click login
    #And on login page
    And fill credential
      | email            | password |
      | bod@example.com  | 10203040 |
      | alice@example.com| 10203040 |
   # And login
    And Sauce Lab Back Packs
    And select gray color
    And scroll little bit

    And click add to cart
  #  And verify cart is updated
  #  And click cart icon
#    And verify color is "grey"
#    And verify product name Sauce Lab Back Packs
