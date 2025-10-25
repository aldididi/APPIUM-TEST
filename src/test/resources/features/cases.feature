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
    And verify on checkout page
    And fill data
  And click payment
  And verify on payment method
  And fill payment data
  And click review order
  And click place order
  And order complete
#    And enter address on address1
#    And enter address on address2
#    And enter city
#    And enter region
#    And enter zipcode
#    And enter country




#    And verify product name Sauce Lab Back Packs
