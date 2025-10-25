Feature: Checkout

  Scenario: Checkout from search result product
    Given user on Search Result Product
   # And click hamburger
    #And click login

    And Sauce Lab Back Packs
    And select gray color
    And scroll little bit

    And click add to cart
    And click cart icon
    And go to checkout page
    And check product
    And click checkout
    And on login page
    And fill credential
    And login
#    And verify product name Sauce Lab Back Packs
